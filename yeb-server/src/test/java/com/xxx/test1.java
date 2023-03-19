package com.xxx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Keafmd
 *
 * @ClassName: test1
 * @Description: 测试Menu_sql语句查询
 * @author: liuchen
 * @date: 2022/5/1 16:21
 * @Blog:
 */
/*
    这里测试不了，初步推测是因为这里无法调用bean，但是在YebApplication类中就能够测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = test1.class )

//@MybatisPlusTest
//@AutoConfigureTestDatabase
public class test1 {
//    @Autowired
//    private MenuMapper menuMapper;
//    @Test
//    public void test() {
//        List<Menu> map = menuMapper.getMenusByAdminId(2);
//        for (Menu menu : map) {
//            System.out.println(menu);
//        }
//    }

}
