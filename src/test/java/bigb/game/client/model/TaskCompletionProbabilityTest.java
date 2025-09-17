package bigb.game.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskCompletionProbabilityTest {

    @Test
    void safeValueOf() {
        TaskCompletionProbability probability = TaskCompletionProbability.safeValueOf("Walk in the park");

        assertEquals(TaskCompletionProbability.WALK_IN_THE_PARK, probability);
    }

    @Test
    void safeValueOf_encrypted() {
        TaskCompletionProbability probability = TaskCompletionProbability.safeValueOf("U3VpY2lkZSBtaXNzaW9u");

        assertEquals(TaskCompletionProbability.SUICIDE_MISSION, probability);
    }
}