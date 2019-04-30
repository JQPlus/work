package cn.bugging.work;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
//让dao包中每个接口都变为实现类（或者在每个dao接口上写@mapper），自动将dao层注册为bean到spring中
@MapperScan("cn.bugging.work.dao")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )	
    {
    	SpringApplication.run(App.class, args);
//        System.out.println( "Hello World My Example!" );
    }
}
