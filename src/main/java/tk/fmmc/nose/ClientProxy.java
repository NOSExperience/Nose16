package tk.fmmc.nose;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tk.fmmc.nose.web.Downloader;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) throws Exception {
		super.preInit(e);
		
		Downloader.downloadAll("http://localhost/nosemod/");
		
		Discoverer ds = new Discoverer();
		ds.run();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}
