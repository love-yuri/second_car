

package com.yuri.second_car;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuri.second_car.mapper")
@SpringBootApplication
public class SecondCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondCarApplication.class, args);
    }

}
