package tk.fmmc.nose;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tk.fmmc.nose.web.Downloader;

public class ClientProxy extends CommonProxy {
	
	private static final String URL_STR = "http://localhost/nosemod/";
	
	@Override
	public void preInit(FMLPreInitializationEvent e) throws Exception {
		super.preInit(e);
		
		Downloader.preInit(URL_STR);
		
		Discoverer ds = new Discoverer();
		ds.run();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) throws Exception {
		super.postInit(e);
		
		Downloader.postInit(URL_STR);
	}
}
