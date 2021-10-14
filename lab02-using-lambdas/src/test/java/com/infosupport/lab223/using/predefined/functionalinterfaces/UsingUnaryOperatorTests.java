package com.infosupport.lab223.using.predefined.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class UsingUnaryOperatorTests {

    public class UsingUnaryOperator {

        public <T> List<T> map(List<T> list, UnaryOperator<T> f) {
            List<T> result = new ArrayList<>();
            //TODO: transform each element in the list using f and put the transformed element in result

            return result;
        }
    }

    private UsingUnaryOperator uuOp = new UsingUnaryOperator();

    @Test
    public void negateInts() {
        UnaryOperator<Integer> negate = x -> -1 * x;
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        List<Integer> output = uuOp.map(input, negate);

        output.forEach(System.out::println);

        assertThat(output.size()). isEqualTo(input.size());
        for (int i = 0; i < output.size(); i++) {
            assertThat(output.get(i)). isEqualTo(-1 * input.get(i) );
        }
    }

    @Test
    public void manipulateStrings() {
        final String ext = ".txt";
        UnaryOperator<String> addTxt = s -> s + ext;
        List<String> input = List.of("1", "2", "3", "4", "5");

        List<String> output = uuOp.map(input, addTxt);

        output.forEach(System.out::println);

        assertThat(output.size()).isEqualTo(input.size());
        assertThat(output).allMatch(s -> s.contains(ext));
    }
}
