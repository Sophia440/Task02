package com.epam.task02.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringLogicTest {

    private StringLogic stringLogic = new StringLogic();
    private static final List<String> TEST_DATA = Arrays.asList("Lorem ipasum dolor sit amet",
            "Paesent pharetra nisi dui",
            "Nam vulputate, mi nec luctus aliquet,",
            "non vulputate justo sapaien ac ex.",
            "i o u should stay the same");
    private static final List<String> SIMPLE_TEST_DATA = Arrays.asList("Lorem", "ipsum", "dolor sit", "amet");

    @Test
    public void replaceLetterAtGivenPositionShouldSucceedWithOneLetterWords() {
        List<String> expected = Arrays.asList("L_rem i_asum d_lor s_t a_et ",
                "P_esent p_aretra n_si d_i ",
                "N_m v_lputate, m_ n_c l_ctus a_iquet, ",
                "n_n v_lputate j_sto s_paien a_ e_. ",
                "i o u s_ould s_ay t_e s_me ");
        List<String> actual = stringLogic.replaceLetterAtGivenPosition(TEST_DATA, 2, '_');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceLetterAtGivenPositionShouldFailWithOneLetterWords() {
        List<String> expected = Arrays.asList("L_rem i_asum d_lor s_t a_et ",
                "P_esent p_aretra n_si d_i ",
                "N_m v_lputate, m_ n_c l_ctus a_iquet, ",
                "n_n v_lputate j_sto s_paien a_ e_. ",
                "_ _ _ s_ould s_ay t_e s_me ");
        List<String> actual = stringLogic.replaceLetterAtGivenPosition(TEST_DATA, 2, '_');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceLetterAWithOIfItsAfterPShouldSucceedWithUpperAndLowerCases() {
        List<String> expected = Arrays.asList("Lorem iposum dolor sit amet ",
                "Poesent pharetra nisi dui ",
                "Nam vulputate, mi nec luctus aliquet, ",
                "non vulputate justo sapoien ac ex. ",
                "i o u should stay the same ");
        List<String> actual = stringLogic.replaceLetterAWithOIfItsAfterP(TEST_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceLetterAWithOIfItsAfterPShouldFailWithLowerCase() {
        List<String> expected = Arrays.asList("Lorem ipasum dolor sit amet ",
                "Poesent pharetra nisi dui ",
                "Nam vulputate, mi nec luctus aliquet, ",
                "non vulputate justo sapaien ac ex. ",
                "i o u should stay the same ");
        List<String> actual = stringLogic.replaceLetterAWithOIfItsAfterP(TEST_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceWordsOfGivenLengthWithGivenSubstringShouldSucceed() {
        List<String> expected = Arrays.asList("Lorem ipasum dolor ++ amet ",
                "Paesent pharetra nisi ++ ",
                "++ vulputate, mi ++ luctus aliquet, ",
                "++ vulputate justo sapaien ac ++ ",
                "i o u should stay ++ same ");
        List<String> actual = stringLogic.replaceWordsOfGivenLengthWithGivenSubstring(TEST_DATA, 3, "++");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllNonLettersShouldSucceedWithDelimiters() {
        List<String> expected = Arrays.asList("Lorem ipasum dolor sit amet",
                "Paesent pharetra nisi dui",
                "Nam vulputate mi nec luctus aliquet",
                "non vulputate justo sapaien ac ex",
                "i o u should stay the same");
        List<String> actual = stringLogic.deleteAllNonLetters(TEST_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void insertSpacesBetweenSequencesOfLettersShouldSucceed() {
        List<String> expected = Arrays.asList("L o r e m ", "i p s u m ", "d o l o r  s i t ", "a m e t ");
        List<String> actual = stringLogic.insertSpacesBetweenSequencesOfLetters(SIMPLE_TEST_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllWordsOfGivenLengthThatStartWithConsonantShouldSucceed() {
        List<String> expected = Arrays.asList("Lorem ipasum dolor sit amet ",
                "Paesent pharetra dui ",
                "Nam vulputate, mi nec luctus aliquet, ",
                "non vulputate justo sapaien ac ex. ",
                "i o u should the ");
        List<String> actual = stringLogic.deleteAllWordsOfGivenLengthThatStartWithConsonant(TEST_DATA, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllWordsOfGivenLengthThatStartWithConsonantShouldFailAndDeleteAllWordsOfGivenLength() {
        List<String> expected = Arrays.asList("Lorem ipasum dolor sit ",
                "Paesent pharetra dui ",
                "Nam vulputate, mi nec luctus aliquet, ",
                "non vulputate justo sapaien ac ex. ",
                "i o u should the ");
        List<String> actual = stringLogic.deleteAllWordsOfGivenLengthThatStartWithConsonant(TEST_DATA, 4);
        Assert.assertEquals(expected, actual);
    }

}
