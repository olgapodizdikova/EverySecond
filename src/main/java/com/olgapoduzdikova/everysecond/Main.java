package main.com.java.olgapoduzdikova;

import main.com.java.olgapoduzdikova.EverySecondIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> list = List.of(args);

        Iterator<String> iterator = new EverySecondIterator<>(list.iterator());

        List<String> everySecondList = new ArrayList<>();
        while(iterator.hasNext()){
            String next = iterator.next();
            everySecondList.add(next);
        }

        List<String> expectedList = IntStream.range(0, list.size())
                .filter(n -> n % 2 == 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());


        // simple test
        System.out.println(String.format("Expected result: %s", expectedList));
        System.out.println(String.format("Actual result: %s", everySecondList));
        boolean isEquals = Arrays.equals(expectedList.toArray(), everySecondList.toArray());
        System.out.println(String.format("Does the iterator return every second value? %s", isEquals));
    }
}
