public class Game {
    public void guess(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
