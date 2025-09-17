package bigb.game.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Game {
    @Getter
    private final String gameId;
    private final int lives;
    private final int gold;
    private final int level;
    private final int score;
    private final int highScore;
    private final int turn;
}
