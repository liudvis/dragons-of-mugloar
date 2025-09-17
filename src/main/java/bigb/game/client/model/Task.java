package bigb.game.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Task {
    private final boolean success;
    @Getter
    private final int lives;
    @Getter
    private final int gold;
    private final int score;
    private final int highScore;
    private final int turn;
    private final String message;
}
