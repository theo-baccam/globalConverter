package src;


class Text implements Base {
    public int[] baseToDec(String base) {
        int[] decArray = new int[base.length()];
        int i = 0;
        for (char c : base.toCharArray()) {
            decArray[i] = (int) c;
            i++;
        };

        return decArray;
    }

    public String decToBase(int[] decArray) {
        String str = "";
        for (int i : decArray) {
            str += (char) i;
        };

        return str;
    }
}