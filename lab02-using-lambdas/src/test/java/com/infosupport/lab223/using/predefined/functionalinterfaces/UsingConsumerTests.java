package com.infosupport.lab223.using.predefined.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class UsingConsumerTests {

    public class UsingConsumer {

        public void forEach(List<Integer> list, Consumer<Integer> c) {
            //TODO: iterate through the list and apply the consumer on each element
        }

    }

    private UsingConsumer uc = new UsingConsumer();

    private final List<Integer> list = List.of(1, 2, 3, 4, 5);

    @Test
    public void printIntegers() {

        uc.forEach(list, x -> System.out.println(x));
    }

    @Test
    public void addIntegers() {
        List<Integer> copy = new ArrayList<>();
        uc.forEach(list, e -> copy.add(e)); // void compatibility: we can pass in a Predicate (lambda returns boolean) as a Consumer! (Boolean) Statement expression is compatible with void.
        assertThat(copy.size()).isEqualTo(list.size());
    }
}
