package bigb.game.controller.board.message.decryption;

import bigb.game.client.model.Message;
import bigb.game.decryption.StringDecrypter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MessageDecrypter {

    public List<Message> decryptMessagesIfAny(List<Message> messages) {
        List<Message> encryptedMessages = checkForEncryptedMessages(messages);
        if (!encryptedMessages.isEmpty()) {
            List<Message> decryptedMessages = encryptedMessages.stream()
                    .map(this::decryptMessage)
                    .toList();
            return Stream.concat(messages.stream(), decryptedMessages.stream())
                    .filter(Predicate.not(Message::isEncrypted))
                    .collect(Collectors.toList());
        }
        return messages;
    }

    private List<Message> checkForEncryptedMessages(List<Message> messages) {
        return messages.stream()
                .filter(Message::isEncrypted)
                .toList();
    }

    private Message decryptMessage(Message message) {
        return new Message(
                StringDecrypter.decryptString(message.getAdId()),
                StringDecrypter.decryptString(message.getMessage()),
                message.getReward(),
                message.getExpiresIn(),
                false,
                message.getProbability());
    }
}
