package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.view.DateValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorUsingLocalDate implements DateValidator {
    private DateTimeFormatter dtf;

    public DateValidatorUsingLocalDate(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, this.dtf);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
