package com.example.lambdaexamples;

import static java.util.stream.Collectors.maxBy;

import com.example.lambdaexamples.ex1_basics.BankAccount;
import com.example.lambdaexamples.utils.BAConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class Test_2_Streams {

    /**
     * Streams:
     * foreach, filter, sorting, grouping, min, max, reverse
     * map, flatmap, collect
     * parallel streams
     * optional
     */

    @Test
    void streamForeach() {
        for (BankAccount bankAccount : BAConstants.bankAccountList) {
            System.out.println(bankAccount.ownerFullName());
        }
        System.out.println("-----------");
        BAConstants.bankAccountList
            .forEach(ba -> System.out.println(ba.ownerFullName()));
    }

    @Test
    void streamFilter() {
        BAConstants.bankAccountList
            .stream()
            .filter(BankAccount::isActive)
            .filter(bankAccount -> bankAccount.ownerFullName().startsWith("U"))
            .toList()
            .forEach(System.out::println);
    }

    @Test
    void streamSorted() {
        BAConstants.bankAccountList
            //            .stream().sorted(new Comparator<BankAccount>() {
            //                @Override
            //                public int compare(BankAccount o1, BankAccount o2) {
            //                    return o1.ownerFullName().compareTo(o2.ownerFullName());
            //                }
            //            })
            .stream().sorted(Comparator.comparing(BankAccount::ownerFullName).reversed())
            .forEach(System.out::println);
    }

    @Test
    void streamGrouping() {
        BAConstants.bankAccountList
            .stream()
            .filter(ba -> ba.ownerFullName().toLowerCase().contains("user"))
            .collect(
//                Collectors.groupingBy(BankAccount::ownerFullName, Collectors.counting()
//                Collectors.groupingBy(BankAccount::isActive, Collectors.counting()
                Collectors.groupingBy(BankAccount::currentAmount, Collectors.counting()
                )
            ).forEach((fullname, size) -> System.out.println(fullname + ": " + size));

        //        System.out.println(collected);
    }

    @Test
    void streamMinMax() {
        Optional<BankAccount> min = BAConstants.bankAccountList
            .stream().min(Comparator.comparing(BankAccount::currentAmount));
        System.out.println(min);
        Optional<BankAccount> max = BAConstants.bankAccountList
            .stream().max(Comparator.comparing(BankAccount::currentAmount));
        System.out.println(max);

        System.out.println("-----------");
        BAConstants.bankAccountList
            .stream()
            .collect(
                Collectors
                    .groupingBy(
                        BankAccount::isActive,
                        maxBy(Comparator.comparing(BankAccount::currentAmount))
                    ))
                .forEach((status, bankAccount) ->
                    System.out.println(status + ":" + bankAccount));
    }

    @Test
    void optionalMapFlatmap() {
        Optional<String> hello = Optional.of("Hello");
        System.out.println(hello.map(s -> s.toUpperCase()));
        System.out.println(hello.map(s -> "Some other String"));
        System.out.println(hello.map(s -> s.length()));

        System.out.println("----flatmap-------");
        Optional<Optional<String>> optionalOptional = Optional.of(Optional.of("Hello"));
        System.out.println(optionalOptional.flatMap(s -> s).get());

    }

    @Test
    void streamMapFlatmap() {

        List<List<String>> list = Arrays.asList(
            Arrays.asList("E"),
            Arrays.asList("T"),
            Arrays.asList("B"),
            Arrays.asList("s"),
            Arrays.asList("o"),
            Arrays.asList("WE"),
            Arrays.asList("k")
        );

        System.out.println(list);
        List<String> stringList = list.stream().flatMap(Collection::stream)
            .toList();
        System.out.println(stringList);
    }

    @Test
    void streamParallel() {
        IntStream intRange1 = IntStream.rangeClosed(0, 20);
        intRange1.forEach(System.out::println);

        System.out.println("-------parallel------------");
        IntStream intRange2 = IntStream.rangeClosed(0, 20);
        intRange2.parallel().forEach(System.out::println);
    }

}
