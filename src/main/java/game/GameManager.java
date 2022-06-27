package game;

public class GameManager {


public static void main(String[] args){
    Field field = new Field(6,9);
        while(!field.fieldProcessor()){
            Printer.printOut(field);
        }
}
//todo писать классы так, что бы если другой захотел их вызвать, он не задумывался, как.
    //todo
    // make it work,
    // multithreading https://www.youtube.com/watch?v=J09TLPgwd0Y
    // input,
    // validate print,
    // validate deleteLayers,
    // rotation,
}