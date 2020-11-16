package cl.prezdev.model.config.theme.themes;

import cl.prezdev.model.config.theme.ThemeName;

import java.awt.*;

public interface Theme {
    ThemeName getThemeName();

    Color getNormalPomodoroForeground();

    Color getBreakPomodoroForeground();

    Color getPanelBackground();
}
