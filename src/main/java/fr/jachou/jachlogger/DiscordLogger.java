package fr.jachou.jachlogger;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class DiscordLogger {

    private JDA jda;
    private String ID;

    public DiscordLogger(String token, String channelID) {
        jda = JDABuilder.createDefault(token).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).build();
        ID = channelID;
    }

    public void sendError(String error, Exception e) {
        TextChannel channel = jda.getTextChannelById(ID);
        if (channel != null) {
            channel.sendMessage(error + " " + e);
        }
    }

    public void sendError(String error, Exception e, int channelID) {
        TextChannel channel = jda.getTextChannelById(channelID);
        if (channel != null) {
            channel.sendMessage(error + " " + e).queue();
        }
    }

    public void sendInfo(String info) {
        PrivateChannel channel = jda.getPrivateChannelById(ID);
        if (channel != null) {
            channel.sendMessage(info).queue();
        }
    }

    public void sendInfo(String info, String channelID) {
        TextChannel channel = jda.getTextChannelById(channelID);
        if (channel != null) {
            channel.sendMessage(info).queue();
        }
    }
}
