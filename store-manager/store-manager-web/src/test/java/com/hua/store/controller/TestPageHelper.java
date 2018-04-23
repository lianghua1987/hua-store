package com.hua.store.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.store.mapper.ItemMapper;
import com.hua.store.pojo.Item;
import com.hua.store.pojo.ItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestPageHelper {

    @Test
    public void testPageHelper(){

        // Create a sping ioc container
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        ItemMapper itemMapper = applicationContext.getBean(ItemMapper.class);
        ItemExample itemExample = new ItemExample();
        PageHelper.startPage(1,20);
        List<Item> items = itemMapper.selectByExample(itemExample);

        for(Item item : items){
            System.out.println(item.getTitle());
        }

        PageInfo<Item> pagetInfo = new PageInfo<>();
        System.out.println(pagetInfo.getTotal());

    }
}
