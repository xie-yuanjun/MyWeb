package com.demo.mapper;

import com.demo.entity.WordClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Title: WordClassMapperTest
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/318:12
 */
public class WordClassMapperTest extends TestBase {
    @Autowired
    private WordClassMapper wordClassMapper;


    @Test
    public void selectByClassIdListTest(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        List<WordClass> classList = wordClassMapper.selectByClassIdList(list);
        for (WordClass wordClass : classList){
            System.out.println(wordClass);
        }
    }
}
