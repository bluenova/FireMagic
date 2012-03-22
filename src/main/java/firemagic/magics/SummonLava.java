/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firemagic.magics;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Denny
 */
public class SummonLava extends MagePluginEvent {
    
    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR ) {
            ItemStack item = event.getItem();
            if(item == null) {
                item = new ItemStack(Material.LAVA, 64);
                event.getPlayer().setItemInHand(item);
                return true;
            }
        }
        return false;
    }
}
