package cl.prezdev.model.config.theme;

import java.util.ArrayList;
import java.util.List;

public class ThemeService {

    private static List<Theme> themes = new ArrayList();

    static{
        init();
    }

    private static void init() {
        themes.add(new DarkTheme());
        themes.add(new LightTheme());
    }

    public static Theme getTheme(ThemeName themeName) {
        for(Theme theme : themes){
            if(theme.getThemeName() == themeName){
                return theme;
            }
        }

        return null;
    }

}
