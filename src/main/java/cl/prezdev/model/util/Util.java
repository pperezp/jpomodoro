package cl.prezdev.model.util;

import java.awt.event.MouseEvent;

public class Util {
    public static String format(int number) {
        return (number < 10 ? "0"+number : String.valueOf(number));
    }

    public static boolean isDoubleClick(MouseEvent mouseEvent){
        return mouseEvent.getClickCount() == 2;
    }
}
