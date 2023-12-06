package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class partOne {

public static int getSumOfAllGames() {
String [] colors = {"red","green","blue"};
int [] maxColors = {12,13,14};
int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input4.txt"))) {
     String line = null;
     while ((line = fileReader.readLine()) != null) {
        String[] splits = line.split("[|:]+");
        System.out.println(Arrays.toString(splits));
        String[] winning = splits[2].split(" ");
        ArrayList<String> actualWinning = new ArrayList<>();
        for (int i = 0; i < winning.length; i++) {
            if (winning[i].length() > 0) {
                actualWinning.add(winning[i]);
            }
        }
        String[] numbers = splits[1].split(" ");
        ArrayList<String> actualNumbers = new ArrayList<>();
        for (int z = 0; z < numbers.length; z++) {
            if (numbers[z].length() > 0) {
                actualNumbers.add(numbers[z]);
            }
        }
        HashSet<String> set = new HashSet<>(actualWinning);
        set.retainAll(actualNumbers);
        String [] intersection = set.toArray(new String[0]);
        if (!((intersection.length -1) < 0)) {
            System.out.println(intersection.length);
            System.out.println((int)(1 + Math.pow(2, (intersection.length-1))));
            sum = sum + (int)(1 * Math.pow(2, (intersection.length-1)));

        }
}

    
       
   
   return sum;
}
    catch (IOException x) {
        System.err.format("IOException: %s%n", x);
        return 0;
    }


}
}
