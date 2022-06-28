package game.figure;

import java.util.Scanner;

import static game.Field.loss;

public class Interactions implements Runnable{
    Scanner scanner = new Scanner(System.in);
    public char button;
    public void run(){
        while (!loss){
            char button = scanner.next().charAt(0);
        }
    }
}
