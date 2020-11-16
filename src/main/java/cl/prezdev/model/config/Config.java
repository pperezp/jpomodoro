package cl.prezdev.model.config;

import cl.prezdev.model.config.theme.themes.Theme;
import cl.prezdev.model.config.theme.ThemeName;
import cl.prezdev.model.config.theme.ThemeService;

public class Config {

    public static Theme DEFAULT_THEME = ThemeService.getTheme(ThemeName.DARK);

    public Config(){
        throw new IllegalStateException("Utility class");
    }

    public static class Debug{
        public static boolean DEBUG = true;
    }

    public static class Share{
        public static int PAUSE = (Config.Debug.DEBUG ? 100 : 1000);
    }

    public static class Pomodoro{
        public static int minutes = (Config.Debug.DEBUG ? 1 : 25);
        public static String activity = "Activity";
    }

    public static class Break{
        public static int minutes = (Config.Debug.DEBUG ? 1 : 25);;
        public static String activity = "Break";
    }
}
