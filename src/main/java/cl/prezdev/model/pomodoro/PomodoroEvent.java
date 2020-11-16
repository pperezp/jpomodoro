package cl.prezdev.model.pomodoro;

public interface PomodoroEvent {
    void preStartPomodoro(AbstractPomodoro abstractPomodoro);

    void printPomodoroTimer(int minute, int second);

    void pomodoroFinished(AbstractPomodoro pomodoroImpl);
}
