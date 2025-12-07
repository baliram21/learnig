package org.nayan.design_pattern.singleton;

public class Main {
    public static void main(String[] args) {
        DBConnection connection= DBConnection.getInstance();
        // System.out.println(connection);
        connection.showMessage();
    }

}

