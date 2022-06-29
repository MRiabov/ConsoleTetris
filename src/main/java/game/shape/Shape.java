package game.shape;

public abstract class Shape {

    protected final boolean[][] currentFigure;
    final boolean[][] nextFigure;
    private static final String black = "\u001B[30m";//black
    protected final String[][] currentColors;
    final String[][] nextColors;

    public Shape(int fieldHeight, int fieldLength) {
        this.currentFigure = new boolean[fieldHeight][fieldLength];
        this.nextFigure = new boolean[fieldHeight][fieldLength];
        this.nextColors = new String[fieldHeight][fieldLength];
        this.currentColors = new String[fieldHeight][fieldLength];
    }

    public void moveShapeDown(int fieldHeight) {
        System.arraycopy(currentFigure, 0, nextFigure, 1, fieldHeight - 1);
        System.arraycopy(nextFigure, 0, currentFigure, 0, fieldHeight);
        System.arraycopy(currentColors, 0, nextColors, 1, fieldHeight - 1);
        System.arraycopy(nextColors, 0, currentColors, 0, fieldHeight);
    }

    public void moveShapeRight(int fieldHeight, int fieldLength){
        for (int h = 0; h < fieldHeight; h++) {
            System.arraycopy(currentFigure[h], 0, nextFigure[h], 1, fieldLength - 1);
            nextFigure[h][0] = false;
            System.arraycopy(currentColors[h], 0, nextColors[h], 1, fieldLength - 1);
            nextColors[h][0] = black;
        }
        System.arraycopy(nextFigure, 0, currentFigure, 0, fieldLength);
        System.arraycopy(nextColors, 0, currentColors, 0, fieldLength);
    }

    public void moveShapeLeft(int fieldHeight, int fieldLength){
        for (int h = 0; h < fieldHeight; h++) {
            System.arraycopy(currentFigure[h], 1, nextFigure[h], 0, fieldLength - 1);
            nextFigure[h][fieldLength - 1] = false;
            System.arraycopy(currentColors[h], 1, nextColors[h], 0, fieldLength - 1);
            nextColors[h][fieldLength - 1] = black;
        }
        System.arraycopy(nextFigure, 0, currentFigure, 0, fieldHeight);
        System.arraycopy(nextColors, 0, currentColors, 0, fieldHeight);
    }

    public boolean getCurrentFigure(int height, int length) {
        return currentFigure[height][length];
    }

    public String getCurrentColors(int height, int length) {
        return currentColors[height][length];
    }
}