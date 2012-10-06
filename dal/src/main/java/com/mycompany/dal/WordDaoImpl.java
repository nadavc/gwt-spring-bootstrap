package com.mycompany.dal;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WordDaoImpl implements WordDao {

    @Override
    public List<String> readWordsFor(String word) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("Hola");
        list.add("Shalom");
        list.add("Saluton");
        list.add("Saluto");
        list.add("Godaw");
        return list;
    }

}
