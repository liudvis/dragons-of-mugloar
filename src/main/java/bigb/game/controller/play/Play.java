package bigb.game.controller.play;

import bigb.game.controller.board.MessageBoard;
import bigb.game.client.model.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class Play {
    private final Player player;
    private final MessageBoard messageBoard;

    public Play(Player player, MessageBoard messageBoard) {
        this.player = player;
        this.messageBoard = messageBoard;
    }

    public void start() {
        Task task = null;
        List<Message> messages;
        do {
            messages = messageBoard.getMessages();
            Optional<Message> message = player.chooseMessageToSolve(messages);
            if (message.isPresent()) {
                task = player.solveTask(message.get());
                player.buyItem(task.getGold(), task.getLives());
                System.out.println(task);
            }
        } while (task != null && task.getLives() != 0);
        System.out.printf("\n\n%s\n%n", task);
        System.exit(0);
    }
}
