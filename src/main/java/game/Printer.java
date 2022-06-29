package game;
//
import game.shape.Shape;

public class Printer{

    public static void printOut(int fieldHeight, int fieldLength, boolean[][] field, String[][] colorsField, Shape shape) {
        clearScreen();
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (field[h][l]) System.out.println(shape.getCurrentColors(h, l) + "[B]");
                if (shape.getCurrentFigure(h, l)) System.out.print(colorsField[h][l] + "[X]");
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
