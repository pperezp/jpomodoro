package cl.prezdev.view.listeners;

import cl.prezdev.model.pomodoro.PomodoroEvent;
import cl.prezdev.model.util.Util;
import cl.prezdev.service.PomodoroService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelPomodoroMouseListener extends MouseAdapter {

    private PomodoroEvent pomodoroEvent;

    public LabelPomodoroMouseListener(PomodoroEvent pomodoroEvent) {
        this.pomodoroEvent = pomodoroEvent;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(Util.isDoubleClick(mouseEvent)){
            PomodoroService.tryToCreatePomodoro(pomodoroEvent);
        }
    }
}
