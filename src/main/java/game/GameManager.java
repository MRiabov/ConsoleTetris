package game;

import java.util.concurrent.TimeUnit;

public class GameManager {


public static void main(String[] args) throws InterruptedException {
    Field field = new Field(6,9);
        while(!field.fieldProcessor()){
            Printer.printOut(field);
            TimeUnit.MILLISECONDS.sleep(100);
        }
}
//todo писать классы так, что бы если другой захотел их вызвать, он не задумывался, как.
    //todo
    // DONE make it work,   yay
    // multithreading https://www.youtube.com/watch?v=J09TLPgwd0Y
    // input,
    // validate print,
    // validate deleteLayers,
    // rotation,
}