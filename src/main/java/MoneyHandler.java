import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.HashMap;

public class MoneyHandler extends TelegramLongPollingBot {

    HashMap<Long, ArrayList<ChillSession>> useridToChillSessions = new HashMap<>();

    public void addUser(Long id) {
        ArrayList<ChillSession> chillSessions = new ArrayList<>();
        useridToChillSessions.put(id, chillSessions);
    }

    public void addChillSession(Long id, String name) {
        useridToChillSessions.get(id).add(new ChillSession(name));
    }

    public boolean chillSessionExists(Long id, String name) {
        for (ChillSession c : useridToChillSessions.get(id)) {
            if (c.getNameOfSession().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public int chillSessionIndex(Long id, String name) {
        for (int i = 0; i < this.useridToChillSessions.get(id).size(); i++) {
            if (this.useridToChillSessions.get(id).get(i).getNameOfSession().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void deleteChillSession(Long id, String name) {
        if (this.chillSessionExists(id, name)) {
            this.useridToChillSessions.get(id).remove(this.chillSessionIndex(id, name));
        }
    }

    @Override
    public String getBotUsername() {
        return "JointChillBot";
    }

    @Override
    public String getBotToken() {
        return "1931778515:AAEDB-WOSq0oV2WCFzZ0NYV2CmXQGRSp8aQ";
    }

    public void sendMessage(String chatID, String text) throws TelegramApiException {
        SendMessage outMessage = new SendMessage();

        outMessage.setChatId(chatID);
        outMessage.setText(text);
        execute(outMessage);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
//                String chatID = String.valueOf(inMessage.getChatId());
//                Long userID = inMessage.getForwardFrom().getId();
//
//                String command = inMessage.getText();
//                String respond;
//
//                if (command.equals("help")) {
//                    respond = "new session,\nmy sessions\n";
//
//                    SendMessage outMessage = new SendMessage();
//                    outMessage.setChatId(chatID);
//                    outMessage.setText(respond);
//                    execute(outMessage);
//
//                    sendMessage(chatID, respond);
//                } else if (command.equals("new session")) {
//                    sendMessage(chatID, "name of session:");
//
//                    inMessage = update.getMessage();
//                    command = inMessage.getText();
//                    addChillSession(userID, command);
//
//                    sendMessage(chatID, "thanks");
//                } else if (command.equals("my sessions")) {
//                    StringBuilder sessions = new StringBuilder();
//                    sessions.append(" | ");
//
//                    for (ChillSession c : useridToChillSessions.get(userID)) {
//                        sessions.append(c.getNameOfSession());
//                        sessions.append(" | ");
//                    }
//
//                    sendMessage(chatID, sessions.toString());
//                }

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
