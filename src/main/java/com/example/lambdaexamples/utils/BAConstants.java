package com.example.lambdaexamples.utils;

import com.example.lambdaexamples.ex1_basics.BankAccount;
import java.math.BigDecimal;
import java.util.List;

public class BAConstants {

    public static final List<BankAccount> bankAccountList =
        List.of(
            new BankAccount("User1", Boolean.TRUE, BigDecimal.valueOf(111111)),
            new BankAccount("User2", Boolean.TRUE, BigDecimal.valueOf(222222)),
            new BankAccount("User36", Boolean.FALSE, BigDecimal.valueOf(33433)),
            new BankAccount("Fser4", Boolean.TRUE, BigDecimal.valueOf(0)),
            new BankAccount("UTer2", Boolean.TRUE, BigDecimal.valueOf(22243222)),
            new BankAccount("RUser3", Boolean.FALSE, BigDecimal.valueOf(33383)),
            new BankAccount("User4", Boolean.TRUE, BigDecimal.valueOf(0)),
            new BankAccount("UGer2", Boolean.TRUE, BigDecimal.valueOf(2222322)),
            new BankAccount("User3", Boolean.FALSE, BigDecimal.valueOf(3333)),
            new BankAccount("ter4", Boolean.TRUE, BigDecimal.valueOf(0)),
            new BankAccount("User24", Boolean.TRUE, BigDecimal.valueOf(122222)),
            new BankAccount("Pser3", Boolean.FALSE, BigDecimal.valueOf(3333)),
            new BankAccount("User4", Boolean.TRUE, BigDecimal.valueOf(0)),
            new BankAccount("User56", Boolean.FALSE, BigDecimal.valueOf(587555555))
        );

}
