package com.epam.task02.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDataReader {

    private static final String STOPPING_POINT_OF_READING_TEXT = "";

    public List<String> readData() throws DataException {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(System.in))) {
            String currentLine = bufferedReader.readLine();
            while (!currentLine.equals(STOPPING_POINT_OF_READING_TEXT)) {
                lines.add(currentLine);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return lines;

    }

}
