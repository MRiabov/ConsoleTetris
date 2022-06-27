package game;

import game.figure.Shape;

public class Field {
    public final int fieldLength;
    public final int fieldHeight;
    public final boolean[][] colorsField;
    public final boolean[][] field;
    Shape shape;

    //todo +3 красных строки в код. Они послужат и для вывода и значительно упростят хендлинг ошибок. Зайдёшь за них - смерть

    public Field(int fieldLength, int fieldHeight) {
        this.fieldLength = fieldLength;
        this.fieldHeight = fieldHeight+3;
        field=new boolean[this.fieldHeight][fieldLength];
        colorsField=new boolean[this.fieldHeight][fieldLength];
    }

    public boolean fieldProcessor() {
        boolean loss;
        shape = ShapeFactory.randomShape(fieldLength,fieldHeight);
        while (!checkForCollision(shape)) shape.moveShapeDown(fieldHeight);
        loss=setShapeOnField(shape);
//        deleteFullLayers(lookForFullLayers());
        return loss;
    }

    private boolean checkForCollision(Shape shape) {
        int allCanMove = 0;
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (shape.getCurrentFigure(h,l) && (h == fieldHeight-1 || field[h + 1][l])) {
                    allCanMove++;
                    if (allCanMove == 4) return true;
                }
            }
        }
        return false;
    }

    private boolean[] lookForFullLayers(){
        boolean[] fullLayers = new boolean[fieldHeight];
        for (int h = 0; h < fieldHeight; h++) {
            int blocksOnLayer=0;
            for (int l = 0; l < fieldLength; l++) {
                if (field[h][l]) {
                    blocksOnLayer++;
                    if (blocksOnLayer==fieldLength) fullLayers[h]=true;
                }
            }
        }
        return fullLayers;
    }

    private void deleteFullLayers(boolean[] fullLayers){
        for (int h = fieldHeight; h > 0 ; h--) {
           if (fullLayers[h]){
               boolean[][] arrayBuffer = new boolean[h+1][fieldLength];
               if (fieldHeight - h >= 0) {
                   System.arraycopy(field[0], 0, arrayBuffer[0], 1, h - 1);
                   System.arraycopy(arrayBuffer[0], 0, field[0], 0, h);
               }
           }
        }
    }

    private boolean setShapeOnField(Shape shape){
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (lossCondition(h,l)) return true;
                if(shape.getCurrentFigure(h,l))
                    field[h][l]=shape.getCurrentFigure(h,l);
            }
        }
        return false;
    }

    private boolean lossCondition(int h,int l){
        return h < 3 && field[h][l];
    }
}
