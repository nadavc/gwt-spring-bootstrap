package com.mycompany.dal;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WordDao {

    @Select("select translated from translations where original = #{word}")
    List<String> readWordsFor(String word);

    @Select("select 1")
    int selectOne();

}
