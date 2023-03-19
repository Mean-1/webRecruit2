package com.xxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Keafmd
 *
 * @ClassName: YebApplication
 * @Description:启动类
 * @author: liuchen
 * @date: 2022/3/30 16:04
 * @Blog:
 */
@SpringBootApplication
@MapperScan("com.xxx.server.mapper")
@EnableSwagger2
@EnableWebMvc
@EnableScheduling
//测试所需要的注解
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = YebApplication.class )
public class YebApplication {
    /*@Autowired
    private MenuMapper menuMapper;
    @Test
    public void test() {
        List<Menu> map = menuMapper.getMenusByAdminId(2);
        for (Menu menu : map) {
            System.out.println(menu);
        }
    }*/

    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class,args);
    }
}
