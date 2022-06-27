package game;

public class Printer{

    public static void printOut(Field field){
        for (int h = 0; h < field.fieldHeight; h++) {
            for (int l = 0; l < field.fieldLength; l++) {
                if (field.field[h][l]||field.shape.getCurrentFigure(h,l)) System.out.print("███");
                else System.out.print("░░░");
            }
            System.out.println(" ");
        }
    }
}
