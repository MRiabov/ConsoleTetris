package game.figure;

public class Box extends Shape {

    private static final boolean[][] figure=new boolean[][]
                    {{true, true},
                    {true,true}};
    
    public Box(int fieldHeight, int fieldLength){
        super(fieldHeight,fieldLength);
        int randomX=(int)(Math.random()*(fieldLength-1));
        for (int h = 0; h < 2; h++) {
            System.arraycopy(figure[h], 0, currentFigure[h], randomX, 2);
        }
    }
}
