package cl.prezdev.model.pomodoro;

import cl.prezdev.model.pomodoro.AbstractPomodoro;

public interface PomodoroEvent {
    void printPomodoroTimer(int minute, int second);

    void pomodoroFinished(AbstractPomodoro pomodoroImpl);
}
