/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firemagic.magics;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Denny
 */
public class Lava extends MagePluginEvent {
    
    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {      
        ItemStack item = event.getItem();      
        if(item == null && event.getAction() == Action.RIGHT_CLICK_BLOCK) {    
            Player player = event.getPlayer();
            Location location = player.getTargetBlock(null, 30).getLocation();
            Block lavaBlock = new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 1, location.getBlockZ()).getBlock();     
            if (lavaBlock.getType() == Material.AIR) {
                lavaBlock.setType(Material.LAVA);
                event.getPlayer().sendMessage("Mana decreesed!");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
