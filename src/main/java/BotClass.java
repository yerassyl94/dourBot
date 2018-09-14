import com.google.common.collect.ImmutableMap;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

public class BotClass extends TelegramLongPollingBot {
    private static final long fromChatId =  220189129;
    private static final String botName =  "dour_bot";
    private static final String botReferenceName =  "@" + botName;
    private static final String botToken = "645401417:AAFSUHCjs8JLeKcHd57Jh97DPNJALD43-OM";

    private static final Map<String, Integer> commands = ImmutableMap.<String, Integer>builder()
            .put("chika", 52)
            .put("dour", 74)
            .put("yera", 80)
            .put("dula", 82)
            .build();

    private static Integer getMessageId(String command) {
        if (command == null) {
            return null;
        }

        int start = 1, end = command.length();
        if (command.endsWith(botReferenceName)) {
            end -= botReferenceName.length();
        }
        return commands.get(command.substring(start, end));
    }

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        Integer messageId = getMessageId(command);

        if(command == null || chatId == null || messageId == null) {
            return;
        }

        ForwardMessage forwardMessage = new ForwardMessage();
        forwardMessage.setFromChatId(fromChatId);
        forwardMessage.setChatId(chatId);
        forwardMessage.setMessageId(messageId);

        try {
            this.execute(forwardMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return botName;
    }

    public String getBotToken() {
        return botToken;
    }
}