package lection9.task4;

import java.util.Arrays;

public class TextFormater {

    public static int getCountWordsInLine(String line) {
        int countSpace = 0;
        int endIndex=0;
        String trim = line.trim();
        char[] chars = trim.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int nextIndex = Math.min(chars.length - 1, i + 1);
            if (chars[i] == ' ' && chars[nextIndex] != ' ') {
                countSpace++;
            }
        }
        return countSpace + 1;
    }

    public static boolean isPolyndrom(String line) {
        String trim = line.trim();
        int countOfPolyndrom=0;
        String[] split = trim.split(" ");
        for (String element : split) {
            char[] chars = element.toCharArray();


            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ',' || chars[i] == ';' || chars[i] == ':' || chars[i] == '.' || chars[i] == '!' || chars[i] == '?' || chars[i]=='-'){
                    chars[i]=' ';
                }
            }
            String stringClear = String.valueOf(chars);
            String trimStringClear = stringClear.trim();

            StringBuffer stringBuffer = new StringBuffer(trimStringClear);
            StringBuffer reverse = stringBuffer.reverse();
            String reverseString = reverse.toString();
            //System.out.println(element);
            //System.out.println(reverseString);
            if (trimStringClear.equalsIgnoreCase(reverseString) && trimStringClear.length()>1){
                countOfPolyndrom++;
                System.out.println(trimStringClear);
                break;
            }
        }

        if (countOfPolyndrom>0) {
            return true;
        }
        return false;
    }
}

