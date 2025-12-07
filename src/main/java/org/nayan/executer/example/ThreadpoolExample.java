package org.nayan.executer.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolExample {
        public static void main(String[] args) {
                List<Customer> customers = new ArrayList<>();

                customers.add(new Customer("Alice", 9123456789L, "alice@example.com", "P001", 1000.0));
                customers.add(new Customer("Bob", 9234567890L, "bob@example.com", "P002", 2000.0));
                customers.add(new Customer("Charlie", 9345678901L, "charlie@example.com", "P003", 3000.0));
                customers.add(new Customer("David", 9456789012L, "david@example.com", "P004", 4000.0));
                customers.add(new Customer("Eve", 9567890123L, "eve@example.com", "P005", 5000.0));
                customers.add(new Customer("Frank", 9678901234L, "frank@example.com", "P006", 6000.0));
                customers.add(new Customer("Grace", 9789012345L, "grace@example.com", "P007", 7000.0));
                customers.add(new Customer("Heidi", 9890123456L, "heidi@example.com", "P008", 8000.0));
                customers.add(new Customer("Ivan", 9901234567L, "ivan@example.com", "P009", 9000.0));
                customers.add(new Customer("Judy", 9012345678L, "judy@example.com", "P010", 10000.0));
                customers.add(new Customer("Alice", 9123456789L, "alice@example.com", "P001", 1000.0));
                customers.add(new Customer("Bob", 9234567890L, "bob@example.com", "P002", 2000.0));
                customers.add(new Customer("Charlie", 9345678901L, "charlie@example.com", "P003", 3000.0));
                customers.add(new Customer("David", 9456789012L, "david@example.com", "P004", 4000.0));
                customers.add(new Customer("Eve", 9567890123L, "eve@example.com", "P005", 5000.0));
                customers.add(new Customer("Frank", 9678901234L, "frank@example.com", "P006", 6000.0));
                customers.add(new Customer("Grace", 9789012345L, "grace@example.com", "P007", 7000.0));
                customers.add(new Customer("Heidi", 9890123456L, "heidi@example.com", "P008", 8000.0));
                customers.add(new Customer("Ivan", 9901234567L, "ivan@example.com", "P009", 9000.0));
                customers.add(new Customer("Judy", 9012345678L, "judy@example.com", "P010", 10000.0));
                customers.add(new Customer("Alice", 9123456789L, "alice@example.com", "P001", 1000.0));
                customers.add(new Customer("Bob", 9234567890L, "bob@example.com", "P002", 2000.0));
                customers.add(new Customer("Charlie", 9345678901L, "charlie@example.com", "P003", 3000.0));
                customers.add(new Customer("David", 9456789012L, "david@example.com", "P004", 4000.0));
                customers.add(new Customer("Eve", 9567890123L, "eve@example.com", "P005", 5000.0));
                customers.add(new Customer("Frank", 9678901234L, "frank@example.com", "P006", 6000.0));
                customers.add(new Customer("Grace", 9789012345L, "grace@example.com", "P007", 7000.0));
                customers.add(new Customer("Heidi", 9890123456L, "heidi@example.com", "P008", 8000.0));
                customers.add(new Customer("Ivan", 9901234567L, "ivan@example.com", "P009", 9000.0));
                customers.add(new Customer("Judy", 9012345678L, "judy@example.com", "P010", 10000.0));
                customers.add(new Customer("Alice", 9123456789L, "alice@example.com", "P001", 1000.0));
                customers.add(new Customer("Bob", 9234567890L, "bob@example.com", "P002", 2000.0));
                customers.add(new Customer("Charlie", 9345678901L, "charlie@example.com", "P003", 3000.0));
                customers.add(new Customer("David", 9456789012L, "david@example.com", "P004", 4000.0));
                customers.add(new Customer("Eve", 9567890123L, "eve@example.com", "P005", 5000.0));
                customers.add(new Customer("Frank", 9678901234L, "frank@example.com", "P006", 6000.0));
                customers.add(new Customer("Grace", 9789012345L, "grace@example.com", "P007", 7000.0));
                customers.add(new Customer("Heidi", 9890123456L, "heidi@example.com", "P008", 8000.0));
                customers.add(new Customer("Ivan", 9901234567L, "ivan@example.com", "P009", 9000.0));
                customers.add(new Customer("Judy", 9012345678L, "judy@example.com", "P010", 10000.0));

                ExecutorService executorService = Executors.newFixedThreadPool(3);

                for (int i = 0; i < customers.size(); i++) {
                        TriggerEmailForPolicy task = new TriggerEmailForPolicy(customers.get(i), i + 1);
                        executorService.submit(task);
                }

                executorService.shutdown();
        }
}
