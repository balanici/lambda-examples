package com.example.lambdaexamples;

import com.example.lambdaexamples.ex1_basics.BAActionsNoLambda;
import com.example.lambdaexamples.ex1_basics.BACheckActive;
import com.example.lambdaexamples.ex1_basics.BACheckAmountAvailable;
import com.example.lambdaexamples.utils.BAConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LambdaExamplesApplication implements CommandLineRunner {

    @Autowired
    private BAActionsNoLambda baActionsNoLambda;

    public static void main(String[] args) {
        SpringApplication.run(LambdaExamplesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------no lambda---------------");
        baActionsNoLambda.printActiveAccounts(BAConstants.bankAccountList, new BACheckActive());
        System.out.println("---------------------");
        baActionsNoLambda.printAvailableAmount(BAConstants.bankAccountList, new BACheckAmountAvailable());
        System.out.println("-------with lambda--------------");
        System.out.println("---------------------");
    }
}
