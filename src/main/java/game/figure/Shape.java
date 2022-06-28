package game.figure;


public abstract class Shape {

    protected final boolean[][] currentFigure;
    final boolean[][] nextFigure;


    public Shape(int fieldHeight, int fieldLength) {
        this.currentFigure = new boolean[fieldHeight][fieldLength];
        this.nextFigure = new boolean[fieldHeight][fieldLength];
    }

    public void moveShapeDown(int fieldHeight){
            System.arraycopy(currentFigure, 0, nextFigure, 1,fieldHeight-1);
            System.arraycopy(nextFigure,0,currentFigure,0,fieldHeight);
    }

    public void moveShapeRight(int fieldHeight, int fieldLength){
        for (int h = 0; h < fieldHeight; h++) {
            System.arraycopy(currentFigure[h],0,nextFigure[h],1,fieldLength-1);
            nextFigure[h][0]=false;
            System.arraycopy(nextFigure[h],0,currentFigure[h],0,fieldLength);
        }
    }

    public void moveShapeLeft(int fieldHeight, int fieldLength){
        for (int h = 0; h < fieldHeight; h++) {
            System.arraycopy(currentFigure[h],1,nextFigure[h],0,fieldLength-1);
            nextFigure[h][fieldLength-1]=false;
        }
        System.arraycopy(nextFigure,0,currentFigure,0,fieldHeight);
    }

    public boolean getCurrentFigure(int height,int length) {
        return currentFigure[height][length];
    }
}