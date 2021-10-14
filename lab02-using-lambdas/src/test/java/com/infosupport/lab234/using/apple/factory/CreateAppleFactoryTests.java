package com.infosupport.lab234.using.apple.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAppleFactoryTests {

    @Test
    @DisplayName(" Create an appleFactory method:\n" +
                 "List<Apple> appleFactory(String[] colors, int[] weights,\n" +
                 "                         BiFunction<String, Integer, Apple> creator)\n" +
                 " takes two arrays with sizes m and n respectively, and a function to create an apple\n" +
                 " returns a List<Apple> with size m*n\n")
    void useConstructorReferenceOfApple(){
        var apples = appleFactory(new String[]{"green", "red", "yellow"}, new int[]{100, 200, 300, 400}, Apple::new);
        assertThat(apples.size()).isEqualTo(12);
    }

    public List<Apple> appleFactory(String[] colors, int[] weights, BiFunction<String, Integer, Apple> creator){
        List<Apple> result = new ArrayList<>();
        // TODO Implement this appleFactory method:
        return  result;
    }

    public class Apple{
        private String colour;
        private int weight;

        public Apple(String colour, int weight) {
            this.colour = colour;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "colour='" + colour + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}
