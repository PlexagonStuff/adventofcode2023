package Day3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class partTwo {

public static int getSumOfAllGames() {

int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input3.txt"))) {
    String line = null;
    Pattern pattern = Pattern.compile("[-;:#*!$=/@%-&+]");
    Pattern endTheStupidNumber = Pattern.compile("[*]");
    String previousLine = "..........";
    int symbolsFound = 0;
    int lastCharIndex = 0;
    ArrayList<String> input = new ArrayList<>();
    ArrayList<String> correctNumbers = new ArrayList<>(Arrays.asList("0"));
    while ((line = fileReader.readLine()) != null) {
        input.add(line);
        }
        System.out.println("Did this happen?");

    for (int rowIndex = 0; rowIndex < input.size(); rowIndex++) {
        for (int charIndex = 0; charIndex < input.get(rowIndex).length(); charIndex++) {
            //If this is a digit, then it is time to check for weird symbols
            
            if (endTheStupidNumber.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex))).find() ) {
                ArrayList<String> digits = new ArrayList<>();
                ArrayList<Integer> digitIndex = new ArrayList<>();
                ArrayList<Integer> digitRow = new ArrayList<>();

                //Just like PEMDAS, order matters

                //Down
                if (!(rowIndex+1 > input.size()-1)) {
                    if (Character.isDigit(input.get(rowIndex+1).charAt(charIndex))) {
                       if (digitRow.contains(rowIndex+1)) {
                        if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex+1))-(charIndex)) > 1) {
                            digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex)));
                            digitIndex.add(charIndex);
                            digitRow.add(rowIndex+1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex)));
                            digitIndex.add(charIndex);
                            digitRow.add(rowIndex+1);
                        }
                        }
                }
                //Up
                if (!(rowIndex-1 < 0)) {
                    if (Character.isDigit(input.get(rowIndex-1).charAt(charIndex))) {
                       if (digitRow.contains(rowIndex-1)) {
                        if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex-1))-(charIndex)) > 1) {
                            digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex)));
                            digitIndex.add(charIndex);
                            digitRow.add(rowIndex-1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex)));
                            digitIndex.add(charIndex);
                            digitRow.add(rowIndex-1);
                        }
                        }
                }



                // Right
                if (!(charIndex + 1 > input.get(rowIndex).length() - 1)) {
                    if (Character.isDigit(input.get(rowIndex).charAt(charIndex+1))) {
                       if (digitRow.contains(rowIndex)) {
                        if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex))-(charIndex+1)) > 1) {
                            digits.add(String.valueOf(input.get(rowIndex).charAt(charIndex+1)));
                            digitIndex.add(charIndex + 1);
                            digitRow.add(rowIndex);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex).charAt(charIndex+1)));
                            digitIndex.add(charIndex + 1);
                            digitRow.add(rowIndex);
                        }
                        }
                          //Up
                        if (!(rowIndex -1 < 0)) {
                            if (Character.isDigit(input.get(rowIndex-1).charAt(charIndex+1))) {
                                if (digitRow.contains(rowIndex-1)) {
                                    if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex-1))-(charIndex+1)) > 1) {
                                        digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex+1)));
                                        digitIndex.add(charIndex + 1);
                                        digitRow.add(rowIndex-1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex+1)));
                            digitIndex.add(charIndex + 1);
                            digitRow.add(rowIndex-1);
                        }
                        }
                        }
                        if (!(rowIndex+1 > input.size()-1)) {
                           if (Character.isDigit(input.get(rowIndex+1).charAt(charIndex+1))) {
                                if (digitRow.contains(rowIndex+1)) {
                                    if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex+1))-(charIndex+1)) > 1) {
                                        digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex+1)));
                                        digitIndex.add(charIndex + 1);
                                        digitRow.add(rowIndex+1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex+1)));
                            digitIndex.add(charIndex + 1);
                            digitRow.add(rowIndex+1);
                        }
                        } 
                        }
                      
                    }
                
                //Left
                if (!(charIndex - 1 < 0)) {
                    if (Character.isDigit(input.get(rowIndex).charAt(charIndex-1))) {
                        System.out.println("Cruel");
                       if (digitRow.contains(rowIndex)) {
                        System.out.println("Summer");
                        System.out.println(digitIndex.get(digitRow.indexOf(rowIndex)));
                        System.out.println(charIndex-1);
                        System.out.println(Math.abs(digitIndex.get(digitRow.indexOf(rowIndex))-charIndex-1));
                        if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex))-(charIndex-1)) > 1) {
                            System.out.println("T.S.");
                            digits.add(String.valueOf(input.get(rowIndex).charAt(charIndex-1)));
                            digitIndex.add(charIndex - 1);
                            digitRow.add(rowIndex);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex).charAt(charIndex-1)));
                            digitIndex.add(charIndex - 1);
                            digitRow.add(rowIndex);
                        }
                        }
                          //Up
                        if (!(rowIndex -1 < 0)) {
                            if (Character.isDigit(input.get(rowIndex-1).charAt(charIndex-1))) {
                                if (digitRow.contains(rowIndex-1)) {
                                    if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex-1))-(charIndex-1)) > 1) {
                                        digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex-1)));
                                        digitIndex.add(charIndex - 1);
                                        digitRow.add(rowIndex-1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex-1).charAt(charIndex-1)));
                            digitIndex.add(charIndex - 1);
                            digitRow.add(rowIndex-1);
                        }
                        }
                        }
                        if (!(rowIndex+1 > input.size()-1)) {
                           if (Character.isDigit(input.get(rowIndex+1).charAt(charIndex-1))) {
                                if (digitRow.contains(rowIndex+1)) {
                                    if (Math.abs(digitIndex.get(digitRow.indexOf(rowIndex+1))-(charIndex-1)) > 1) {
                                        digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex-1)));
                                        digitIndex.add(charIndex - 1);
                                        digitRow.add(rowIndex+1);
                        }
                        }
                        else {
                            digits.add(String.valueOf(input.get(rowIndex+1).charAt(charIndex-1)));
                            digitIndex.add(charIndex - 1);
                            digitRow.add(rowIndex+1);
                        }
                        } 
                        }
                }
                
                
                
                System.out.println(digits.size());
                System.out.println(Arrays.toString(digits.toArray()));
                System.out.println(Arrays.toString(digitIndex.toArray()));
                System.out.println(Arrays.toString(digitRow.toArray()));
                //System.out.println();
                if (digits.size() > 1) {
                    System.out.println("Hello!");
                    ArrayList<String> actualCorrectNumbers = new ArrayList<>(Arrays.asList("0"));
                    ArrayList<Integer> actualCorrectRow = new ArrayList<>(Arrays.asList(0));
                    for (int v = 0; v < digits.size(); v++) {
                    //System.out.println(digits.get(v));
                    String number = "1";
                    //System.out.println(digits.size());
                    //System.out.println(number);
                    //System.out.println(charIndex);
                    int newIndex = -1;
                    int oldIndex = -1;
                    int funnyRow = digitRow.get(v);
                    System.out.println("This is the digit" + digits.get(v));
                    System.out.println("This is the row" + String.valueOf(funnyRow));
                    int funnyChar = digitIndex.get(v);
                    System.out.println("This is the index" + funnyChar);
                    String test = "........................#....374...382....250...*..........737*....*896.395...........*....................$.........................#......";
                    //System.out.println(test.charAt(61));
                    String[] splits = input.get(funnyRow).split("[-.;:#*!$=/@%-&+]");
                    System.out.println(splits.length);
                    int counter = -1;
                    for (int z = 0; z < splits.length; z++) {
                        //System.out.println(splits[z]);
                        if (splits[z].length() == 0){
                            counter++;
                        }
                        else {
                            for (int hi = 0; hi < splits[z].length(); hi++) {
                                counter++;
                                //System.out.println(counter + " inside a string");
                                if (counter == funnyChar) {
                                    System.out.println("This Index is " + String.valueOf(funnyChar));
                                    actualCorrectNumbers.add(splits[z]);
                                }
                                
                                //counter++;
                            }
                            //I have no idea why this counter would be needed, but it makes the program work so...
                            counter++;
                        }
                        //;System.out.println(counter);
                        //newIndex += Math.abs(splits[z].length()+1);
                        
                    }
                    }
                    System.out.println("Correct Numbers" + Arrays.toString(actualCorrectNumbers.toArray()));
                    //System.out.println("Gear Ratio " + String.valueOf(Integer.valueOf(actualCorrectNumbers.get(1)) * Integer.valueOf(actualCorrectNumbers.get(2))));
                    if (actualCorrectNumbers.size() > 2) {
                        System.out.println("Number Size" + String.valueOf(actualCorrectNumbers.size()));
                        System.out.println("Number One " + String.valueOf(actualCorrectNumbers.get(1)));
                        System.out.println("Number Two " + String.valueOf(actualCorrectNumbers.get(2)));
                        System.out.println("Gear Ratio " + String.valueOf(Integer.valueOf(actualCorrectNumbers.get(1)) * Integer.valueOf(actualCorrectNumbers.get(2))));
                        correctNumbers.add(String.valueOf(Integer.valueOf(actualCorrectNumbers.get(1)) * Integer.valueOf(actualCorrectNumbers.get(2))));
                    }
                    //System.out.println("Number " + number);
                    //sum = sum + Integer.valueOf(number);

                }
                

            }
        }
    }
    FileWriter writer = new FileWriter("correctNumbers.txt");
    for (int plzStop = 0; plzStop < correctNumbers.size(); plzStop++) {
        writer.write(correctNumbers.get(plzStop)+"\n");
        //System.out.println(correctNumbers.get(plzStop));
        sum = sum + Integer.valueOf(correctNumbers.get(plzStop));
    }
    writer.close();
    return sum;
    }
   
    catch (IOException x) {
        System.err.format("IOException: %s%n", x);
        return 0;
    }


    
}

}