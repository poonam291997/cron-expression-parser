package org.example.service.parser;

import java.util.ArrayList;

public class MinuteParser extends Parser {

    public MinuteParser(){
        minRange = 0;
        maxRange = 59;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }
}
