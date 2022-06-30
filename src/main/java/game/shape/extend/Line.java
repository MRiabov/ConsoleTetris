package game.shape.extend;

import game.shape.Shape;

public class Line extends Shape {
    private static final boolean[][] figure=new boolean[][]
                    {{true},
                    {true},
                    {true},
                    {true}};
    public static final String color = "\u001B[34m";
    private static final String[][] colors = new String[][]
                    {{color},
                    {color},
                    {color},
                    {color}};

    public Line(int fieldHeight,int fieldLength){
        super(fieldHeight,fieldLength);
        int randomX=(int)(Math.random()*(fieldLength));
        for (int h = 0; h < 4; h++) {
            System.arraycopy(figure[h], 0, currentFigure[h+1], randomX, 1);
            System.arraycopy(colors[h], 0, currentColors[h + 1], randomX, 1);
        }


    }
}
