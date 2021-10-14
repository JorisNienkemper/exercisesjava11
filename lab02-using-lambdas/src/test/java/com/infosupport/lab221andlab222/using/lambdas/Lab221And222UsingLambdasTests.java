package com.infosupport.lab221andlab222.using.lambdas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Lab221And222UsingLambdasTests {
    private static final Logger logger= LoggerFactory.getLogger(Lab221And222UsingLambdasTests.class);
    public static final int VALUE_UPPERCASE_A_IN_ASCII_SET = 65;
    public static final int VALUE_LOWERCASE_A_IN_ASCII_SET = 97;
    public static final int NUMBER_OF_LETTERS_ALPHABET = 26;

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }
    
    @Test
    @DisplayName("We're going to use lambda expressions for an 'execute around' pattern.\n" +
                 "We want to create a method that takes the processing as a lambda.\n" +
                 "To do that we need a functional interface: BufferedReaderProcessor see above.\n" +
                 "Implement the actual execute around pattern in processFile(BufferedReaderProcessor processor) see below\n")
    void process1TheFirstLine() throws IOException{
        var tekst = processFile(bufferedReader -> bufferedReader.readLine(), "testtekst.txt");
        System.out.println(tekst);
    }

    //signature has one extra parameter to easily change between files
    public String processFile(BufferedReaderProcessor processor, String fileName)
            throws IOException {
        var fileSeparator = File.separator;
        String projectRoot = new File("").getAbsolutePath();
        //text file is in data folder that resides in the root folder project
        String textFile = projectRoot + fileSeparator + "data" + fileSeparator + fileName;
        logger.info("create path to file: {}",textFile);
        // TODO Implement the execute around here.

        return null;
    }

    @Test
    @DisplayName("processFile should return the last line\n")
    void returnLastLine() throws IOException {
        //Arrange
        BufferedReaderProcessor buf= bufferedReader -> {
            // TODO Implement the execute around here.
            return null;
        };

        var lastLine = processFile(buf, "testtekst.txt");
        logger.info("Last line is: {}",lastLine);
    }

    @Test
    @DisplayName("Return the longest line\n")
    void returnTheLongestLine() throws IOException {
        //Arrange
        BufferedReaderProcessor brp=bufferedReader -> {
            // TODO Implement the execute around here.
            return null;
        };
        //Act
        var longestLine = processFile(brp, "testtekst.txt");
        logger.info("The longest line: {}",longestLine);
    }
    
    @Test
    @DisplayName("Return the longest word\n")
    void returnTheLongestWord() throws IOException {
        //Arrange
        BufferedReaderProcessor brp=bufferedReader -> {
            // TODO Implement the execute around here.
            return null;
        };
        //Act
        var longestWord = processFile(brp, "testtekst.txt");
        logger.info("Longest word is: {}",longestWord);
    }
}
