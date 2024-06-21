package src;


class Binary implements Base {
    private int parseIntFromString(String str) {
        int outputInt = 0;
        int strLength = str.length();

        int i = strLength - 1;
        for (char c : str.toCharArray()) {
            if (c != '1') {
                i--;
                continue;
            };

            outputInt += 1 << i;

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

    private String decimalToBinary(int num) {
        String str = "";

        int cursor = 1;
        while (cursor < num) {
            cursor *= 2;
        };

        while (cursor > 0) {
            if ((num & cursor) == 0) {
                str += "0";
            } else {
                str += "1";
            };

            cursor /= 2;
        }

        for (char c : str.toCharArray()) {
            if (c != '0' || str.length() == 1) break;

            str = str.substring(1);
        };

        return str;
    }

    public String decToBase(int[] decArray) {
        String str = "";

        for (int i : decArray) {
            str += decimalToBinary(i) + " ";
        };

        return str;
    }
}