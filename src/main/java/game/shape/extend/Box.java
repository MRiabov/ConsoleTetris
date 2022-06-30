package game.shape.extend;

import game.shape.Shape;

//
public class Box extends Shape {
    private static final String color = "\u001B[43m";//yellow
    private static final boolean[][] figure = new boolean[][]
            {{true, true},
                    {true, true}};
    private static final String[][] colors = new String[][]
            {{color, color},
                    {color, color}};

    public Box(int fieldHeight, int fieldLength) {
        super(fieldHeight, fieldLength);
        int randomX = (int) (Math.random() * (fieldLength - 1));
        for (int h = 0; h < 2; h++) {
            System.arraycopy(figure[h], 0, currentFigure[h + 1], randomX, 2);
            System.arraycopy(colors[h], 0, currentColors[h + 1], randomX, 2);
        }
    }
}
