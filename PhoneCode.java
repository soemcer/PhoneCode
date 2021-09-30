import java.util.Scanner;

public class PhoneCode

{

    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)

    {

        int areaCode = 305;
        int number;
        String encodedAreaCode;
        String encodedNumber;

        do

        {

            System.out.print("Please enter your 305 phone number: ");
            number = keyboard.nextInt();

            if (number < 1000000 || number > 9999999)
                System.out.println("You entered an invalid number, please enter a new one.");

        } while (number < 1000000 || number > 9999999);

        encodedAreaCode = encoder(areaCode);
        encodedNumber = encoder(number);

        System.out.print("The phone number " + areaCode + number + " can be encoded as " + encodedAreaCode + encodedNumber);

    }

    private static String encoder(int valueToEncode)

    {

        int totalDigits = 7;
        if (valueToEncode < 1000)
            totalDigits = 3;

        char[] fullyEncoded = new char[totalDigits];
        int[] digits = new int[totalDigits];

        if (totalDigits == 7)

        {

            digits[6] = valueToEncode % 10;
            digits[5] = (valueToEncode % 100) / 10;
            digits[4] = (valueToEncode % 1000) / 100;
            digits[3] = (valueToEncode % 10000) / 1000;
            digits[2] = (valueToEncode % 100000) / 10000;
            digits[1] = (valueToEncode % 1000000) / 100000;
            digits[0] = (valueToEncode % 10000000) / 1000000;

        }

        if (totalDigits == 3)

        {

            digits[2] = valueToEncode % 10;
            digits[1] = (valueToEncode % 100) / 10;
            digits[0] = (valueToEncode % 1000) / 100;

        }

        char[] startingLetters = {'0', '1', 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W'};
        int[] numOptions = {1, 1, 3, 3, 3, 3, 3, 4, 3, 4};

        for (int i = 0; i < fullyEncoded.length; ++i)
            fullyEncoded[i] = (char) (startingLetters[digits[i]] + (Math.floor(Math.random() * numOptions[digits[i]])));

        String string = String.valueOf(fullyEncoded);
        return string;

    }

}
