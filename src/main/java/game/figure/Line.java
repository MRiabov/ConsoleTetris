package game.figure;

public class Line extends Shape {
    private static final boolean[][] figure=new boolean[][]
                    {{true},
                    {true},
                    {true},
                    {true}};

    public Line(int fieldHeight,int fieldLength){
        super(fieldHeight,fieldLength);
        int randomX=(int)(Math.random()*(fieldLength));
        for (int h = 0; h < 4; h++) {
            System.arraycopy(figure[h], 0, currentFigure[fieldHeight + h], randomX, 1);
        }


    }
}
