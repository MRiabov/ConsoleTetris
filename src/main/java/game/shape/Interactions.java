package game.shape;

import java.util.Scanner;

import static game.Field.loss;

public class Interactions implements Runnable{
    Scanner scanner = new Scanner(System.in);
    public static String button="s";
    public void run(){
        while (!loss){
            String input = scanner.next();
            if (input!=null) button=input;
        }
    }
}
//