package game;
public class Printer{

    private static int stepcount=1;

    public static void printOut(Field field){
        System.out.println("=======\nStep"+ stepcount+++"\n\n");
        for (int h = 0; h < field.fieldHeight; h++) {
            for (int l = 0; l < field.fieldLength; l++) {
                if (field.field[h][l]||field.shape.getCurrentFigure(h,l)) System.out.print("[B]");
                else System.out.print("///");
            }
            System.out.println(" ");
        }

    }
}
