package com.arsatapathy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();

        AtomicInteger count = new AtomicInteger(1);

        for (int i = 1; i <= 5; i++) {
            customerList.add(Customer.builder().id(i).build());
        }

        List<Customer> customers = customerList.stream()
                .filter(customer -> {
                    System.out.println("inside filter for customer " + customer);
                    return customer.getId() != 3;
                })
                .map(customer -> {
                    System.out.println("inside map for customer " + customer);
                    customer.setName("Ashish" + count.getAndIncrement());
                    return customer;
                }).collect(Collectors.toList());

        customers.forEach(System.out::println);
    }
}
