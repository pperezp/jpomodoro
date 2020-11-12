package cl.prezdev.model.util;

public class Util {
    public static String format(int number) {
        return (number < 10 ? "0"+number : String.valueOf(number));
    }
}
