package com.itheima.test;

import com.itheima.dao.ItermDao;
import com.itheima.dao.impl.ItermDaoImpl;
import com.itheima.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemTest {

    @Test
    public void findAll(){
        ItermDao itermDao = new ItermDaoImpl();
        List<Items> items = itermDao.findAll();
        for (Items item : items) {
            System.out.println(item.getId());
            System.out.println("---------");
        }


    }
}
