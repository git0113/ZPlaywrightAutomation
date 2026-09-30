package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtilities {

    public static String generateRandomName() {
        Random random = new Random();
        int length = 8;
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = (char) ('A' + random.nextInt(26));
            name.append(ch);
        }

        System.out.println(name);
        return name.toString();
    }

    public static String generateRandomName(int lengthOfName) {
        Random random = new Random();
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < lengthOfName; i++) {
            char ch = (char) ('A' + random.nextInt(26));
            name.append(ch);
        }

        System.out.println(name);
        return name.toString();
    }

    public static String generateRandomEmail() {
        Random random = new Random();
        int length = 8;
        StringBuilder name = new StringBuilder();
        String emailSuffix = "@gmail.com";

        for (int i = 0; i < length; i++) {
            char ch = (char) ('A' + random.nextInt(26));
            name.append(ch);
        }

        String email = name + emailSuffix;
        System.out.println(email);
        return email;
    }

    public static String generateRandomPhoneNumber() {
        int firstDigit = ThreadLocalRandom.current().nextInt(6, 10);
        long remainingDigits =
                ThreadLocalRandom.current().nextLong(0, 1_000_000_000L);

        return firstDigit + String.format("%09d", remainingDigits);
    }

    public static boolean textboxIsEmpty(Locator locator)
    {
        String value = locator.inputValue();
        boolean empty = false;
        if (!value.isEmpty()) {
            System.out.println("Textbox is already filled");
        }
        return empty;
    }

    public static void  selectDropdownByVisibleText(Locator dropDown, String value)
    {
        dropDown.selectOption(new SelectOption().setLabel(value));
    }

    public static void selectDropdownByIndex(Locator dropDown, int index)
    {
        dropDown.selectOption(new SelectOption().setIndex(index));
    }

    public static void selectDropdownByValue(Locator dropDown, String value)
    {
        dropDown.selectOption(new SelectOption().setValue(value));
    }

    public static Map<String, String> generateRandomDOB()
    {
        Map<String, String> dob= new HashMap<String, String>();
        String randomDay = String.valueOf(ThreadLocalRandom.current().nextInt(1, 32));
        Month monthName = Month.of(ThreadLocalRandom.current().nextInt(1, 13));
        String randomMonth = monthName.name().substring(0, 1) + monthName.name().substring(1).toLowerCase();
        String randomYear = String.valueOf(ThreadLocalRandom.current().nextInt(2000, 2011));
        System.out.println("DOB: " + randomDay + " " + randomMonth + " " + randomYear);
        dob.put("day", randomDay);
        dob.put("month", randomMonth);
        dob.put("year", randomYear);
        return dob;
    }

    public static void checkCheckbox(Locator locator)
    {
        if(!(locator.isChecked()))
        {
            locator.click();
        }
    }

    public static void uncheckCheckbox(Locator locator)
    {
        if(locator.isChecked())
        {
            locator.click();
        }
    }

}
