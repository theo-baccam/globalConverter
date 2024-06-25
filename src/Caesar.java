package src;


public class Caesar {
    int key;

    private int parseIntFromString(String str) {
        int outputInt = 0;
        int strLength = str.length();

        boolean negative = false;
        int i = strLength;
        for (char c : str.toCharArray()) {
            if (i == strLength && c == '-') {
                negative = true;
                i--;
                continue;
            };

            int digit = (int) c - 48;
            for (int j = 1; j < i; j++) {
                digit *= 10;
            };
            outputInt += digit;
            i--;
        };

        if (negative) outputInt *= -1;

        return outputInt;
    };

    public void shift(int[] decArray) {
        int i = 0;
        for (int n : decArray) {
            decArray[i] += key;
            i++;
        };
    }

    public Caesar(String keyString) {
        this.key = parseIntFromString(keyString);
    }
}