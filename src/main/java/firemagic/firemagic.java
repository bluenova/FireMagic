package firemagic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bluenova.fairytailcraft.event.MageEventType;
import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;
import firemagic.magics.fire;
import firemagic.magics.fireball;

/**
 *
 * @author Sven
 */
public class firemagic implements MagePlugin {
    private String magicName = "FireMagic";
    private MagePluginManager manager;
    public void setPluginManager(MagePluginManager manager) {
        this.manager = manager;
    }

    public void loadPlugin() {
        this.manager.registerMagic("fire", magicName, 1, 10, new fire(), MageEventType.INTERACT, false);
        //this.manager.registerMagic("fireball", magicName, 1, 50, new fireball(), MageEventType.INTERACT, false);
        System.out.println("FireMagic Successfully Load!");
    }

    public void unloadPlugin() {
        System.out.println("FireMagic Successfully Unload!");
    }

    public String getMagicName() {
        return magicName;
    } 
}
