package cl.prezdev.model.pomodoro;

public interface Pomodoro extends Runnable{
    void addPomodoroEvent(PomodoroEvent pomodoroEvent);

    void start();

    void pause();

    void resume();

    void stop();

    boolean isAlive();

    String info();
}
