package com.mycompany.dal;

import java.util.List;

public interface WordDao {

    List<String> readWordsFor(String word);

}
