package tk.fmmc.nose;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
	public static final String MODID = "nose";
	public static final String MODNAME = "Dynamic Mod";
	public static final String VERSION = "0.1";
	
	@SidedProxy(clientSide = "tk.fmmc.nose.ClientProxy", serverSide = "tk.fmmc.nose.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	void preInit(FMLPreInitializationEvent e) throws Exception {
		proxy.preInit(e);
	}
	
	@EventHandler
	void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandRestart());
	}
}
