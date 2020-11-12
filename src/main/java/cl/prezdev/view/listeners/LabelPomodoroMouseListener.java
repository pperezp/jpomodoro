package cl.prezdev.view.listeners;

import cl.prezdev.model.pomodoro.AbstractPomodoro;
import cl.prezdev.model.pomodoro.Pomodoro;
import cl.prezdev.model.pomodoro.PomodoroEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelPomodoroMouseListener extends MouseAdapter {

    private PomodoroEvent pomodoroEvent;
    private AbstractPomodoro pomodoro;

    public LabelPomodoroMouseListener(PomodoroEvent pomodoroEvent) {
        this.pomodoroEvent = pomodoroEvent;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            pomodoro = new Pomodoro(pomodoroEvent);
            pomodoro.start();
        }
    }
}
