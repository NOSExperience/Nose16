package tk.fmmc.nose;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
	
public class CommandRestart implements ICommand{
	
	private final List<String> aliases;
	
	public CommandRestart(){
		aliases = new ArrayList<String>();
		//aliases.add("restart");
		aliases.add("setblock");
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		//return "restart";
		return "setblock";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "restart";
	}

	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		icommandsender.sendChatToPlayer(new ChatMessageComponent().addText("test3"));
		
		icommandsender.sendChatToPlayer(new ChatMessageComponent().addText(icommandsender.getCommandSenderName()));
		
		ChunkCoordinates cc = icommandsender.getPlayerCoordinates();
		
		World w = icommandsender.getEntityWorld();
		w.setBlock(cc.posX, cc.posY, cc.posZ, 4005);
		//Minecraft.getMinecraft().shutdown();
		//Minecraft.stopIntegratedServer();
		//MinecraftServer.getServer().initiateShutdown();
		//MinecraftServer.getServer().stopServer();
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
