package uz.pdp.SpringDataJpaTest.appender;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.message.Message;

import java.io.Serializable;

@Plugin(name = "CustomAppender", category = Node.CATEGORY,elementType = "appender",printObject = true)
public class CustomAppender extends AbstractAppender {

    private TelegramBot bot ;

    protected CustomAppender(String name,
                             Filter filter,
                             Layout<? extends Serializable> layout,
                             boolean ignoreExceptions,
                             Property[] properties, String botToken) {
        super(name, filter, layout, ignoreExceptions, properties);
        bot = new TelegramBot(botToken);
    }

    @Override
    public void append(LogEvent event) {
        byte[] byteArray = getLayout().toByteArray(event);
        String message = new String(byteArray);
        SendMessage sendMessage = new SendMessage(618817727,"Message :"+message);
        bot.execute(sendMessage);
    }

    @PluginFactory
    public static CustomAppender createCustomAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter")  Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginAttribute("ignoreExceptions")  boolean ignoreExceptions,
            @PluginAttribute("botToken")  String  botToken
    ){
        return new CustomAppender(name,filter,layout,ignoreExceptions,new Property[]{},botToken);
    }
}
