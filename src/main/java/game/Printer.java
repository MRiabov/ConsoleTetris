package game;

import game.figure.Shape;

public class Printer{

   // private static int stepCount =1;

    public static void printOut(Field field){
        clearScreen();
        for (int h = 0; h < field.fieldHeight; h++) {
            for (int l = 0; l < field.fieldLength; l++) {
                if (field.field[h][l]||field.shape.getCurrentFigure(h,l)) System.out.print("[B]");
                else System.out.print("|:|");
            }
            System.out.println(" ");
        }
    }

    public static void printOut(int fieldHeight,int fieldLength, boolean[][] field, Shape shape){
        clearScreen();
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (field[h][l]||shape.getCurrentFigure(h,l)) System.out.print("[B]");
                else System.out.print("|:|");
            }
            System.out.println(" ");
        }
        System.out.println("Your input:");

    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J"); //clears field
        System.out.flush();
    }
}
