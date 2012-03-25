/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firemagic.magics;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import java.util.Collection;
import java.util.HashMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Fireball;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

/**
 *
 * @author Denny
 */
public class BigFireballMagic extends MagePluginEvent {

    HashMap<Player, Boolean> shotFireball = new HashMap<Player, Boolean>();

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        Player user = event.getPlayer();
        final Vector direction = user.getEyeLocation().getDirection().multiply(2);
        Fireball fireball = user.getWorld().spawn(user.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Fireball.class);
        fireball.setShooter(user);
        event.getPlayer().sendMessage("Mana decreesed!");
        shotFireball.put(event.getPlayer(), true);
        return true;
    }

    @Override
    public boolean callEntityHitByProjectilEvent(ProjectileHitEvent event, Integer level) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            if (shotFireball.containsKey(shooter)) {
                if (shotFireball.get(shooter) == true) {
                    if (event.getEntity() instanceof Fireball) {
                        Fireball proj = (Fireball) event.getEntity();
                        Entity tar = proj.getNearbyEntities(1, 1, 1).get(0);
                        if (tar instanceof LivingEntity) {
                            LivingEntity target = (LivingEntity) tar;
                            Collection<PotionEffect> activePotionEffects = target.getActivePotionEffects();
                            boolean noFire = false;
                            for (PotionEffect pe : activePotionEffects) {
                                if (pe.getType() == PotionEffectType.FIRE_RESISTANCE) {
                                    noFire = true;
                                    break;
                                }
                            }
                            if (!noFire) {
                                target.setFireTicks(6);
                                target.damage(6, shooter);
                                shotFireball.put(shooter, false);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
