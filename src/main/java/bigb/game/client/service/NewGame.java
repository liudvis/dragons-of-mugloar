package bigb.game.client.service;

import bigb.game.client.model.Game;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NewGame {
    public static final String GAME_START = "game/start";
    private final static RestClient restClient = RestClient.create();

    public Game start(String baseUri) {
        return restClient.post()
                .uri(baseUri + GAME_START)
                .retrieve()
                .body(Game.class);
    }
}
