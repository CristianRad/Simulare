package Domain;

import java.util.Calendar;

public class BillValidator {

    /**
     * Validates a bill.
     * @param bill is the bill to validate.
     * @throws BillValidatorException is there are validation errors.
     */

    public void validate(Bill bill) {
        if (bill.getDate().length() != 10 || bill.getDate().charAt(2) != '.' || bill.getDate().charAt(5) != '.')
            throw new BillValidatorException("Invalid format! Date should be dd.mm.yyyy!");

        String errors = "";
        int day = Integer.parseInt(bill.getDate().substring(0, 2));
        int month = Integer.parseInt(bill.getDate().substring(3, 5));
        int year = Integer.parseInt(bill.getDate().substring(6, 10));

        if (year < 1980 || year > Calendar.getInstance().get(Calendar.YEAR))
            errors += "The year must be between 1980 and " + Calendar.getInstance().get(Calendar.YEAR) + "!\n";
        if (month < 1 || month > 12)
            errors += "The month must be between 1 and 12!\n";
        if ((month == 1 || month == 3 || month == 5 || month ==7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31))
            errors += "The day must be between 1 and 31 for month " + month + "!\n";
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day >30))
            errors += "The day must be between 1 and 30 for month " + month + "!\n";
        if (month == 2)
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                if (day < 1 || day > 29)
                    errors += "The day must be between 1 and 29 for month 2 of the year " + year + "!\n";
            } else if (day < 1 || day > 28)
                errors += "The day must be between 1 and 28 for month 2 of the year " + year + "!\n";

        if (!errors.isEmpty())
            throw new BillValidatorException("\n" + errors);
    }

}
