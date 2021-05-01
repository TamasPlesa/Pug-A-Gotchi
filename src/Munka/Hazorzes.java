package Munka;

import java.util.Random;

public class Hazorzes extends Munka {

    public Hazorzes() {
        super(new Random().nextInt(200-30) + 30, new Random().nextInt(30-8) + 8, new Random().nextInt(20-10) + 10);
    }
}
