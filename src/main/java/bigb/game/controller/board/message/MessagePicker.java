package bigb.game.controller.board.message;

import bigb.game.client.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MessagePicker {
    Optional<Message> getMessage(List<Message> messages);
}
