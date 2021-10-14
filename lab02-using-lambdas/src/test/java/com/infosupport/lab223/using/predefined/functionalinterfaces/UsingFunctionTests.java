package com.infosupport.lab223.using.predefined.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class UsingFunctionTests {

    public class UsingFunction {
        public List<Integer> map(List<String> list, Function<String, Integer> f) {
            List<Integer> result = new ArrayList<>();
            // TODO: transform each element in the list using f and put the transformed element in result

            return result;
        }
    }

    private UsingFunction uf = new UsingFunction();

    @Test
    public void mapStringsToIntAccordingToTheirLength() {
        List<String> list = Arrays.asList("lambdas", "in", "action");
        List<Integer> lengths = uf.map(list, s -> s.length());

        assertThat(lengths.size()).isEqualTo(list.size());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).length()).isEqualTo(lengths.get(i));
        }
    }
}
