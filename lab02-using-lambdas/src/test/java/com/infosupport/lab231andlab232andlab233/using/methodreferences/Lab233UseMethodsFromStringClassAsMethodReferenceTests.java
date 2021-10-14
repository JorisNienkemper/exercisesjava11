package com.infosupport.lab231andlab232andlab233.using.methodreferences;

import org.assertj.core.util.TriFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.DirectoryStream;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lab233UseMethodsFromStringClassAsMethodReferenceTests {
    
    @Test
    @DisplayName("Assign method references of some methods of the System class to variables and find out their types.\n" +
                 "A table of general functional interfaces is shown on the slides.\n" +
                 "The same, but now for the String class.\n")
    void useStringMethodsAsMethodReference(){

        Function<String, Integer> stringIntegerFunction = String::length;

        // TODO Add you own suggestions
    }
}
