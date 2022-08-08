package org.example.service.parser;

import java.util.ArrayList;

public class MonthParser extends Parser {
    public MonthParser(){
        minRange = 1;
        maxRange = 12;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }
}
