package firemagic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bluenova.fairytailcraft.event.MageEventType;
import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;
import firemagic.magics.BigFireballMagic;
import firemagic.magics.Fire;
import firemagic.magics.FireImmunity;
import firemagic.magics.HeatWeave;
import firemagic.magics.Lava;
import firemagic.magics.SmallFireballMagic;
import firemagic.magics.SummonFire;
import firemagic.magics.SummonLava;

/**
 *
 * @author Sven
 */
public class FireMagic implements MagePlugin {
    
    private String magicName = "FireMagic";
    public static MagePluginManager manager;
    
    public void setPluginManager(MagePluginManager manager) {
        FireMagic.manager = manager;
    }

    public void loadPlugin() {
        FireMagic.manager.registerMagic("fire", magicName, 1, 10, new Fire(), MageEventType.INTERACT, false,new Long(2000));
        FireMagic.manager.registerMagic("fireimmunity", magicName, 6, 15, new FireImmunity(), MageEventType.INTERACT, false,new Long(0));
        FireMagic.manager.registerMagic("summonfire", magicName, 8, 13, new SummonFire(), MageEventType.INTERACT, false,new Long(3000));
        FireMagic.manager.registerMagic("smallfireball", magicName, 12, 20, new SmallFireballMagic(), MageEventType.INTERACT, false,new Long(3000));
        FireMagic.manager.registerMagic("fireball", magicName, 22, 30, new BigFireballMagic(), MageEventType.INTERACT, false,new Long(3000));
        FireMagic.manager.registerMagic("lava", magicName, 24, 32, new Lava(), MageEventType.INTERACT, false,new Long(3000));
        FireMagic.manager.registerMagic("summonlava", magicName, 30, 38, new SummonLava(), MageEventType.INTERACT, false,new Long(3000));
        FireMagic.manager.registerMagic("heatwave", magicName, 60, 100, new HeatWeave(), MageEventType.INTERACT, false,new Long(3600000));
        System.out.println("FireMagic Successfully Load!");
    }

    public void unloadPlugin() {
        System.out.println("FireMagic Successfully Unload!");
    }

    public String getMagicName() {
        return magicName;
    } 
}
