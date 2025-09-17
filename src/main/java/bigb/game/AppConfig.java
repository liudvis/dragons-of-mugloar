package bigb.game;

import bigb.game.client.model.Game;
import bigb.game.client.service.NewGame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${dragons.of.mugloar.base.url}")
    private String BASE_URI;

    @Bean
    public Game startNewGame() {
        return new NewGame().start(BASE_URI);
    }
}
