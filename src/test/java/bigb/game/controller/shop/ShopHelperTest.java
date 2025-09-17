package bigb.game.controller.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopHelperTest {
    private ShopHelper shopHelper;

    @BeforeEach
    public void setup() {
        this.shopHelper = new ShopHelper();
    }

    @Test
    void determineWhatToBuy_0() {
        int itemIndex = shopHelper.determineWhatToBuy(50, 3);
        assertEquals(0, itemIndex);
    }

    @Test
    void determineWhatToBuy_60gold_4lives() {
        int itemIndex = shopHelper.determineWhatToBuy(60, 4);
        assertEquals(0, itemIndex);
    }

    @Test
    void determineWhatToBuy_random() {
        int itemIndex = shopHelper.determineWhatToBuy(150, 6);
        assert(itemIndex>0 && itemIndex<5);
    }

    @Test
    void determineWhatToBuy_random2() {
        int itemIndex = shopHelper.determineWhatToBuy(400, 6);
        assert(itemIndex>5);
    }

    @Test
    void getRandomNumber(){
        int randomNumber = ShopHelper.getRandomNumber(1, 5);
        assert (randomNumber>=1 && randomNumber<=5);
    }
}