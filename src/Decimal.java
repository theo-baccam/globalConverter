package src;


class Decimal implements Base {
    public int[] baseToDec(String base) {
        String[] splitStrings = base.split("\\s+");
        int[] decArray = new int[splitStrings.length];
        
        int i = 0;
        for (String str : splitStrings) {
            Integer parsedInt = Integer.parseInt(str);
            int intPrimitive = parsedInt.intValue();
            decArray[i] = intPrimitive;
            i++;
        };

        return decArray;
    }

    public String decToBase(int[] decArray) {
        String str = "";

        for (int i : decArray) {
            str += i + " ";
        };

        return str;
    }
}