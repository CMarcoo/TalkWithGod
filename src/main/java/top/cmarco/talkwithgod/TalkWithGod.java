package top.cmarco.talkwithgod;

import org.bukkit.plugin.java.JavaPlugin;

public final class TalkWithGod extends JavaPlugin {

    public static final CharSequence PREFIX = "§7[§dTalkWithGod§7]§f: §7";

    private KingJamesBible kjv;
    private TalkWithGodCommand twgCommand;

    private void initialiseBible() {
        this.kjv = new KingJamesBible(this);
        this.kjv.load();
    }

    private void initialiseCommands() {
        this.twgCommand = new TalkWithGodCommand(this);
        getServer().getPluginCommand("talkwithgod").setExecutor(this.twgCommand);
    }

    @Override
    public void onEnable() { // Plugin startup logic
        initialiseBible();
        initialiseCommands();
    }

    public KingJamesBible getKjv() {
        return kjv;
    }
}
