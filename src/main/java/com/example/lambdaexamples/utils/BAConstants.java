package com.example.lambdaexamples.utils;

import com.example.lambdaexamples.ex1_basics.BankAccount;
import java.math.BigDecimal;
import java.util.List;

public class BAConstants {


    public static final List<BankAccount> bankAccountList =
        List.of(
            new BankAccount("User1", Boolean.TRUE, BigDecimal.valueOf(111111)),
            new BankAccount("User2", Boolean.TRUE, BigDecimal.valueOf(222222)),
            new BankAccount("User3", Boolean.FALSE, BigDecimal.valueOf(3333)),
            new BankAccount("User4", Boolean.TRUE, BigDecimal.valueOf(0)),
            new BankAccount("User5", Boolean.FALSE, BigDecimal.valueOf(5555555))
        );


}
