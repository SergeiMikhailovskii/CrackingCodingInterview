package com.mikhailovskii.task1_5;

public class Task1_5 {

    public static void main(String[] args) {
        Task1_5 task15 = new Task1_5();

        System.out.println(task15.isOneAway("pale", "ple"));
        System.out.println(task15.isOneAway("pales", "pale"));
        System.out.println(task15.isOneAway("pale", "bale"));
        System.out.println(task15.isOneAway("pale", "bake"));
    }

    private boolean isOneAway(String oldString, String newString) {
        String firstString, secondString;
        boolean flag = true;

        if (oldString.length() > newString.length()) {
            firstString = oldString;
            secondString = newString;
        } else {
            firstString = newString;
            secondString = oldString;
        }

        if (firstString.length() - secondString.length() > 1) {
            return false;
        }

        for (int i = 0; i < secondString.length(); i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                firstString = firstString.substring(0, i) + firstString.substring(i + 1);

                if (oldString.length() == newString.length()) {
                    secondString = secondString.substring(0, i) + secondString.substring(i + 1);
                }
                flag = false;
                break;

            }
        }

        if (flag && firstString.length() - secondString.length() == 1) {
            return true;
        }

        return firstString.equals(secondString);
    }

}
