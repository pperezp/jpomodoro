package cl.prezdev.model.pomodoro;

import cl.prezdev.model.config.Config;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class AbstractPomodoro implements Runnable{
    protected int minutes;
    protected String activity;
    protected List<PomodoroEvent> pomodoroEvents;
    protected Config config;

    public AbstractPomodoro(int minutes, String activity, PomodoroEvent pomodoroEvent){
        this(minutes, activity);
        this.addPomodoroEvent(pomodoroEvent);
    }

    public AbstractPomodoro(int minutes, String activity){
        this.minutes = minutes;
        this.activity = activity;
        this.pomodoroEvents = new ArrayList<>();
        this.config = new Config();
    }

    @Override
    @SneakyThrows
    public void run() {
        invokePrintPomodoroTimerEvents(this.minutes, 0);
        Thread.sleep(1000);
        this.minutes--;

        for(int minute = this.minutes; minute >= 0 ; minute--){
            for(int second = 59; second >= 0  ; second--){
                invokePrintPomodoroTimerEvents(minute, second);
                Thread.sleep(1000);
            }
        }

        invokePomodoroFinishedEvents(this);
    }

    private void invokePrintPomodoroTimerEvents(int minutes, int seconds) {
        for(PomodoroEvent pomodoroEvent : pomodoroEvents){
            pomodoroEvent.printPomodoroTimer(minutes, seconds);
        }
    }

    private void invokePomodoroFinishedEvents(AbstractPomodoro abstractPomodoro){
        for(PomodoroEvent pomodoroEvent : pomodoroEvents){
            pomodoroEvent.pomodoroFinished(abstractPomodoro);
        }
    }

    public void addPomodoroEvent(PomodoroEvent pomodoroEvent) {
        this.pomodoroEvents.add(pomodoroEvent);
    }

    public void start() {
        new Thread(this).start();
    }

    public void pause() {

    }

    public void resume() {

    }

    public void stop() {

    }
}
