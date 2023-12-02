package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class partOne {
    
    public static int sumOfAllCalibrationValues() {
         //System.out.println(Integer.parseInt("3"));
    int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input1.txt"))) {
     String line = null;
     while ((line = fileReader.readLine()) != null) {
        int firstNum = 10;
        int lastNum = 0;
         for(int i = 0; i < line.length(); i++) {
           try {
            int num = Integer.parseInt(String.valueOf(line.charAt(i)));
             if (firstNum == 10) {
               firstNum = num;
             }
             lastNum = num;
           }
           catch (Exception x) {
             //System.out.println(x);
           }
         }
        int value = Integer.parseInt(String.valueOf(firstNum) + String.valueOf(lastNum));
        sum = sum + value;
        System.out.println(value);
         }
         System.out.println(sum);
         return sum;
       
   }
    catch (IOException x) {
        System.err.format("IOException: %s%n", x);
        return 0;
    }
    }
}
