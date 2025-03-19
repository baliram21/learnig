package org.example.design.singleton;

public class Main {
    public static void main(String[] args) {
        DBConnection connection= DBConnection.getInstance();
        // System.out.println(connection);
        connection.showMessage();
    }



}

