package com.infosupport.lab223.using.predefined.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class UsingSupplierTests {

    public class UsingSupplier {
        public  List<String> concat(List<String> list, Supplier<String> s) {
            List<String> result = new ArrayList<>();
            // TODO: concat each element from list with the result of s and put the new element in result

            return result;
        }
    }

    private UsingSupplier us = new UsingSupplier();

    @Test
    public void concatStringsWithExclamationMark() {
        final String excl = "!";
        List<String> words = List.of("lambdas", "in", "action");
        List<String> mutatedWords = us.concat(words, () -> excl);

        assertThat(mutatedWords.size()).isEqualTo(words.size());
        assertThat(mutatedWords).allMatch(word -> word.endsWith("!"));
    }
}
