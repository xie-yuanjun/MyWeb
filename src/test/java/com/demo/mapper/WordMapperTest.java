package com.demo.mapper;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.demo.ApplicationStart;
import com.demo.service.impl.WordServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author admin
 * @Title: WordMapperTest
 * @ProjectName note
 * @Description: TODO
 * @date 2021/3/1517:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@MapperScan("com.demo.word.mapper")
public class WordMapperTest {
    @Autowired
    private WordServiceImpl wordService;
    @Autowired
    private WordMapper wordMapper;
    @NacosInjected
    private NamingService namingService;


    @Test
    public void addWordTest() throws NacosException {
//        Word word = new Word();
//        word.setId(1);
//        List<Word> list = wordMapper.select(word);
//        for (Word wordInfo : list) {
//            System.out.println(wordInfo);
//        }
        namingService.registerInstance("word", "172.0.0.1", 8080);
        System.out.println("注册成功！");
    }

}
