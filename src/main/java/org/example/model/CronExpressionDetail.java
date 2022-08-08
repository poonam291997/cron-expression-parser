package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class CronExpressionDetail {

    List<Integer> minutes;
    List<Integer> hours;
    List<Integer> days;
    List<Integer> months;
    List<Integer> weekdays;
    String command;

    public CronExpressionDetail() {
        minutes = new ArrayList<>();
        hours = new ArrayList<>();
        days = new ArrayList<>();
        months = new ArrayList<>();
        weekdays = new ArrayList<>();
    }

    public List<Integer> getMinutes() {
        return minutes;
    }

    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public List<Integer> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<Integer> weekdays) {
        this.weekdays = weekdays;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return
                "minute       " + getListOfMinutes() + "\n" +
                "hour         " + getListOfHours() + "\n" +
                "day of month " + getListOfDays() + "\n" +
                "month        " + getListOfMonths() + "\n" +
                "day of week  " + getListOfWeekdays() + "\n" +
                "command      " + getCommand() + "\n";
    }

    private String getListOfWeekdays() {
        StringBuilder sb = new StringBuilder("");
        if (!weekdays.isEmpty()) {
            weekdays.forEach((Integer weekday) -> sb.append(weekday +" "));
        }
        return sb.toString();
    }

    private String getListOfMonths() {

        StringBuilder sb = new StringBuilder("");
        if (!months.isEmpty()) {
            months.forEach((Integer month) -> sb.append(month +" "));
        }
        return sb.toString();
    }

    private String getListOfDays() {

        StringBuilder sb = new StringBuilder("");
        if (!days.isEmpty()) {
            days.forEach((Integer day) -> sb.append(day +" "));
        }
        return sb.toString();
    }

    private String getListOfHours() {
        StringBuilder sb = new StringBuilder("");
        if (!hours.isEmpty()) {
            hours.forEach((Integer hour) -> sb.append(hour +" "));
        }
        return sb.toString();
    }

    private String getListOfMinutes() {

        StringBuilder sb = new StringBuilder("");
        if (!minutes.isEmpty()) {
            minutes.forEach((Integer minute) -> sb.append(minute +" "));
        }
        return sb.toString();
    }
}
