package com.infosupport.lab231andlab232andlab233.using.methodreferences;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Lab232UseMethodsFromSystemClassAsMethodReferenceTests {
    
    @Test
    @DisplayName("Assign method references of some methods of the System class to variables and find out their types.\n" +
                 "A table of general functional interfaces is shown on the slides.\n")
    void useSystemFunctionsAsMethodReferences(){

        Supplier<Long> currentTimeMillis = System::currentTimeMillis;

        // TODO Add you own suggestions
    }
}

