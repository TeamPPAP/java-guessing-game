package guessing.computer;

public class NumberGenerator {

    public int generate(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
