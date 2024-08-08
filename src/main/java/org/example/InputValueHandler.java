package org.example;

public class InputValueHandler {

    public int optionValidate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return MainOptions.INCORRECT.getNumber();
        }
    }
}
