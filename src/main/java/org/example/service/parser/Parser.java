package org.example.service.parser;

import org.example.exception.InvalidParameterException;
import org.example.exception.OutOfRangeException;
import org.example.exception.UnsupportedCharacterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Parser {

    List<Character> allowedCharacters;
    int maxRange;
    int minRange;

    private void validateInput(String inputStr) throws Exception {
        if (inputStr == null || inputStr.isEmpty()) {
            throw new InvalidParameterException(this.getClass().getName());
        }
        for (Character c : inputStr.toCharArray()) {
            if (!allowedCharacters.contains(c) && !((c - '0') >= 0 && (c - '0') <= 9))
                throw new UnsupportedCharacterException(this.getClass().getName());
        }
    }

    public List<Integer> getParsedValue(String str) throws Exception {
        validateInput(str);
        List<Integer> values = new ArrayList<>();
        if (Pattern.matches("\\d+(,\\d+)*", str)) {
            values = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (Integer value : values) {
                if (value < minRange || value > maxRange)
                    throw new OutOfRangeException(this.getClass().getName());

            }

        } else if (Pattern.matches("\\d+-\\d+", str)) {

            List<Integer> valueRange = Arrays.stream(str.split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int startFrom = valueRange.get(0);
            int endTill = valueRange.get(1);
            if (
                    startFrom <= endTill &&
                            startFrom >= minRange && startFrom <= maxRange &&
                            endTill >= minRange && endTill <= maxRange
            ) {
                IntStream.rangeClosed(valueRange.get(0), valueRange.get(1)).forEach(values::add);
            } else throw new OutOfRangeException(this.getClass().getName());

        } else if (Pattern.matches("\\*", str)) {

            IntStream.rangeClosed(minRange, maxRange).forEach(values::add);

        } else if (Pattern.matches("\\*/\\d+", str)) {

            List<String> valueRange = Arrays.stream(str.split("/")).collect(Collectors.toList());
            ;
            int incrementBy = Integer.parseInt(valueRange.get(1));
            for (int i = minRange; i >= minRange && i <= maxRange; i += incrementBy) values.add(i);

        } else if (Pattern.matches("\\d+/\\d+", str)) {

            List<String> valueRange = Arrays.stream(str.split("/")).collect(Collectors.toList());
            int startFrom = Integer.parseInt(valueRange.get(0));
            int incrementBy = Integer.parseInt(valueRange.get(1));
            if (startFrom < minRange || startFrom > maxRange) throw new OutOfRangeException(this.getClass().getName());
            for (int i = startFrom; i >= minRange && i <= maxRange; i += incrementBy) values.add(i);

        } else {
            throw new RuntimeException("Unable to parse the pattern");
        }
        return values;
    }

}

