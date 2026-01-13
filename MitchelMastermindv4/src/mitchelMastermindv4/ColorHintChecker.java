package mitchelMastermindv4;

public class ColorHintChecker {
    public String[] checkGuess(String[] guess, String[] secret) {
        String[] result = new String[4];

        for (int i = 0; i < 4; i++) {
            if (guess[i].equalsIgnoreCase(secret[i])) {
                result[i] = "Zwart";
            } else if (containsColor(secret, guess[i])) {
                result[i] = "Wit";
            } else {
                result[i] = "Null";
            }
        }
        return result;
    }

    public boolean isCorrect(String[] guess, String[] secret) {
        for (int i = 0; i < 4; i++) {
            if (!guess[i].equalsIgnoreCase(secret[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean containsColor(String[] secret, String color) {
        for (String s : secret) {
            if (s.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }
}
