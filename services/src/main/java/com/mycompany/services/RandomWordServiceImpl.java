package com.mycompany.services;

import com.mycompany.dal.WordDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

/**
 * A service that isn't necessarily tied to an external API
 */
@Service
public class RandomWordServiceImpl implements RandomWordService {

    @Inject
    private WordDao wordDao;

    @Override
    public String readRandomWordFor(String word) {
        List<String> words = wordDao.readWordsFor(word);
        if (words.size() == 0) {
            throw new RuntimeException("Could not find words for: " + word);
        }

        int random = new Random().nextInt(words.size());
        return words.get(random);
    }

}

