package org.example.service;

import org.example.model.CronExpressionDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CronExpressionParserUnitTest {

    CronExpressionParser parser = new CronExpressionParser();

    @Test
    public void testValidInput() {
        String expression = "*/15 0 1,15 * 1-5 /usr/bin/find";
        CronExpressionDetail expressionDetail = parser.parseExpression(expression);

        Assertions.assertEquals(List.of(0,15,30,45), expressionDetail.getMinutes());
        Assertions.assertEquals(List.of(0), expressionDetail.getHours());
        Assertions.assertEquals(List.of(1,15), expressionDetail.getDays());
        Assertions.assertEquals(List.of(1,2,3,4,5,6,7,8,9,10,11,12), expressionDetail.getMonths());
        Assertions.assertEquals(List.of(1,2,3,4,5), expressionDetail.getWeekdays());
        Assertions.assertEquals("/usr/bin/find", expressionDetail.getCommand());
    }

    @Test
    public void testInvalidNumberOfInputArgs() {
        String expression = "*/15 1,15 * 1-5 /usr/bin/find";
        CronExpressionDetail expressionDetail = parser.parseExpression(expression);
        Assertions.assertNull(expressionDetail);
    }

    @Test
    public void getCronExpressionWithInvalidWeekDayInput() {
        String expression = "1/15 0 * 1-5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }

    @Test
    public void getCronExpressionWithUnsupportedDayInput() {
        String expression = "1/15 0 1,##15 * 1-5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }

    @Test
    public void getCronExpressionWithUnsupportedHourInput() {
        String expression = "1/15 % 1,15 * 1-5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }
    @Test
    public void getCronExpressionWithUnsupportedMinuteInput() {
        String expression = "1/#15 0 1,15 * 1-5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }
    @Test
    public void getCronExpressionWithUnsupportedMonthInput() {
        String expression = "1/15 0 1,15 # 1-5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }
    @Test
    public void getCronExpressionWithUnsupportedWeekDayInput() {
        String expression = "1/15 0 1,15 * 1-&5 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }

    @Test
    public void getCronExpressionWithOutOfRangeWeekDayInput() {
        String expression = "1/15 0 1,15 * 1-9 /usr/bin/find";
        CronExpressionDetail cronExpression = parser.parseExpression(expression);
        Assertions.assertNull(cronExpression);
    }

}
