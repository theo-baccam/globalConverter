package src;


class Decimal implements Base {
    private int parseIntFromString(String str) {
        int outputInt = 0;
        int strLength = str.length();

        int i = strLength;
        for (char c : str.toCharArray()) {
            int digit = (int) c - 48;
            for (int j = 1; j < i; j++) {
                digit *= 10;
            };
            outputInt += digit;
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
            str += i + "";
        };

        return str;
    }
}