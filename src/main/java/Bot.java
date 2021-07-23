import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "JointChillBot";
    }

    @Override
    public String getBotToken() {
        return "1931778515:AAEDB-WOSq0oV2WCFzZ0NYV2CmXQGRSp8aQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();

                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(String.valueOf(inMessage.getChatId()));
                outMessage.setText(inMessage.getText());
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
