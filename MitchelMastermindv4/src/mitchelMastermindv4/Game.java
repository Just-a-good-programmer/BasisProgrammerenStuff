package mitchelMastermindv4;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private CodeGenerator codeGenerator;
    private InputHandler inputhandler;
    private ColorHintChecker colorHintChecker;

    private String[] secretCode;
    private int currentTurn;

    public void start() {
        printWelcome();

        boolean gameDone = false;

        while (!gameDone) {
            resetGame();

            while (currentTurn < 10) {
                try {
                    String[] guess = inputhandler.getGuess(scanner);
                    String[] results = colorHintChecker.checkGuess(guess, secretCode);

                    if (colorHintChecker.isCorrect(guess, secretCode)) {
                        System.out.println("Gefeliciteerd! Je hebt de code geraden!");
                        gameDone = !playAgain();
                        break;
                    } else if (currentTurn == 9) {
                        System.out.println("Sorry, je hebt het niet binnen 10 rondes geraden.");
                        System.out.println("De correcte code was: " + String.join(" ", secretCode));
                        gameDone = !playAgain();
                        break;
                    } else {
                        System.out.println("Dat is incorrect. Hier zijn je hints: "
                                + String.join(" ", results));
                    }

                    currentTurn++;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    currentTurn++;
                }
            }
        }
        scanner.close();
    }

    private void resetGame() {
        codeGenerator = new CodeGenerator();
        inputhandler = new InputHandler();
        colorHintChecker = new ColorHintChecker();

        secretCode = codeGenerator.generateSecretCode();
        currentTurn = 0;
    }

    private boolean playAgain() {
        System.out.println("Wil je opnieuw spelen? Typ 'ja' of 'nee'.");
        return scanner.nextLine().equalsIgnoreCase("ja");
    }

    private void printWelcome() {
        System.out.println("Welkom bij MasterMind!");
        System.out.println("Kleuren: rood, blauw, geel, groen, paars, oranje, leeg");
        System.out.println("Voer 4 VERSCHILLENDE kleuren in, gescheiden door spaties.");
        System.out.println("'Zwart' = juiste kleur + plaats");
        System.out.println("'Wit' = juiste kleur, verkeerde plaats");
        System.out.println("'Null' = kleur komt niet voor");
        System.out.println("Veel plezier!\n");
    }
}