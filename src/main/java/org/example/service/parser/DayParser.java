package org.example.service.parser;

import java.util.ArrayList;

public class DayParser extends Parser {

    public DayParser(){
        minRange = 1;
        maxRange = 31;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }
}
