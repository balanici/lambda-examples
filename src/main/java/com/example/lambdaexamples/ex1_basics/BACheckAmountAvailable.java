package com.example.lambdaexamples.ex1_basics;

public class BACheckAmountAvailable implements BATrait {

    @Override
    public boolean test(BankAccount bankAccount) {
        return bankAccount.hasAmount();
    }
}
