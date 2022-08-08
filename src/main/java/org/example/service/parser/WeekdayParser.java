package org.example.service.parser;

import java.util.ArrayList;

public class WeekdayParser extends Parser {

    public WeekdayParser(){
        minRange = 1;
        maxRange = 7;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }
}
