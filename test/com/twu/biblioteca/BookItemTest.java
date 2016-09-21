package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BookItemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private BookItem testBookOne;
    private BookItem testBookTwo;

    private void createTestBookTwo() {
        testBookTwo = new BookItem("Gormengast", "Mervyn Peake", "1950");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @Before
    public void createTestBookOne() {
        testBookOne = new BookItem("Dune", "Frank Herbert", "1965");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void printsFullBookDetails() throws Exception {

        createTestBookTwo();

        String result = "Title: Dune\n" +
                        "Author: Frank Herbert\n" +
                        "Year: 1965\n" +
                        "Title: Gormengast\n" +
                        "Author: Mervyn Peake\n" +
                        "Year: 1950\n";

        testBookOne.printDetails();
        testBookTwo.printDetails();
        assertEquals(result, outContent.toString());

    }

    @Test
    public void returnsTitleAsAString() throws Exception {

        assertEquals("Dune", (testBookOne.returnName()));
    }

    @Test
    public void bookCanBeCheckedOutAndMarkedAsNotInStock() throws Exception {

        testBookOne.beCheckedOut();

        assertEquals(false, (testBookOne.isInStock()));
    }

    @Test
    public void bookCanBeReturnedAndMarkedInStock() throws Exception {

        testBookOne.beReturned();

        assertEquals(true, (testBookOne.isInStock()));
    }


}
