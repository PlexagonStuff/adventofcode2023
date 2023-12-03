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

public class partOne {

public static int getSumOfAllGames() {

int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input3.txt"))) {
    String line = null;
    Pattern pattern = Pattern.compile("[-;:#*!$=/@%-&+]");
    Pattern endTheStupidNumber = Pattern.compile("[.;:#*!$=/@%-&+]+");
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
            if (Character.isDigit(input.get(rowIndex).charAt(charIndex))) {
                Matcher rightMatcher = pattern.matcher("...");
                Matcher rightDownMatcher = pattern.matcher("...");
                Matcher rightUpMatcher = pattern.matcher("...");
                Matcher leftMatcher = pattern.matcher("...");
                Matcher leftUpMatcher = pattern.matcher("...");
                Matcher leftDownMatcher = pattern.matcher("...");
                Matcher upMatcher = pattern.matcher("...");
                Matcher downMatcher = pattern.matcher("...");
                
                //System.out.println("Did everything explode yet?");
                if (rowIndex == 0) {
                    if (!(charIndex + 1 > input.get(rowIndex).length()-1)) {
                        rightMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex + 1)));
                        rightDownMatcher = pattern.matcher(String.valueOf(input.get(rowIndex+1).charAt(charIndex + 1)));
                    }
                    if (!(charIndex - 1 < 0)) {
                        leftMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex - 1)));
                        leftDownMatcher = pattern.matcher(String.valueOf(input.get(rowIndex + 1).charAt(charIndex - 1)));
                    }
                    downMatcher = pattern.matcher(String.valueOf(input.get(rowIndex+1).charAt(charIndex)));
                }
                else if (rowIndex == input.size()-1) {
                    if (!(charIndex + 1 > input.get(rowIndex).length()-1)) {
                        rightMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex + 1)));
                        rightUpMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex + 1)));
                        }
                    if (!(charIndex - 1 < 0)) {
                        leftMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex - 1)));
                        leftUpMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex - 1)));
                    }
                    upMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex)));

                    
                }
                else {
                    if (!(charIndex + 1 > input.get(rowIndex).length()-1)) {
                        rightMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex + 1)));
                        rightUpMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex + 1)));
                        rightDownMatcher = pattern.matcher(String.valueOf(input.get(rowIndex+1).charAt(charIndex + 1)));
                    }
                    if (!(charIndex - 1 < 0)) {
                    leftMatcher = pattern.matcher(String.valueOf(input.get(rowIndex).charAt(charIndex - 1)));
                    leftUpMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex - 1)));
                    leftDownMatcher = pattern.matcher(String.valueOf(input.get(rowIndex+1).charAt(charIndex - 1)));
                    }
                    upMatcher = pattern.matcher(String.valueOf(input.get(rowIndex-1).charAt(charIndex)));
                    downMatcher = pattern.matcher(String.valueOf(input.get(rowIndex+1).charAt(charIndex)));
                }
                if (upMatcher.find() || rightMatcher.find() || leftMatcher.find() || rightUpMatcher.find() || leftUpMatcher.find() || rightDownMatcher.find() || leftDownMatcher.find() || downMatcher.find()) {
                    String number = "1";
                    //System.out.println(number);
                    //System.out.println(charIndex);
                    int newIndex = -1;
                    int oldIndex = -1;
                    String[] splits = input.get(rowIndex).split("[-.;:#*!$=/@%-&+]");
                    //System.out.println(splits.length);
                    for (int z = 0; z < splits.length; z++) {
                        //System.out.println(splits[z]);
                        oldIndex = newIndex;
                        newIndex += Math.abs(splits[z].length()+1);
                        //System.out.println(newIndex);
                        if (((oldIndex < charIndex) && (charIndex < newIndex)) && (splits[z].contains(String.valueOf(input.get(rowIndex).charAt(charIndex))))) {
                            
                            if (!(correctNumbers.get(correctNumbers.size()-1).equals(splits[z])) ) {
                                correctNumbers.add(splits[z]);
                            }
                            else if ((correctNumbers.get(correctNumbers.size()-1).equals(splits[z])) && (Math.abs(lastCharIndex- charIndex) > 2)) {
                                correctNumbers.add(splits[z]);

                            }
                            //This is in case there is a duplicate next to each other relatively, and this lastCharIndex checks the distance between found characters to find signigicance. THe characters far apart have seperation compared to double counting within a word, so it works.
                            lastCharIndex = charIndex;
                            
                        }
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
        System.out.println(correctNumbers.get(plzStop));
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