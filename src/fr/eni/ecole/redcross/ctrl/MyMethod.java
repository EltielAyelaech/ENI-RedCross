package fr.eni.ecole.redcross.ctrl;

public class MyMethod {
    private static MyMethod instance = null;

    private MyMethod() {};

    public static synchronized MyMethod getMyMethod() {
        if (MyMethod.instance == null) {
            MyMethod.instance = new MyMethod();
        }

        return MyMethod.instance;
    }

    private boolean canBeCapitalized(char c) {
        return (c >= 'a' && c <= 'z');
    }

    public String capitalize(String str, String tokens) {
        boolean capitalizeNext = true;
        String capitalizedString = "";

        for (char c : str.toLowerCase().toCharArray()) {
            if (capitalizeNext && canBeCapitalized(c)) {
                c = (char) (c + 'A' - 'a');
                capitalizeNext = false;
            } else if (tokens.indexOf(c) != -1) {
                capitalizeNext = true;
            }
            capitalizedString += c;
        }
        return capitalizedString;
    }

    public String formatPhoneNumber(String phoneNumber) {
        char[] phoneNumberArray = phoneNumber.toCharArray();

        try {
            if (phoneNumber.length() != 10) {
                throw new Exception("incorrect length");
            }
            for (char c : phoneNumberArray) {
                if (c < '0' || c > '9') {
                    throw new Exception("invalid character");
                }
            }
        } catch (Exception exception) {
            System.err.println(
                String.format(
                    "\033[31m%s %s %s (%s)\033[39m",
                    "The phone number",
                    phoneNumber,
                    "is incorrect!",
                    exception.getMessage()
                )
            );
            return "<< incorrect phone number >>";
        }

        return String.format(
            "%c%c.%c%c.%c%c.%c%c.%c%c",
            phoneNumberArray[0],
            phoneNumberArray[1],
            phoneNumberArray[2],
            phoneNumberArray[3],
            phoneNumberArray[4],
            phoneNumberArray[5],
            phoneNumberArray[6],
            phoneNumberArray[7],
            phoneNumberArray[8],
            phoneNumberArray[9]
        );
    }
}
