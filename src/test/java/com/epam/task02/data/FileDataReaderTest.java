package com.epam.task02.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private static final String PATH_TO_INPUT_FILE = "./src/test/resources/test_input.txt";
    private FileDataReader reader = new FileDataReader();

    @Test
    public void testReadDataShouldSucceedWithProvidedPath() throws DataException {
        List<String> actualData = reader.readData(PATH_TO_INPUT_FILE);
        List<String> dataFromInputFile = Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Praesent pharetra nisi dui, in consectetur nisi placerat nec.",
                "Nam vulputate, mi nec luctus aliquet, justo massa imperdiet nulla,",
                "non vulputate justo sapien ac ex.");
        Assert.assertEquals(dataFromInputFile, actualData);
    }

    @Test
    public void testReadDataShouldFailIfFileDoesNotEndWithSymbolOfNewLine() throws DataException {
        List<String> actualData = reader.readData(PATH_TO_INPUT_FILE);
        List<String> dataFromInputFile = Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Praesent pharetra nisi dui, in consectetur nisi placerat nec.",
                "Nam vulputate, mi nec luctus aliquet, justo massa imperdiet nulla,",
                "non vulputate justo sapien ac ex.",
                "");
        Assert.assertEquals(dataFromInputFile, actualData);
    }
}
