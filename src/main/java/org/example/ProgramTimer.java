package org.example;

public class ProgramTimer {
    private long startTime;
    private long endTime;

    public void startTimer() {
        this.startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (this.endTime - this.startTime);
    }

    public void printElapsedTime() {
        if (endTime == 0) {
            stopTimer();
        }

        System.out.println("затраченное на поиск: " + getElapsedTime() + " мс");
    }
}
