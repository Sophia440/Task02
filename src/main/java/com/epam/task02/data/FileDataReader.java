package com.epam.task02.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    public List<String> readData(String filename) throws DataException {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), "windows-1251"))) {
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return lines;

    }

}
