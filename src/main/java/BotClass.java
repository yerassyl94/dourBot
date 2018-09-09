import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotClass extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        int messageFromChatId =  220189129;

        if(command == null){
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText(update.getMessage().getMessageId().toString());

            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        } else {
            ForwardMessage forwardMessage = new ForwardMessage();

            if(command.equals("/chika@dour_bot") || command.equals("/chika")){
                forwardMessage.setFromChatId(new Long(messageFromChatId));
                forwardMessage.setChatId(chatId);
                forwardMessage.setMessageId(52);
            }

            if(command.equals("/dour@dour_bot") || command.equals("/dour")){
                forwardMessage.setFromChatId(new Long(messageFromChatId));
                forwardMessage.setChatId(chatId);
                forwardMessage.setMessageId(74);
            }

            if(command.equals("/yera@dour_bot") || command.equals("/yera")){
                forwardMessage.setFromChatId(new Long(messageFromChatId));
                forwardMessage.setChatId(chatId);
                forwardMessage.setMessageId(80);
            }

            if(command.equals("/dula@dour_bot") || command.equals("/dula")){
                forwardMessage.setFromChatId(new Long(messageFromChatId));
                forwardMessage.setChatId(chatId);
                forwardMessage.setMessageId(82);
            }

            try{
                execute(forwardMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "dour_bot";
    }

    public String getBotToken() {
        return "645401417:AAFSUHCjs8JLeKcHd57Jh97DPNJALD43-OM";
    }
}
