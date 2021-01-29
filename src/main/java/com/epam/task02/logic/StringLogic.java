package com.epam.task02.logic;

import java.util.ArrayList;
import java.util.List;

public class StringLogic {

    private static final String STRING_SPACE = " ";
    private static final String ALL_LETTERS = "[a-zA-Z]";
    private static final String ALL_CONSONANTS = "^[b-z&&[^eiou]]+$";
    private static final String PO_LOWERCASE = "po";
    private static final String PO_UPPERCASE = "Po";
    private static final String PA_LOWERCASE = "pa";
    private static final String PA_UPPERCASE = "Pa";

    public List<String> replaceLetterAtGivenPosition(List<String> sourceList, int positionToReplace,
                                                     char symbolToReplaceWith) {
        List<String> modifiedList = new ArrayList<>();
        int correctedPositionToReplace = positionToReplace - 1;
        for (String line : sourceList) {
            String[] words = line.split(STRING_SPACE);
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() >= positionToReplace) {
                    String firstPartOfNewWord = words[i].substring(0, correctedPositionToReplace);
                    String secondPartOfNewWord = words[i].substring(positionToReplace);
                    StringBuilder newWord = new StringBuilder();
                    newWord.append(firstPartOfNewWord);
                    newWord.append(symbolToReplaceWith);
                    newWord.append(secondPartOfNewWord);
                    words[i] = newWord.toString();
                }
            }
            StringBuilder newLine = new StringBuilder();
            for (String word : words) {
                newLine.append(word);
                newLine.append(STRING_SPACE);
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

    public List<String> replaceLetterAWithOIfItsAfterP(List<String> sourceList) {
        List<String> modifiedList = new ArrayList<>();
        for (String line : sourceList) {
            String[] words = line.split(STRING_SPACE);
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains(PA_UPPERCASE)) {
                    words[i] = words[i].replace(PA_UPPERCASE, PO_UPPERCASE);
                }
                if (words[i].contains(PA_LOWERCASE)) {
                    words[i] = words[i].replace(PA_LOWERCASE, PO_LOWERCASE);
                }
            }
            StringBuilder newLine = new StringBuilder();
            for (String word : words) {
                newLine.append(word);
                newLine.append(STRING_SPACE);
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

    public List<String> replaceWordsOfGivenLengthWithGivenSubstring(List<String> sourceList, int lengthOfWord,
                                                                    String substringToReplace) {
        List<String> modifiedList = new ArrayList<>();
        for (String line : sourceList) {
            String[] words = line.split(STRING_SPACE);
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == lengthOfWord) {
                    words[i] = substringToReplace;
                }
            }
            StringBuilder newLine = new StringBuilder();
            for (String word : words) {
                newLine.append(word);
                newLine.append(STRING_SPACE);
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

    public List<String> deleteAllNonLetters(List<String> sourceList) {
        List<String> modifiedList = new ArrayList<>();
        for (String line : sourceList) {
            char[] arrayOfSymbols = line.toCharArray();
            StringBuilder newLine = new StringBuilder();
            for (char currentSymbol : arrayOfSymbols) {
                String currentSymbolAsString = String.valueOf(currentSymbol);
                if (currentSymbolAsString.matches(ALL_LETTERS) || currentSymbolAsString.matches(STRING_SPACE)) {
                    newLine.append(currentSymbol);
                }
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

    public List<String> insertSpacesBetweenSequencesOfLetters(List<String> sourceList) {
        List<String> modifiedList = new ArrayList<>();
        for (String line : sourceList) {
            char[] arrayOfSymbols = line.toCharArray();
            StringBuilder newLine = new StringBuilder();
            for (char currentSymbol : arrayOfSymbols) {
                String currentSymbolAsString = String.valueOf(currentSymbol);
                newLine.append(currentSymbolAsString);
                if (!currentSymbolAsString.equals(STRING_SPACE)) {
                    newLine.append(STRING_SPACE);
                }
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

    public List<String> deleteAllWordsOfGivenLengthThatStartWithConsonant(List<String> sourceList,
                                                                          int lengthOfWord) {
        List<String> modifiedList = new ArrayList<>();
        for (String line : sourceList) {
            String[] words = line.split(STRING_SPACE);
            StringBuilder newLine = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == lengthOfWord) {
                    String firstLetter = words[i].substring(0, 1);
                    if (!firstLetter.matches(ALL_CONSONANTS)) {
                        newLine.append(words[i]);
                        newLine.append(STRING_SPACE);
                    }
                } else {
                    newLine.append(words[i]);
                    newLine.append(STRING_SPACE);
                }
            }
            modifiedList.add(newLine.toString());
        }
        return modifiedList;
    }

}
