package cl.prezdev.listeners;

import cl.prezdev.model.Pomodoro;
import cl.prezdev.model.PomodoroPrintable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelPomodoroMouseListener extends MouseAdapter {

    private PomodoroPrintable pomodoroPrintable;
    private Pomodoro pomodoro;

    public LabelPomodoroMouseListener(PomodoroPrintable pomodoroPrintable) {
        this.pomodoroPrintable = pomodoroPrintable;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            pomodoro = new Pomodoro(pomodoroPrintable);
            pomodoro.start();
        }
    }
}
