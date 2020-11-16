package cl.prezdev.model.pomodoro;

import cl.prezdev.model.config.Config;
import lombok.SneakyThrows;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractPomodoro implements Pomodoro{

    private static final Logger LOGGER = Logger.getLogger(AbstractPomodoro.class.toString());

    protected int minutes;
    protected String activity;
    protected List<PomodoroEvent> pomodoroEvents;
    protected Thread thread;

    public AbstractPomodoro(int minutes, String activity, PomodoroEvent pomodoroEvent){
        this(minutes, activity);
        this.addPomodoroEvent(pomodoroEvent);
    }

    public AbstractPomodoro(int minutes, String activity){
        this.minutes = minutes;
        this.activity = activity;
        this.pomodoroEvents = new ArrayList<>();
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
                Thread.sleep(Config.Share.PAUSE);
            }
        }

        invokePomodoroFinishedEvents(this);
        LOGGER.log(Level.INFO, "Thread finished!");
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

    @Override
    public void addPomodoroEvent(PomodoroEvent pomodoroEvent) {
        this.pomodoroEvents.add(pomodoroEvent);
    }

    @Override
    public void start() {
        invokePreStartPomodoro();
        thread = new Thread(this);
        thread.start();

        LOGGER.log(Level.INFO, "Thread started! : {0}", info());
    }

    private void invokePreStartPomodoro(){
        for(PomodoroEvent pomodoroEvent : pomodoroEvents){
            pomodoroEvent.preStartPomodoro(this);
        }
    }

    @Override
    public void pause() {
        throw new NotImplementedException();
    }

    @Override
    public void resume() {
        throw new NotImplementedException();
    }

    @Override
    public void stop() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAlive() {
        if(thread == null){
            return false;
        }

        return thread.isAlive();
    }

    @Override
    public String info() {
        return "Minutes left: " + minutes + " - Activity: " + this.activity;
    }
}
