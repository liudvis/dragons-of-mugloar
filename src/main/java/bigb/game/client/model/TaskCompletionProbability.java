package bigb.game.client.model;

import bigb.game.decryption.StringDecrypter;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Optional;

public enum TaskCompletionProbability {
    PIECE_OF_CAKE("Piece of cake", 4),
    SURE_THING("Sure thing", 4),
    WALK_IN_THE_PARK("Walk in the park", 4),
    QUITE_LIKELY("Quite likely", 4),
    HMM("Hmmm....", 3),
    RATHER_DETRIMENTAL("Rather detrimental", 3),
    RISKY("Risky", 3),
    GAMBLE("Gamble", 2),
    PLAYING_WITH_FIRE("Playing with fire", 2),
    SUICIDE_MISSION("Suicide mission", 2),
    IMPOSSIBLE("Impossible", 1),
    UNKNOWN("Unknown", 0);

    public final String probability;
    public final int value;

    TaskCompletionProbability(String probability, int value) {
        this.probability = probability;
        this.value = value;
    }

    @JsonCreator
    public static TaskCompletionProbability safeValueOf(String string) {
        Optional<TaskCompletionProbability> probability = mapValues(string);
        if (probability.isPresent()) {
            return TaskCompletionProbability.valueOf(probability.get().toString());
        } else {
            String decryptedString = StringDecrypter.decryptString(string);
            Optional<TaskCompletionProbability> probabilityDecrypted = mapValues(decryptedString);
            if (probabilityDecrypted.isPresent()) {
                return TaskCompletionProbability.valueOf(probabilityDecrypted.get().toString());
            }
            return UNKNOWN;
        }
    }

    private static Optional<TaskCompletionProbability> mapValues(String string) {
        return Arrays.stream(values())
                .filter(bl -> bl.probability.equalsIgnoreCase(string))
                .findFirst();
    }
}
