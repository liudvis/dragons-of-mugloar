package bigb.game.client.service;

import bigb.game.client.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
public class GameService {
    private final String BASE_URI;
    public static final String INVESTIGATE_REPUTATION = "%s/investigate/reputation";
    public static final String MESSAGES = "%s/messages";
    public static final String SOLVE = "%s/solve/%s";
    public static final String SHOP = "%s/shop";
    public static final String SHOP_BUY = "%s/shop/buy/%s";
    private final static RestClient restClient = RestClient.create();
    private final Game game;

    public GameService(@Value("${dragons.of.mugloar.base.url}") String baseUri, Game game) {
        this.BASE_URI = baseUri;
        this.game = game;
    }

    public Reputation investigateReputation() {
        return restClient.post()
                .uri(BASE_URI + INVESTIGATE_REPUTATION.formatted(game.getGameId()))
                .retrieve()
                .body(Reputation.class);
    }

    public List<Message> fetchMessages() throws RestClientException {
        return restClient.get()
                .uri(BASE_URI + MESSAGES.formatted(game.getGameId()))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Task solveTask(Message message) {
        return restClient.post()
                .uri(BASE_URI + SOLVE.formatted(game.getGameId(), message.getAdId()))
                .retrieve()
                .body(Task.class);
    }

    public List<ShopItem> getShopItems() {
        return restClient.get()
                .uri(BASE_URI + SHOP.formatted(game.getGameId()))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public void purchaseItem(ShopItem shopItem) {
        restClient.post()
                .uri(BASE_URI + SHOP_BUY.formatted(game.getGameId(), shopItem.getId()))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
