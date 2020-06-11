package com.mikhailovskii.task1_5;

public class Task1_9 {

    public static void main(String[] args) {
        Task1_9 task19 = new Task1_9();

        System.out.println(task19.isStringShiftedInitial("abcde", "cdeab"));

    }

    private boolean isStringShiftedInitial(String initial, String shifted) {
        if (initial.length() != shifted.length()) {
            return false;
        }

        String doubleInitial = initial + initial;

        return doubleInitial.contains(shifted);

    }

}
