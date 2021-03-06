package priv.ljh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan("priv.ljh.uniapp.mapper")  在项目启动类上加入@MapperScan注解，用于批量扫描
 */
@MapperScan("priv.ljh.uniapp.mapper")
@SpringBootApplication
public class WarmSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarmSearchApplication.class, args);
    }

}