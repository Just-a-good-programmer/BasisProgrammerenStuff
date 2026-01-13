package mitchelMastermindv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MitchelMastermindv3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String colorChoices[] = {"rood", "blauw", "geel", "groen", "paars", "oranje", "leeg"};
        String secretCode[] = new String[4];
        int currentTurn = 0;
        boolean gameDone = false;

        List<String> availableColors = new ArrayList<>(Arrays.asList(colorChoices));
        // Create a secret code of four random colors from the available colors.
        for (int i = 0; i < 4; i++) {
            int randomNumber = (int) (Math.random() * availableColors.size());
            secretCode[i] = availableColors.get(randomNumber);
            availableColors.remove(randomNumber);
        }

        // This is where the game starts
        while (!gameDone) {

            if (currentTurn == 0) {
                System.out.println("Welkom bij MasterMind! Raad de geheime code! "
                        + "De kleuren waar je uit kan kiezen zijn: Rood, Blauw, Geel, Groen, Paars, Oranje en Leeg. ");
                System.out.println("Maak een rij van 4 VERSCHILLENDE kleuren, "
                        + "gescheiden door middel van een spatie, om een code te raden. "
                        + "Elke juiste kleur komt maar één keer voor in de code. ");
                System.out.println("Als je een vakje leeg wil laten, gebruik dan de kleur ‘Leeg’. ");
                System.out.println("'Wit' betekent dat je een kleur goed hebt maar niet op de juiste plaats, "
                        + "'Zwart' betekent dat de kleur op de juiste plaats staat en "
                        + "'Null' betekent dat de kleur niet voorkomt. ");
                System.out.println("Veel plezier en succes!");
            }
            if (currentTurn < 10) {
                try {
                    System.out.println("Voer 4 VERSCHILLENDE kleuren in:");
                    String userInput = scanner.nextLine().toLowerCase();
                    String[] guessedColors = userInput.split(" ");
                    String[] results = new String[4];
                    if (guessedColors.length != 4) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    // Validate input colors are from the allowed choices (is case-sensitive at the moment)
                    if (!Arrays.asList(colorChoices).contains(guessedColors[0])
                            || !Arrays.asList(colorChoices).contains(guessedColors[1])
                            || !Arrays.asList(colorChoices).contains(guessedColors[2])
                            || !Arrays.asList(colorChoices).contains(guessedColors[3])) {
                        throw new InputMismatchException();
                    }

                    // Check per index whether it matches with the guessed index or other indexes in the code.
                    if (guessedColors[0].equalsIgnoreCase(secretCode[0])) {
                        results[0] = "Zwart";
                    } else if (guessedColors[0].equalsIgnoreCase(secretCode[1]) || guessedColors[0].equalsIgnoreCase(secretCode[2]) || guessedColors[0].equalsIgnoreCase(secretCode[3])) {
                        results[0] = "Wit";
                    } else {
                        results[0] = "Null";
                    }
                    // Check for the second guessed index
                    if (guessedColors[1].equalsIgnoreCase(secretCode[1])) {
                        results[1] = "Zwart";
                    } else if (guessedColors[1].equalsIgnoreCase(secretCode[0]) || guessedColors[1].equalsIgnoreCase(secretCode[2]) || guessedColors[1].equalsIgnoreCase(secretCode[3])) {
                        results[1] = "Wit";
                    } else {
                        results[1] = "Null";
                    }
                    // Check for the third guessed index
                    if (guessedColors[2].equalsIgnoreCase(secretCode[2])) {
                        results[2] = "Zwart";
                    } else if (guessedColors[2].equalsIgnoreCase(secretCode[0])
                            || guessedColors[2].equalsIgnoreCase(secretCode[1])
                            || guessedColors[2].equalsIgnoreCase(secretCode[3])) {
                        results[2] = "Wit";
                    } else {
                        results[2] = "Null";
                    }
                    // Check for the fourth guessed index
                    if (guessedColors[3].equalsIgnoreCase(secretCode[3])) {
                        results[3] = "Zwart";
                    } else if (guessedColors[3].equalsIgnoreCase(secretCode[0])
                            || guessedColors[3].equalsIgnoreCase(secretCode[1])
                            || guessedColors[3].equalsIgnoreCase(secretCode[2])) {
                        results[3] = "Wit";
                    } else {
                        results[3] = "Null";
                    }
                    // Check if all the indexes of guessed array match the indexes of secret code array
                    if (secretCode[0].equalsIgnoreCase(guessedColors[0])
                            && secretCode[1].equalsIgnoreCase(guessedColors[1])
                            && secretCode[2].equalsIgnoreCase(guessedColors[2])
                            && secretCode[3].equalsIgnoreCase(guessedColors[3])) {
                        System.out.println("Gefeliciteerd! Je hebt de code geraden!");
                        System.out.println("Wil je opnieuw spelen? Typ 'ja' om opnieuw te spelen of 'nee' om te stoppen.");
                        String userInputPlayAgain = scanner.nextLine();
                        if (userInputPlayAgain.equalsIgnoreCase("ja")) {
                            // Reset the game state
                            currentTurn = 0;
                            gameDone = false;
                            availableColors = new ArrayList<>(Arrays.asList(colorChoices));
                            // Generate a new secret code
                            for (int i = 0; i < 4; i++) {
                                int randomNumber = (int) (Math.random() * availableColors.size());
                                secretCode[i] = availableColors.get(randomNumber);
                                availableColors.remove(randomNumber);
                            }
                        } else {
                            gameDone = true;
                        }
                    } else if (currentTurn == 9) {
                        System.out.println("Sorry, je hebt het niet binnen 10 rondes geraden. De correcte code was: "
                                + secretCode[0] + " " + secretCode[1] + " " + secretCode[2] + " " + secretCode[3]);

                        System.out.println("Wil je opnieuw spelen? Typ 'ja' om opnieuw te spelen of 'nee' om te stoppen.");
                        String userInputPlayAgain = scanner.nextLine();
                        if (userInputPlayAgain.equalsIgnoreCase("ja")) {
                            // Reset the game state
                            currentTurn = 0;
                            gameDone = false;
                            availableColors = new ArrayList<>(Arrays.asList(colorChoices));
                            // Generate a new secret code
                            for (int i = 0; i < 4; i++) {
                                int randomNumber = (int) (Math.random() * availableColors.size());
                                secretCode[i] = availableColors.get(randomNumber);
                                availableColors.remove(randomNumber);
                            }
                        } else {
                            gameDone = true;
                        }
                    } else {
                        System.out.println("Dat is incorrect. Probeer het opnieuw. Hier zijn je hints: "
                                + results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Fout: Zorg ervoor dat je precies 4 kleuren invoert.");
                    currentTurn++;   
                    continue;        
                } catch (InputMismatchException e) {
                    System.out.println("Fout: Voer 4 geldige kleuren in.");
                    currentTurn++;
                    continue;
                }
                currentTurn++;

            }

        }

        scanner.close();
    }
}
