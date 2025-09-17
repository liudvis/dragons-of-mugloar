package bigb.game.controller.shop;

import bigb.game.client.model.ShopItem;
import bigb.game.client.service.GameService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shop {
    private final GameService gameService;
    @Getter
    private final List<ShopItem> shopItems;
    private final ShopHelper shopHelper;

    public Shop(GameService gameService, ShopHelper shopHelper) {
        this.gameService = gameService;
        this.shopItems = gameService.getShopItems();
        this.shopHelper = shopHelper;
    }

    public void buy(int availableGold, int lives) {
        int index = shopHelper.determineWhatToBuy(availableGold, lives);
        if (index != -1) {
            gameService.purchaseItem(shopItems.get(index));
        }
    }
}
