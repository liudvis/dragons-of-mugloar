package bigb.game.controller.board;

import bigb.game.client.model.Message;
import bigb.game.client.service.GameService;
import bigb.game.controller.board.message.decryption.MessageDecrypter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
public class MessageBoard {
    private final GameService gameService;
    private final MessageDecrypter messageDecrypter;

    public MessageBoard(GameService gameService, MessageDecrypter messageDecrypter) {
        this.gameService = gameService;
        this.messageDecrypter = messageDecrypter;
    }

    public List<Message> getMessages() throws RestClientException {
        List<Message> messages = gameService.fetchMessages();
        return messageDecrypter.decryptMessagesIfAny(messages);
    }
}
