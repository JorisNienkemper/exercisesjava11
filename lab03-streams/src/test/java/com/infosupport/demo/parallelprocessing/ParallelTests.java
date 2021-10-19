package com.infosupport.demo.parallelprocessing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelTests {

    public static final int UPPERBOUND = 10_000_000;

    @Test
    @DisplayName(
            "Let's create an old fashioned benchmark with pre java 8 code" +
            "Average time taken = 3 ms"
    )
    void forLoopImplementation(){
        Experiment experiment = ()->{
             long sum = 0;
             for(long i =1L;i<=UPPERBOUND;i= i+1L){
                sum+=i;
            }
             return sum;
        };
        measureAverageTimeSummation(experiment);
    }



    @FunctionalInterface
    interface Experiment{
        long doMeasurement();
    }
    @Test
    @DisplayName(
            "Start with a problem which is big enough to actually justify the usage of a parallel stream" +
            "Average time taken = 95ms"
    )
    void reduceOption(){

        Experiment experiment = () ->{
            final Stream<Long> longStream = Stream.iterate(1L, i -> i + 1L)
                    .limit(UPPERBOUND);

            final Long sum = longStream.reduce(0L, (i, j) -> i + j, (i, j) -> i + j);

            return sum;
        };

        measureAverageTimeSummation(experiment);

    }

    @Test
    @DisplayName(
            "Use parallelstream to improve the average time"+
                    "Average time= 116"

    )
    void parallelSummationWithTheWrapperType(){

        Experiment experiment = () ->{
            final Stream<Long> longStream = Stream.iterate(1L, i -> i + 1L)
                    .parallel()
                    .limit(UPPERBOUND);

            final Long sum = longStream.reduce(0L, (i, j) -> i + j, (i, j) -> i + j);

            return sum;
        };
        measureAverageTimeSummation(experiment);
    }

    @Test
    @DisplayName(
            "Use parallelstream to improve the average time"+
                    "Average time= 124"

    )
    void parallelSummationWithTheBetterSuitedPrimitiveStream(){

        Experiment experiment = () ->{
            final LongStream longStream = LongStream.iterate(1L, i -> i + 1L)
                    .parallel()
                    .limit(UPPERBOUND);

            final long sum = longStream.reduce(0L,(i,j) -> i + j );

            return sum;
        };
        measureAverageTimeSummation(experiment);
    }


    @Test
    @DisplayName(
            "Use parallelstream to improve the average time"+
                    "Average time= 1"

    )
    void parallelSummationWithMethodThatIsMoreEasilyParallizable(){

        Experiment experiment = () ->{
            final LongStream longStream = LongStream.rangeClosed(1,UPPERBOUND).parallel();


            final long sum = longStream.reduce(0L,(i,j) -> i + j );

            return sum;
        };
        measureAverageTimeSummation(experiment);
    }

    private void measureAverageTimeSummation(Experiment experiment) {
        long fastestTime=Integer.MAX_VALUE;
        long sum = 0;
        for (int run=0;run<10;run++) {
            final StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            sum = experiment.doMeasurement();


            stopWatch.end();
            final long elapsedTimeInMs = stopWatch.getElapsedTimeInMs();
//            System.out.println(elapsedTimeInMs);
            if(elapsedTimeInMs<fastestTime){
                fastestTime=elapsedTimeInMs;
            }

        }
        System.out.println(sum);
        System.out.println("Fastest time = " +fastestTime);
    }
}
