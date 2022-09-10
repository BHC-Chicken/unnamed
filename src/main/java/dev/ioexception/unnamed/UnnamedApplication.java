package dev.ioexception.unnamed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class UnnamedApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnnamedApplication.class, args);
    }

}
