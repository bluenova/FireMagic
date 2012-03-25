/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firemagic.magics;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 *
 * @author Sven
 */
public class FireImmunity extends MagePluginEvent {

    @Override
    public boolean callEntityDamageEvent(EntityDamageEvent event, Integer level) {
        if(event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK && event.getDamage() > 0) {
            if(event.getEntity() instanceof Player) {
                Player pl = (Player) event.getEntity();
                int playerLevel = firemagic.FireMagic.manager.getPlayerConfig(pl).getLevel();
                if(playerLevel < 6)
                    return false;
                event.setCancelled(true);
                pl.sendMessage("Mana Decreesed by passive!");
                return true;
            }
        }
        return false;
    }
}
