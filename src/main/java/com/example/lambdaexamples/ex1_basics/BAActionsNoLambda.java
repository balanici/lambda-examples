package com.example.lambdaexamples.ex1_basics;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BAActionsNoLambda {

    public void printActiveAccounts(List<BankAccount> accounts, BACheckActive checkActive) {
        for (BankAccount bankAccount : accounts) {
            if (checkActive.test(bankAccount)) {
                System.out.println(bankAccount.ownerFullName() + ": " + bankAccount.isActive());
            }
        }
    }

    public void printAvailableAmount(List<BankAccount> accounts, BACheckAmountAvailable checkAmount) {
        for (BankAccount bankAccount : accounts) {
            if (checkAmount.test(bankAccount)) {
                System.out.println(bankAccount.ownerFullName() + ": " + bankAccount.currentAmount());
            }
        }
    }

}
