package bigb.game.controller.board.message;

import bigb.game.client.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MessageNotoriousRisky implements MessagePicker {
    @Override
    public Optional<Message> getMessage(List<Message> messages) {
        return Optional.empty(); //Could be choosing to solve risky messages or non-reputable
    }
}
