package game.figure;

public abstract class Shape {

    protected final boolean[][] currentFigure;
    private final boolean[][] nextFigure;


    public Shape(int fieldHeight, int fieldLength) {

        this.currentFigure = new boolean[fieldHeight][fieldLength];
        this.nextFigure = new boolean[fieldHeight][fieldLength];
    }

    //added getCurrentFigure
    public void moveShapeDown(int fieldLength){
            System.arraycopy(currentFigure, 0, nextFigure, 1,fieldLength-1);
            System.arraycopy(nextFigure,0,currentFigure,0,fieldLength-1);
    }

    public boolean getCurrentFigure(int height,int length) {
        return currentFigure[height][length];
    }
}