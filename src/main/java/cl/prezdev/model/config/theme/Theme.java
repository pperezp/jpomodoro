package cl.prezdev.model.config.theme;

import java.awt.*;

public interface Theme {
    ThemeName getThemeName();

    Color getNormalPomodoroForeground();

    Color getBreakPomodoroForeground();

    Color getPanelBackground();
}
