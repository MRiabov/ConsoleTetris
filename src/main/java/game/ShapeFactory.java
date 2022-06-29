package game;

import game.shape.Box;
import game.shape.Shape;

import java.util.Random;

public class ShapeFactory {
   private static final Random random =new Random();
   public enum ShapeType {
      BOX,
      //LINE;
//        SSHAPE,
//        ZSHAPE,
//        THSHAPE,
//        LSHAPE,
//        MIRROREDLSHAPE;
   }


   ShapeFactory() {
   }
   public static Shape randomShape(int fieldLength, int fieldHeight){
      return createShape(ShapeType.values()[random.nextInt(ShapeType.values().length)], fieldLength, fieldHeight);
   }
   private static Shape createShape(ShapeType type,int fieldLength, int fieldHeight) {
      switch (type) {
         case BOX -> {
            return new Box(fieldHeight,fieldLength);
         }
//         case LINE -> {
//            return new Line(game);
//         }
         default -> {
            return null;
         }
      }
   }
}