package bigb.game.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ShopItem {
    @Getter
    private final String id;
    private final String name;
    private final int cost;
}
