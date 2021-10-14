package com.infosupport.lab01.behavior.parameterization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BehaviorParamaterizationTests {

    private static Logger logger = LoggerFactory.getLogger(BehaviorParamaterizationTests.class);
    List<Apple> stock = List.of(new Apple("green", 150),
            new Apple("red", 250),
            new Apple("green", 350),
            new Apple("red", 200),
            new Apple("green", 100)
    );

    @Test
    @DisplayName("Start from a pre Java 8 solution to print apples:\n")
    void lab1_1ShouldPrintApples(){
        // TODO Add your implementation here.
        // Use the ApplePrinter and AppleService, see below

    }
    //Given:
    public interface AppleConsumer {
        void accept(Apple apple);
    }
    public class ApplePrinter implements AppleConsumer {
        @Override
        public void accept(Apple apple) {
            // TODO Add your implementation here.
        }
    }
    public class AppleService {
        void consumeApples(List<Apple> apples, AppleConsumer appleConsumer) {
            // TODO Add your implementation here.
        }
    }
    
    @Test
    @DisplayName("Now move the logic of the ApplePrinter into an anonymous class in shouldPrintApples.\n")
    void lab1_2ShouldPrintApples(){
        // TODO Add your implementation here.
    }
    
    @Test
    @DisplayName("Convert AppleConsumer into a Consumer<T>\n" +
                 "Create a new method in the AppleService that takes advantage of this new interface\n" +
                 "Rename the AppleService in ThingService\n")
    void lab1_3ShouldPrintApples(){
        //Arrange
        new ThingService<Apple>().consumeThings(stock, new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                // TODO Add your implementation here.
            }
        });

    }
    public interface Consumer<T>{
        void accept(T t);
    }

    public class ThingService<T>{
         public void consumeThings(List<T> things, Consumer<T> consumer) {
             // TODO Add your implementation here.
        }
    }
    @Test
    @DisplayName("Implement another AppleConsumer which sets the weights of all apples to 0.\n" +
                 "Test this one using assertThat(s).\n")
    void lab1_4ShouldSetAppleWeightsToZero(){
        //Arrange
        var service = new ThingService<Apple>();
        Consumer<Apple> consumer = null;

        // TODO Add your implementation here.

        service.consumeThings(stock, consumer);
        
        //Assert
        Consumer<Apple> weightIsZeroAsserter = new Consumer<Apple>() {
            private int testedApples = 1;
            @Override
            public void accept(Apple apple) {
                logger.info("Testing apple number: {} has weight:{} ",testedApples++,apple.getWeight());
                assertThat(apple.getWeight()).isEqualTo(0);
            }
        };

        service.consumeThings(stock, weightIsZeroAsserter);

    }
}
