package Project10;

import java.util.Random;

public class Utility {
    public static String generateCarID() {
        Random rand = new Random();
        int num = 100 + rand.nextInt(900);
        return "C" + num;
    }
}
