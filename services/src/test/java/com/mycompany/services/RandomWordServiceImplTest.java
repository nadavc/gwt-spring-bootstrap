package com.mycompany.services;

import com.mycompany.dal.WordDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class RandomWordServiceImplTest {

    @InjectMocks
    private RandomWordServiceImpl randomWordService;

    @Mock
    private WordDao wordDao;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Sample test to demonstrate how to mock the DAL
     */
    @Test
    public void testReadRandomWordForExistingWords() {
        List<String> catTranslations = new ArrayList<String>();
        catTranslations.add("gato");

        when(wordDao.readWordsFor("cat")).thenReturn(catTranslations);
        String translatedCat = randomWordService.readRandomWordFor("cat");

        assertThat(translatedCat).isEqualTo("gato");
        verify(wordDao, times(1)).readWordsFor(anyString());
    }

    /**
     * This is an example of a test that is expected to throw an exception
     * because wordDao isn't told to return anything.
     */
    @Test(expected = RuntimeException.class)
    public void testReadRandomWordForInexistentWord() {
        randomWordService.readRandomWordFor("dog");
    }
}
