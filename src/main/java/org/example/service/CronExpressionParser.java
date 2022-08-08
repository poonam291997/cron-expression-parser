package org.example.service;

import org.example.exception.InvalidParameterException;
import org.example.model.CronExpressionDetail;
import org.example.service.parser.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CronExpressionParser {

    private MinuteParser minuteParser;
    private HourParser hourParser;
    private DayParser dayParser;
    private MonthParser monthParser;
    private WeekdayParser weekdayParser;

    public CronExpressionParser() {
        minuteParser = new MinuteParser();
        hourParser = new HourParser();
        dayParser = new DayParser();
        monthParser = new MonthParser();
        weekdayParser = new WeekdayParser();
    }
    public CronExpressionDetail parseExpression(String expression) {
        CronExpressionDetail expressionDetail = new CronExpressionDetail();
        try {
            List<String> cronElements = Arrays.stream(expression.split(" ")).collect(Collectors.toList());
            validateInput(cronElements);
            expressionDetail.setMinutes(minuteParser.getParsedValue(cronElements.get(0)));
            expressionDetail.setHours(hourParser.getParsedValue(cronElements.get(1)));
            expressionDetail.setDays(dayParser.getParsedValue(cronElements.get(2)));
            expressionDetail.setMonths(monthParser.getParsedValue(cronElements.get(3)));
            expressionDetail.setWeekdays(weekdayParser.getParsedValue(cronElements.get(4)));
            expressionDetail.setCommand(cronElements.get(5));
            return expressionDetail;
            // command output

        }  catch (Exception e) {
            //log error
            System.out.println("Unable to process request due to message " + e.getMessage());
            return null;
        }
    }

    private void validateInput(List<String> cronElements) throws InvalidParameterException {

        if (cronElements.size() != 6) {
            throw new InvalidParameterException("Number of input args are not equal to 6");
        }
    }
}
