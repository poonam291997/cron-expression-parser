package org.example;

import org.example.model.CronExpressionDetail;
import org.example.service.CronExpressionParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class CronExpressionParserRunner {

    public static void main(String[] args) {

        try {
            handleInput();
        } catch (IOException ex) {
            System.out.println("Something went wrong. Please try again!");
        }
    }

    public static void handleInput() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter expression to be parsed or enter exit : ");
                String inputLine = inputReader.readLine();
                if (inputLine == null) {
                    break;
                }

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) {
                    continue;
                }

                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                processInputLine(inputLine);
            }
        } finally {
            inputReader.close();
        }
    }

    public static void processInputLine(String expression) {
        CronExpressionParser cronExpressionParser = new CronExpressionParser();
        CronExpressionDetail expressionDetail = cronExpressionParser.parseExpression(expression);
        System.out.println(Objects.requireNonNullElse(expressionDetail, "Cron expression is not found"));
    }
}