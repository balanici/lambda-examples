package com.example.lambdaexamples.ex1_basics;

import java.math.BigDecimal;

public record BankAccount(String ownerFullName, Boolean isActive, BigDecimal currentAmount) {

    boolean hasAmount() {
        return currentAmount.compareTo(BigDecimal.ZERO) > 0;
    }

}
