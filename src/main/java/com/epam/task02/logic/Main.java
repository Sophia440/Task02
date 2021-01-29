package com.epam.task02.logic;

import com.epam.task02.data.DataException;
import com.epam.task02.data.FileDataReader;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final String VALID_PATH_TO_INPUT_FILE = "./src/java/resources/main_input.txt";
    private static final String INVALID_PATH_TO_INPUT_FILE = "./java/resources/main_input.txt";

    public static void main(String[] args) {

        try {
            printFileContents(VALID_PATH_TO_INPUT_FILE);
        } catch (DataException e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            printFileContents(INVALID_PATH_TO_INPUT_FILE);
        } catch (DataException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    private static void printFileContents(String filename) throws DataException {
        LOGGER.info("Program started");
        FileDataReader reader = new FileDataReader();
        List<String> data = reader.readData(filename);
        for (String currentLine : data) {
            System.out.println(currentLine);
        }
        LOGGER.info("Program finished");
    }

}
