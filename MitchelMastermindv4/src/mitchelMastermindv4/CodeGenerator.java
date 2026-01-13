package mitchelMastermindv4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenerator {
    private static final String[] COLORS =
            {"rood", "blauw", "geel", "groen", "paars", "oranje", "leeg"};

    public String[] generateSecretCode() {
        List<String> availableColors = new ArrayList<>(Arrays.asList(COLORS));
        String[] code = new String[4];

        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * availableColors.size());
            code[i] = availableColors.remove(random);
        }
        return code;
    }

    public static String[] getAllowedColors() {
        return COLORS;
    }

}
