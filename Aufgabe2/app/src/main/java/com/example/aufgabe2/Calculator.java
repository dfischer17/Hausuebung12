package com.example.aufgabe2;

public class Calculator {
    // Eingebener mathematischer Ausdruck
    private String input;
    int position = -1, currentChar;

    // Wenn der Index des naechsten Zeichen innerhalb des Arrays liegt, wird das aktuelle Zeichen auf den Wert des nächsten gesetzt
    void nextChar() {
        if (++position < input.length()) {
            currentChar = input.charAt(position);
        }
        else {
            currentChar = -1;
        }
    }

    boolean eat(int charToEat) {
        // Ueberspringt Lehrzeichen
        while (currentChar == ' ') {
            nextChar();
        }

        // Setzt das aktuelle Zeichen
        if (currentChar == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    // Art Main-Methode des Calculators
    double parse(String input) {
        this.input = input;
        nextChar();
        double result = parseExpression();
        return result;
    }

    double parseExpression() {
        double result = parseTerm();
        while (true) {
            if (eat('+')) {
                result += parseTerm(); // addition
            } else if (eat('-')) {
                result -= parseTerm(); // subtraction
            } else {
                return result;
            }
        }
    }

    double parseTerm() {
        double x = parseFactor();
        while (true) {
            if (eat('*')) {
                x *= parseFactor(); // multiplication
            } else if (eat('/')) {
                x /= parseFactor(); // division
            } else {
                return x;
            }
        }
    }

    double parseFactor() {
        // plus
        if (eat('+')) {
            return parseFactor();
        }

        // minus
        if (eat('-')) {
            return -parseFactor();
        }

        double result = 0;
        int startPos = this.position;

        // Wird eine Klammer gefunden beginnt ein neuer Ausdruck (Rekursion)
        // Klammern
        if (eat('(')) {
            result = parseExpression();
            eat(')');
        }

        // Nummern
        else if ((currentChar >= '0' && currentChar <= '9')) {
            while ((currentChar >= '0' && currentChar <= '9')) {
                nextChar();
            }
            result = Double.parseDouble(input.substring(startPos, this.position));
        }
        return result;
    }
}
