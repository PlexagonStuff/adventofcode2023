package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class partTwo {

    public static int sumOfAllCalibrationValues() {
        // System.out.println(Integer.parseInt("3"));
        int sum = 0;
        try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input1.txt"))) {
            String line = null;
            String[] digitStrings = {"one","two","three","four","five","six","seven","eight","nine"};
            int[] digitValues = {1,2,3,4,5,6,7,8,9};
            while ((line = fileReader.readLine()) != null) {
                int firstNum = 0;
                int firstNumIndex = 100;
                int lastNum = 0;
                int lastNumIndex = -1;

                //Checking for digit substrings
                for (int z = 0; z < digitStrings.length; z++) {
                    int numIndex = line.indexOf(digitStrings[z]);
                    int finalNumIndex = line.lastIndexOf(digitStrings[z]);
                    System.out.println(numIndex);
                    System.out.println(finalNumIndex);
                    if (numIndex != -1) {
                        if (numIndex < firstNumIndex) {
                            firstNumIndex = numIndex;
                            firstNum = digitValues[z];
                        }
                        if (finalNumIndex > lastNumIndex) {
                            lastNum = digitValues[z];
                            lastNumIndex = finalNumIndex;
                        }
                    }
                }

                //Checking for digits
                for (int i = 0; i < line.length(); i++) {
                    try {
                        int num = Integer.parseInt(String.valueOf(line.charAt(i)));
                        if (i < firstNumIndex) {
                            firstNum = num;
                            firstNumIndex = i;
                        }
                        if (i > lastNumIndex) {
                            lastNum = num;
                            lastNumIndex = i;
                        }
                    } catch (Exception x) {
                        // System.out.println(x);
                    }
                }
                int value = Integer.parseInt(String.valueOf(firstNum) + String.valueOf(lastNum));
                sum = sum + value;
                System.out.println(value);
            }
            System.out.println(sum);
            return sum;

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            return 0;
        }
    }
}
