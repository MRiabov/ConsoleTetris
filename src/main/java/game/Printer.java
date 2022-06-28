package game;

public class Printer{

    private static int stepCount =1;


    public static void printOut(Field field){
        clearScreen();
        System.out.println("=======\nStep"+ stepCount+++"\n\n");
        for (int h = 0; h < field.fieldHeight; h++) {
            for (int l = 0; l < field.fieldLength; l++) {
                if (field.field[h][l]||field.shape.getCurrentFigure(h,l)) System.out.print("[B]");
                else System.out.print("|:|");
            }
            System.out.println(" ");
        }
    }
    private static void clearScreen(){
        System.out.print("\033[H\033[2J"); //clears field
        System.out.flush();
    }
}
