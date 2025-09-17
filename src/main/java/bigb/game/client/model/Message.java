package bigb.game.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Comparator {
    private final String adId;
    private final String message;
    private final String reward;
    private final int expiresIn;
    private final boolean encrypted;
    private final TaskCompletionProbability probability;

    public Message(String adId, String message, String reward, int expiresIn, boolean encrypted, TaskCompletionProbability probability) {
        this.adId = adId;
        this.message = message;
        this.reward = reward;
        this.expiresIn = expiresIn;
        this.encrypted = encrypted;
        this.probability = probability;
    }

    @JsonValue
    public TaskCompletionProbability getProbability() {
        return probability;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Integer o1reward = Integer.valueOf(((Message) o1).getReward());
        Integer o2reward = Integer.valueOf(((Message) o2).getReward());
        if(o1reward>o2reward){
            return 1;
        } else if (o1reward<o2reward){
            return -1;
        }
        return 0;
    }
}
