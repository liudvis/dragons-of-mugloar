package bigb.game.controller.board.message;

import bigb.game.client.model.Message;
import bigb.game.client.model.TaskCompletionProbability;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static bigb.game.client.model.TaskCompletionProbability.*;
import static org.junit.jupiter.api.Assertions.*;

class MessageReputableSafestTest {
    private MessageReputableSafest messageReputableSafest;

    @BeforeEach
    public void setup() throws Exception {
        this.messageReputableSafest = new MessageReputableSafest();
    }

    @Test
    void getHighestProbabilityOfMessageBoard() {
        int probability = messageReputableSafest.getHighestProbabilityOfMessageBoard(messages());
        assertEquals(4, probability);
    }

    @Test
    void getHighestProbabilityOfMessageBoard_messagesThirdList() {
        int probability = messageReputableSafest.getHighestProbabilityOfMessageBoard(messages3());
        assertEquals(4, probability);
    }

    @Test
    void getSafestMessage() {
        List<Message> messages = messages();
        Optional<Message> safeMessage = messageReputableSafest.getMessage(messages);

        assertEquals(messages.get(1), safeMessage.get());
    }

    @Test
    void getHighestProbabilityOfMessageBoard2() {
        int probability = messageReputableSafest.getHighestProbabilityOfMessageBoard(messages2());
        assertEquals(3, probability);
    }

    @Test
    void getSafestMessage_anotherList() {
        List<Message> messages = messages2();
        int probability = messageReputableSafest.getHighestProbabilityOfMessageBoard(messages);
        assertEquals(3, probability);
        Optional<Message> safeMessage = messageReputableSafest.getMessage(messages);

        assertEquals(messages.get(3), safeMessage.get());
    }


    static List<Message> messages() {
        return List.of(new Message("qOBR06n9", "Help Thera Hulduson to clean their chicken", "1", 6, false, SURE_THING),
                new Message("rfsXRB2q", "Create an advertisement campaign for Kweku Erickson to promote their clothes based business", "31", 6, false, TaskCompletionProbability.PIECE_OF_CAKE),
                new Message("wXAeUlEH", "Help Dara Preston to transport a magic wagon to field in Burnsfair", "31", 6, false, TaskCompletionProbability.HMM),
                new Message("hA5V1GL5", "Escort Ettie Dickenson to meadow in Loweheart where they can meet with their long lost house", "62", 6, false, TaskCompletionProbability.HMM),
                new Message("VtSJYtzp", "Help Maqsood Treloar to transport a magic house to grassland in Blackspring", "24", 6, false, TaskCompletionProbability.WALK_IN_THE_PARK),
                new Message("GpXlFDgt", "Help Suriya Southers to write their biographical novel about their difficulties with a deranged turnips", "28", 6, false, TaskCompletionProbability.WALK_IN_THE_PARK),
                new Message("PLWUzjGL", "Help Matic Delaney to reach an agreement with Lacy Underhill on the matters of disputed squirrel", "7", 6, false, TaskCompletionProbability.WALK_IN_THE_PARK),
                new Message("cxf7ekAh", "Steal weed delivery to Judi Wembley and share some of the profits with the people.", "46", 6, false, TaskCompletionProbability.PIECE_OF_CAKE),
                new Message("2LriVP7H", "Help Blaise Proudfoot to clean their pan", "4", 6, false, TaskCompletionProbability.PIECE_OF_CAKE),
                new Message("zKyTReoT", "Help Eugênia Hardwick to clean their horse", "6", 6, false, TaskCompletionProbability.PIECE_OF_CAKE));
    }

    static List<Message> messages2() {
        return List.of(new Message("GOqpRNv6", "Steal turnips delivery to Earle Rowland and share some of the profits with the people.", "65", 7, false, SURE_THING),
                new Message("cymdF2nm", "Steal water delivery to Kalisha Spurling and share some of the profits with the people.", "61", 7, false, TaskCompletionProbability.PIECE_OF_CAKE),
                new Message("Yw3dww4I", "Create an advertisement campaign for Eógan Bloxham to promote their squirrel based business", "21", 7, false, TaskCompletionProbability.HMM),
                new Message("RtUfqBWH", "Create an advertisement campaign for Miško Waterman to promote their chicken based business", "32", 7, false, TaskCompletionProbability.HMM),
                new Message("IRQweaT7", "Create an advertisement campaign for Agata Appleton to promote their weed based business", "24", 7, false, TaskCompletionProbability.HMM));
    }

    static List<Message> messages3() {
        return List.of(
                new Message("h8vXXb61", "Rescue Roshanak Hadaway from meadow in Southfirth where they are attacked by angry cat", "31", 1, false, TaskCompletionProbability.WALK_IN_THE_PARK),
                new Message("uSdrF6d9", "Rescue Orsino Hlöðversdóttir from grassland in Razorburg where they are attacked by angry squirrel", "29", 3, false, SURE_THING),
                new Message("8FOx9A0H", "Rescue Keahi Attwood from plains in Penheart where they are attacked by angry weed", "28", 5, false, WALK_IN_THE_PARK),
                new Message("tDBhyKqY", "Rescue Stacy Beverly from savannah in Redpine where they are attacked by angry pot", "47", 6, false, WALK_IN_THE_PARK),
                new Message("rrjwL3lX", "Rescue Ranulf Washington from savannah in Everport where they are attacked by angry chariot", "37", 6, false, WALK_IN_THE_PARK),
                new Message("�'�", "^��2�Z�X�����'jv��|kI�����l���;��Ǜ�6�j\t�i����i�gʸ�|k����|�", "131", 1, false, UNKNOWN),
                new Message("Tl2yhidB", "Infiltrate The Ruby Thorns and recover their secrets.", "180", 1, false, RATHER_DETRIMENTAL),
                new Message("HMKb4dFO", "Infiltrate The Grizzly Boar Brotherhood and recover their secrets.", "167", 1, false, QUITE_LIKELY),
                new Message("Djh5aE8S", "Investigate Zi̇yaeddi̇n Radclyffe and find out their relation to the magic pot.", "142", 2, false, PLAYING_WITH_FIRE),
                new Message("qLLp5HVJ", "Infiltrate The Royal Sharkteeth and recover their secrets", "173", 2, false, TaskCompletionProbability.RISKY));
    }


}