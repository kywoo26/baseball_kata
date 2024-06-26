public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        checkGuessNumberIsValid(guessNumber);

        if (isSolved(guessNumber)) {
            return getSolvedResult();
        } else {
            return getUnsolvedResult(guessNumber);
        }
    }

    private boolean isSolved(String guessNumber) {
        return guessNumber.equals(question);
    }

    private GuessResult getSolvedResult() {
        return new GuessResult(true, 3, 0);
    }

    private GuessResult getUnsolvedResult(String guessNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < guessNumber.length(); i++) {
            if (question.indexOf(guessNumber.charAt(i)) == i) {
                strikes++;
            } else if (question.indexOf(guessNumber.charAt(i)) > -1) {
                balls++;
            }
        }

        return new GuessResult(false, strikes, balls);
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
