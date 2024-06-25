package src;


class Octal implements Base {
    private static String octDigits = "01234567";

    private int charToIntValue(char c) {
        int i = 0;
        for (char o : octDigits.toCharArray()) {
            if (c == o) break;
            i++;
        };

        return i;
    }

    private int parseIntFromString(String str) {
        int outputInt = 0;
        int strLength = str.length();

        int i = str.length();
        for (char c : str.toCharArray()) {
            int value = charToIntValue(c);

            for (int j = 1; j < i; j++) {
                value *= 8;
            };
            outputInt += value;

            i--;
        };

        return outputInt;
    };

    public int[] baseToDec(String base) {
        String[] splitStrings = base.split("\\s+");
        int[] decArray = new int[splitStrings.length];

        int i = 0;
        for (String str : splitStrings) {
            int parsedInt = parseIntFromString(str);
            decArray[i] = parsedInt;
            i++;
        };

        return decArray;
    }

    public String decToBase(int[] decArray) {
        String str = "";

        for (int i : decArray) {
            int num = i;
            String numString  = " ";

            do {
                numString = octDigits.toCharArray()[num % 8] + numString;
                num /= 8;
            } while (num >= 1);

            str += numString;
        };

        return str;
    }
}