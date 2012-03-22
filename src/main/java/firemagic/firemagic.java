package firemagic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bluenova.fairytailcraft.event.MageEventType;
import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;
import firemagic.magics.Fire;
import firemagic.magics.Fireball;

/**
 *
 * @author Sven
 */
public class FireMagic implements MagePlugin {
    
    private String magicName = "FireMagic";
    private MagePluginManager manager;
    
    public void setPluginManager(MagePluginManager manager) {
        this.manager = manager;
    }

    public void loadPlugin() {
        this.manager.registerMagic("fire", magicName, 1, 10, new Fire(), MageEventType.INTERACT, false,new Long(2000));
        //this.manager.registerMagic("fireball", magicName, 1, 50, new Fireball(), MageEventType.INTERACT, false,new Long(3000));
        System.out.println("FireMagic Successfully Load!");
    }

    public void unloadPlugin() {
        System.out.println("FireMagic Successfully Unload!");
    }

    public String getMagicName() {
        return magicName;
    } 
}
