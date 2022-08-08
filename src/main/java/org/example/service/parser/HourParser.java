package org.example.service.parser;

import java.util.ArrayList;

public class HourParser extends Parser {

    public HourParser() {
        minRange = 0;
        maxRange = 23;
        allowedCharacters = new ArrayList<>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }
}
