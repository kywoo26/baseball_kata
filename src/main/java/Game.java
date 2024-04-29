public class Game {
    public void guess(String guessNumber) {
        checkGuessNumberIsValid(guessNumber);
    }

    private void checkGuessNumberIsValid(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        char num0 = guessNumber.charAt(0);
        char num1 = guessNumber.charAt(1);
        char num2 = guessNumber.charAt(2);

        return num0 == num1 || num1 == num2 || num2 == num0;
    }
}
