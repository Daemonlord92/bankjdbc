package org.blitmatthew.bankjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BankjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankjdbcApplication.class, args);
    }

}
