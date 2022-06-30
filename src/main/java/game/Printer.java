package game;
//
import game.shape.Shape;

public class Printer{
    private static final String black = "\u001B[30m";//black
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void printOut(int fieldHeight, int fieldLength, boolean[][] field, String[][] colorsField, Shape shape) {
        clearScreen();
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (shape.getCurrentFigure(h, l)) System.out.print(shape.getCurrentColors(h, l) + "[8]"+ANSI_RESET);
                else if (field[h][l]) System.out.print(colorsField[h][l] + "[X]"+ANSI_RESET);
                else if (h<3) System.out.print(ANSI_RED+"|:|"+ANSI_RESET);
                else System.out.print(black+"|:|"+ANSI_RESET);
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
