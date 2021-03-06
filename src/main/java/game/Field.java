package game;

import game.shape.Interactions;
import game.shape.Shape;

import java.util.concurrent.TimeUnit;

public class Field {
    public final int fieldLength;
    public final int fieldHeight;
    public final String[][] colorsField;
    public final boolean[][] field;
    Shape shape;
    public static boolean loss=false;
    static Interactions interactions=new Interactions();

    //todo +3 красных строки в код. Они послужат и для вывода и значительно упростят хендлинг ошибок. Зайдёшь за них - смерть

    public Field(int fieldLength, int fieldHeight) {
        this.fieldLength = fieldLength;
        this.fieldHeight = fieldHeight+3;
        field = new boolean[this.fieldHeight][fieldLength];
        colorsField = new String[this.fieldHeight][fieldLength];
        Thread userInputThread = new Thread(new Interactions());
        userInputThread.start();
    }
//
    public boolean fieldProcessor() throws InterruptedException {
        shape = ShapeFactory.randomShape(fieldLength,fieldHeight);
        while (canMoveDown(shape)) {
            shape.moveShapeDown(fieldHeight);
            playerActionStandby();
            Printer.printOut(fieldHeight, fieldLength, field, colorsField, shape);
            Interactions.button = "0";
        }
        loss=setShapeOnField(shape);
        deleteFullLayers(lookForFullLayers());
        return loss;
    }

    private boolean canMoveDown(Shape shape) {
        int allCanMove = 0;
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (shape.getCurrentFigure(h,l) && !(h == fieldHeight-1|| field[h + 1][l])) {
                    allCanMove++;
                    if (allCanMove == 4) return true;
                }
            }
        }
        return false;
    }

    private boolean[] lookForFullLayers() {
        boolean[] fullLayers = new boolean[fieldHeight];
        for (int h = 0; h < fieldHeight; h++) {
            int blocksOnLayer = 0;
            for (int l = 0; l < fieldLength; l++) {
                if (field[h][l]) {
                    blocksOnLayer++;
                    if (blocksOnLayer == fieldLength) fullLayers[h] = true;
                }
            }
        }
        return fullLayers;
    }

    private void deleteFullLayers(boolean[] fullLayers){
        for (int h = fieldHeight-1; h > 0 ; h--) {
           if (fullLayers[h]){
               System.arraycopy(field, 0, field, 1, h);
               System.arraycopy(colorsField, 0, colorsField, 1, h);
           }
       }
    }


    private boolean setShapeOnField(Shape shape){
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (lossCondition(h, l)) return true;
                if (shape.getCurrentFigure(h, l)) {
                    field[h][l] = shape.getCurrentFigure(h, l);
                    colorsField[h][l] = shape.getCurrentColors(h, l);
                }
            }
        }
        return false;
    }

    private void playerActionStandby() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(100);
            switch (Interactions.button){
                case "d" -> {if (canMoveRight()) shape.moveShapeRight(fieldHeight,fieldLength);
                    Interactions.button="0";}
                case "a" -> {if (canMoveLeft()) shape.moveShapeLeft(fieldHeight,fieldLength);
                    Interactions.button="0";}
            }
        }
    }

    private boolean lossCondition(int h,int l){
        return h < 3 && field[h][l];
    }

    private boolean canMoveLeft(){
        int allCanMove = 0;
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (shape.getCurrentFigure(h,l) && !(l==0 || field[h][l-1])) {
                    allCanMove++;
                    if (allCanMove == 4) return true;
                }
            }
        }
        return false;
    }

    private boolean canMoveRight(){
        int allCanMove = 0;
        for (int h = 0; h < fieldHeight; h++) {
            for (int l = 0; l < fieldLength; l++) {
                if (shape.getCurrentFigure(h,l) && !(l==fieldLength-1 || field[h][l+1])) {
                    allCanMove++;
                    if (allCanMove == 4) return true;
                }
            }
        }
        return false;
    }
}