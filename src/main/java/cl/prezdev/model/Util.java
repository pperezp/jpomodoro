package cl.prezdev.model;

public class Util {
    public static String format(int number) {
        return (number < 10 ? "0"+number : String.valueOf(number));
    }
}
