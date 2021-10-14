package com.infosupport.lab231andlab232andlab233.using.methodreferences;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Lab231ChangeLambdaInMethodReferenceTests {

    @Test
    @DisplayName("What are equivalent method references for the following lambda expressions (try it out in code)?\n")
    void replaceLambdaWithMethodReference(){
        // TODO What is the equivalent method references for
        ToIntFunction<String> stringToInt =
                (String s) -> Integer.parseInt(s);


        // TODO What is the equivalent method references for
        BiPredicate<List<String>, String> contains =
                (list, element) -> list.contains(element);

        // TODO What is the equivalent method references for
        Predicate<String> startsWithNumber =
                (String string) -> this.startsWithNumber(string);

    }

    private boolean startsWithNumber(String string) {
         var chars = string.toCharArray();
         return Character.isDigit( chars[0]);
    }
}
