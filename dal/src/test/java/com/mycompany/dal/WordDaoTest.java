package com.mycompany.dal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/WEB-INF/spring/*-context.xml")
public class WordDaoTest {

    @Inject
    private WordDao wordDao;

    @Test
    public void testLoad() {
        List<String> hello = wordDao.readWordsFor("hello");

        assertTrue(hello.size() == 5);
    }

}
