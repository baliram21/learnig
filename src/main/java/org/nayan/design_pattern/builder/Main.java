package org.nayan.design_pattern.builder;

public class Main {
    public static void main(String[] args) {

        User nayan = new User.UserBuilder()
                .setUserId(1)
                .setName("Nayan")
                .setEmail("nayan@test.com")
                .build();

        System.out.println(nayan);

        User sonu = User.UserBuilder.builder()
                .setUserId(2)
                .setName("Sonu")
                .setEmail("sonu@test.com")
                .build();

        System.out.println(sonu);
    }
}
