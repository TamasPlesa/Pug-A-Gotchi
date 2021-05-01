package Jatek;

import java.util.Random;

public class LabdasJatek extends Jatek {

    public LabdasJatek() {
        super(0, 18, new Random().nextInt(9-0) + 0, 5);
    }
}
