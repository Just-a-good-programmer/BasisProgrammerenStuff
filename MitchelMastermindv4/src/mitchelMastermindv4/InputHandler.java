package mitchelMastermindv4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandler {

    public String[] getGuess(Scanner scanner) {
        System.out.println("Voer 4 VERSCHILLENDE kleuren in:");
        String input = scanner.nextLine().toLowerCase();
        String[] guess = input.split(" ");

        if (guess.length != 4) {
            throw new ArrayIndexOutOfBoundsException(
                    "Fout: Zorg ervoor dat je precies 4 kleuren invoert.");
        }

        for (String color : guess) {
            if (!Arrays.asList(CodeGenerator.getAllowedColors()).contains(color)) {
                throw new InputMismatchException(
                        "Fout: Voer 4 geldige kleuren in.");
            }
        }

        return guess;
    }
}
