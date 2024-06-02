package com.github.denglei1024.soloblogger;

import com.github.denglei1024.soloblogger.initializer.MongoInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * SoloBloggerApplication
 * @author denglei
 */
@SpringBootApplication
@Import(MongoInitializer.class)
public class SoloBloggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloBloggerApplication.class, args);
    }

}
