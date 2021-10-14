package com.infosupport.lab223.using.predefined.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class UsingPredicateTests {

    public class UsingPredicate {

        public List<String> filter(List<String> list, Predicate<String> p) {
            List<String> result = new ArrayList<>();
            // TODO: copy the elements from list which meet p to result
            return result;
        }
    }

    private UsingPredicate up = new UsingPredicate();

    @Test
    public void removeEmptyStringFromList() {
        List<String> listOfStrings = Arrays.asList("a", "ab", "", "abc");
        List<String> nonEmpt = up.filter(listOfStrings, s -> !s.isEmpty());

        assertThat(nonEmpt.size()).isEqualTo(3);
    }
}
