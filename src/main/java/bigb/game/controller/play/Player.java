package bigb.game.controller.play;

import bigb.game.controller.board.message.MessagePicker;
import bigb.game.client.model.Message;
import bigb.game.client.model.Task;
import bigb.game.client.service.GameService;
import bigb.game.controller.shop.Shop;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Player {
    private final GameService gameService;
    private final Shop shop;
    private final MessagePicker messagePicker;

    public Player(GameService gameService, Shop shop, MessagePicker messagePicker) {
        this.gameService = gameService;
        this.shop = shop;
        this.messagePicker = messagePicker;
    }

    public Task solveTask(Message message) {
        return gameService.solveTask(message);
    }

    public void buyItem(int availableGold, int lives) {
        shop.buy(availableGold, lives);
    }

    public Optional<Message> chooseMessageToSolve(List<Message> messages) {
        return messagePicker.getMessage(messages);
    }
}
