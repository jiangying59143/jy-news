package com.jy.eureka;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("A", 4));
    }

    public static String convert(String s, int numRows) {
        int size = s.length();
        int columnSize=0;
        while(size>=0){
            if(columnSize % (numRows-1) == 0){
                size-=numRows;
                columnSize++;
            }else{
                size-=1;
                columnSize++;
            }
        }
        int k=0;
        Character[][] charArr = new Character[numRows][columnSize];
        for (int i = 0; i < columnSize; i++) {
            if(i % (numRows-1) == 0){
                for (int j = 0; j < numRows && k < s.length(); j++) {
                    charArr[j][i] = s.charAt(k);
                    k++;
                }
            }else if(k < s.length()){
                charArr[(numRows-1) - i % (numRows-1)][i] = s.charAt(k);
                k++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character[] characters : charArr) {
            for (Character character : characters) {
                if(character != null) {
                    sb.append(character.charValue());
                }
            }
        }

        return sb.toString();

    }
}
