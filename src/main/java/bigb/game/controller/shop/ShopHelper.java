package bigb.game.controller.shop;

import org.springframework.stereotype.Component;

@Component
public class ShopHelper {
    private static final int LOW_LIFE_THRESHOLD = 5;
    private static final int LOW_TIER_GOLD = 50;
    private static final int MIN_MID_TIER_GOLD = 150;
    private static final int MAX_MID_TIER_GOLD = 250;

    int determineWhatToBuy(int availableGold, int lives) {
        if (availableGold >= LOW_TIER_GOLD && lives < LOW_LIFE_THRESHOLD) {
            return 0;
        } else if (availableGold >= MIN_MID_TIER_GOLD && availableGold <= MAX_MID_TIER_GOLD) {
            return ShopHelper.getRandomNumber(1, 5);
        } else if (availableGold >= MAX_MID_TIER_GOLD) {
            return ShopHelper.getRandomNumber(6, 10);
        }
        return -1;
    }

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
