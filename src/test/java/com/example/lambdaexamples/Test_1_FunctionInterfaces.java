package com.example.lambdaexamples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.lambdaexamples.ex1_basics.BACheckAmountAvailable;
import com.example.lambdaexamples.ex1_basics.BATrait;
import com.example.lambdaexamples.ex1_basics.BankAccount;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class Test_1_FunctionInterfaces {

    /**
     * function interfaces - about such interfaces,
     * about those from java.utils
     */
    /**
     * Notes
     * Lambda can be used only with interfaces
     * Technically, lambda is a shortcut to defining an implementation of a functional interface
     *
     */

    @Test
    void checkActiveAccount() {
        BankAccount bankAccount = new BankAccount("John Doe", true, BigDecimal.TEN);

        //use of interface implementation
        BATrait checkAccountActive = new BATrait() {
            @Override
            public boolean test(BankAccount bankAccount) {
                return bankAccount.isActive();
            }
        };
        System.out.println(checkAccountActive.test(bankAccount));
        assertTrue(checkAccountActive.test(bankAccount));

        //use of lambda, different syntax
//        BATrait checkAccountActiveLambda = (BankAccount ba)  -> { return ba.isActive();};
//        BATrait checkAccountActiveLambda = ba -> ba.isActive();
        BATrait checkAccountActiveLambda = BankAccount::isActive;
        System.out.println(checkAccountActiveLambda.test(bankAccount));
        assertTrue(checkAccountActiveLambda.test(bankAccount));
    }

    @Test
    void checkHasAmount() {
        BankAccount bankAccount = new BankAccount("John Doe", true, BigDecimal.TEN);
        BACheckAmountAvailable checkAmountAvailable = new BACheckAmountAvailable();
        assertTrue(checkAmountAvailable.test(bankAccount));

        //use of lambda
        BATrait hasAmount = (BankAccount ba) -> {
            return ba.currentAmount().compareTo(BigDecimal.ZERO) > 0;
        };
//        BATrait hasAmount = ba -> ba.currentAmount().compareTo(BigDecimal.ZERO) > 0;
        assertTrue(hasAmount.test(bankAccount));
    }

}
