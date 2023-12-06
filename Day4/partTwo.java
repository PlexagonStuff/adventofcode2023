package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class partTwo {

public static int getSumOfAllGames() {
String [] colors = {"red","green","blue"};
int [] maxColors = {12,13,14};
int sum = 0;
   try (BufferedReader fileReader = Files.newBufferedReader(Paths.get("input4.txt"))) {
     String line = null;
     ArrayList<Integer> cardNumbers = new ArrayList<>();
     ArrayList<Integer> cardSize = new ArrayList<>();
     while ((line = fileReader.readLine()) != null) {
        String[] splits = line.split("[|:]+");
        System.out.println(Arrays.toString(splits));
        String [] cardTitle = splits[0].split(" ");
        for (int j = 0; j < cardTitle.length; j++) {
            try {
                cardNumbers.add(Integer.parseInt(cardTitle[j]));
            } catch (Exception y){
                

            }

            }
        
        //cardNumbers.add(Integer.valueOf(cardTitle[1]));
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
        cardSize.add(Integer.valueOf(intersection.length));
    }
    System.out.println("Hello?");
    ArrayList<Integer> cardRecursion = (ArrayList<Integer>)cardNumbers.clone();
    System.out.println(Arrays.toString(cardNumbers.toArray()));
    System.out.println(Arrays.toString(cardSize.toArray()));

    for (int i = 0; i < cardRecursion.size(); i++) {
        int theNumber = cardRecursion.get(i);
        int size = cardSize.get(cardNumbers.indexOf(theNumber));
        for (int z = 0; z < size; z++) {
            cardRecursion.add(theNumber + (z+1));
        }
    }
    System.out.println(Arrays.toString(cardRecursion.toArray()));
    
    
       
   
   return cardRecursion.size();
}
    catch (IOException x) {
        System.err.format("IOException: %s%n", x);
        return 0;
    }


}
}
