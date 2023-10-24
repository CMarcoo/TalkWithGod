package top.cmarco.talkwithgod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public final class TalkWithGodCommand implements CommandExecutor {

    private final HashMap<UUID, ArrayList<String>> questionsMap = new HashMap<>(1);
    private final TalkWithGod talkWithGod;
    private final GodValues godValues = new GodValues();

    public TalkWithGodCommand(TalkWithGod talkWithGod) {
        this.talkWithGod = talkWithGod;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length < 0x3) {
            commandSender.sendMessage(TalkWithGod.PREFIX + "You need to write more to speak with God.");
            return false;
        } else {
            final String joined = String.join("", strings);

            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                UUID uuid = player.getUniqueId();
                if (questionsMap.containsKey(uuid)) {
                    ArrayList<String> prevQuestions = questionsMap.get(uuid);
                    boolean match = prevQuestions.stream().anyMatch(str -> str.toLowerCase(Locale.ROOT).equals(joined.toLowerCase(Locale.ROOT)));
                    if (match) {
                        player.sendMessage(TalkWithGod.PREFIX + "Do not ask GOD the same question twice!");
                        return false;
                    } else {
                        prevQuestions.add(joined);
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(joined);
                    questionsMap.put(uuid, arrayList);
                }
            }

            final char[] chars = joined.toCharArray();
            int ss = 0x00;
            for (final char c : chars) ss+=(c + godValues.get(0xff));
            final int maxL = talkWithGod.getKjv().getLength();
            int k = 0x0;
            long lcv = 0x0L;

            int k_1 = 0;
            while (ss >= maxL && ++k_1 <= 0xABCDEp-5d) {
                if (ss <= maxL) {
                    int kz = 0;
                    loop:
                    do {
                        ++kz;
                        ss = (int) ((double) ss * ((godValues.getD(0x05)) + godValues.getD(0x1)));
                        if (kz > 0xFFAFFp-9d) {
                            ss = godValues.get(talkWithGod.getKjv().getLength());
                            break loop;
                        }
                    } while (ss >= maxL);
                }

                while (lcv++ < 0x7ffffffffffffffeL && ss >= maxL && ++k < 0xA) {
                    ss >>= 0x1 + godValues.get(0xA);
                    if (k == 0x9) ss = (int) (godValues.getD(maxL));
                }
            }

            if ((ss = Math.abs(ss)) >= maxL) {
                commandSender.sendMessage(TalkWithGod.PREFIX + "God could not answer this question.");
                return false;
            }

            // god has spoken here, listen:
            commandSender.sendMessage(TalkWithGod.PREFIX + "God has spoken! Please listen!");
            commandSender.sendMessage(TalkWithGod.PREFIX + "\"" + talkWithGod.getKjv().getWord(ss) + "\".");
        }

        return false;
    }
}
