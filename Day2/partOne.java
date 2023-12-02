package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class partOne {

public static int getSumOfAllGames() {
String [] colors = {"red","green","blue"};
int [] maxColors = {12,13,14};
int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input2.txt"))) {
     String line = null;
     while ((line = fileReader.readLine()) != null) {
        String[] splits = line.split("[;:]+");
        int gameID = 0; 
        int overload = 0; //This is if a number of cubes is over the accepted amount
        //This splits at commas, semicolons, and colons. Found this on Google. //https://www.javatpoint.com/how-to-split-a-string-in-java-with-delimiter
        for (int i = 0; i < splits.length; i++) {
            if (i == 0) {
                String[] gameString = splits[i].split(" ");
                gameID = Integer.parseInt(gameString[1]);
                System.out.println(gameID);
            }
            else {
                String[] roundString = splits[i].split(",");
                int greenCubes = 0;
                int redCubes = 0;
                int blueCubes = 0;
                for (int y = 0; y < roundString.length; y++) {
                    System.out.println(roundString[y]);
                    String [] grabString = roundString[y].split(" ");
                    int numOfCubes = Integer.parseInt(grabString[1]);
                    System.out.println(grabString[2]);
                    String cubeColor = grabString[2];
                    if (cubeColor.equals("green")) {
                        greenCubes = greenCubes + numOfCubes;
                    }
                    else if (cubeColor.equals("red")) {
                        redCubes = redCubes + numOfCubes;
                    }
                    else {
                        blueCubes = blueCubes + numOfCubes;
                    }
                }
                System.out.println(blueCubes);
                System.out.println(redCubes);
                System.out.println(greenCubes);
                if ((redCubes > 12) || (blueCubes > 14) || (greenCubes > 13)) {
                    overload++;
                }
                
            }
        }
        if (overload == 0) {
            sum = sum + gameID;
        }
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
