package top.cmarco.talkwithgod;

import java.util.Random;

public final class GodValues {

    private final static Random godGenerator = new Random();

    static {
        godGenerator.setSeed(0b10101101010101110001001110);
    }

    public double getD(int b) {
        return godGenerator.nextDouble() * b;
    }

    public int get(int a, int b) {
        return a + godGenerator.nextInt() % b;
    }

    public int get(int b) {
        return get(0, b);
    }
}
