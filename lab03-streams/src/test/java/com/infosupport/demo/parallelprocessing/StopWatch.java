package com.infosupport.demo.parallelprocessing;

public class StopWatch {

    long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        endTime=System.nanoTime();
    }

    public long getElapsedTimeInMs() {
       return (endTime-startTime)/1_000_000;
    }
}
