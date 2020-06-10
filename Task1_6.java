package com.mikhailovskii.task1_5;

public class Task1_6 {

    public static void main(String[] args) {
        String str = "abc";

        Task1_6 task16 = new Task1_6();
        String result = task16.cutString(str);

        System.out.println(result);
    }

    private String cutString(String string) {
        String str = "";
        int counter = 1;

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                counter++;
            } else {
                str += string.charAt(i);
                str += counter;
                counter = 1;
            }
        }

        if (string.charAt(string.length() - 1) != string.charAt(string.length() - 2)) {
            counter = 1;
        }

        str += string.charAt(string.length() - 1);
        str += counter;

        if (str.length() >= string.length()) {
            return string;
        } else {
            return str;
        }

    }

}
