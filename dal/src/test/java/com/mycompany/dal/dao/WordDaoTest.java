package com.mycompany.dal.dao;

import com.mycompany.dal.dao.UserDao;
import com.mycompany.dal.dao.WordDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Example of a JUnit test that uses Spring and a real context to load the dependencies
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/*-context.xml",
})
public class WordDaoTest {

    @Inject
    private WordDao wordDao;

    @Test
    public void testLoad() {
        List<String> words = wordDao.readWordsFor("hello");

        // This is fest-assert. A fluent style of assertions.
        assertThat(words).isNotNull().hasSize(5);
    }

}
