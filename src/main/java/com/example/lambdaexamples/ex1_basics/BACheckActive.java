package com.example.lambdaexamples.ex1_basics;

public class BACheckActive implements BATrait {

    @Override
    public boolean test(BankAccount bankAccount) {
        return bankAccount.isActive();
    }
}
