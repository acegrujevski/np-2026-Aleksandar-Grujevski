package kol1.zad19;

import java.util.Random;

public class LoadedCoin extends Coin {

    private int probability;

    public LoadedCoin(int probability) {
        super();
        this.probability = probability;
    }

    @Override
    public SIDE flip() {
        Random random = new Random();
        int num = random.nextInt(100);
        if (probability>=num)
            return SIDE.HEAD;
        return SIDE.TAIL;
    }
}
