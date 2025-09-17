package bigb.game.controller.board.message;

import bigb.game.client.model.Message;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Primary
@Component
public class MessageReputableSafest implements MessagePicker {

    @Override
    public Optional<Message> getMessage(List<Message> messages) {
        int probability = getHighestProbabilityOfMessageBoard(messages);
        return messages.stream()
                .filter(MessageEvaluator::isReputable)
                .filter(Predicate.not(Message::isEncrypted))
                .filter(message -> message.getProbability().value == probability)
                .max((a, b) -> Integer.parseInt(a.getReward()) > Integer.parseInt(b.getReward()) ? 1 : -1);
    }

    protected int getHighestProbabilityOfMessageBoard(List<Message> messages) {
        Optional<Message> max = messages.stream()
                .filter(MessageReputableSafest.MessageEvaluator::isReputable)
                .max(Comparator.comparingInt(a -> a.getProbability().value));
        return max.map(message -> message.getProbability().value).orElse(0);
    }

    private static class MessageEvaluator {
        private static boolean isReputable(Message task) {
            return !task.getMessage().contains("Steal");
        }
    }
}
