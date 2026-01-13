package org.nayan.design_pattern.singleton;

public class DBConnection {

    private static DBConnection connection;
    private DBConnection(){}
    public static DBConnection getInstance(){
        if (connection == null) {
            synchronized (DBConnection.class){
                if (connection == null) {
                    connection=new DBConnection();
                }
            }
        }
        return connection;
    }
    public void showMessage() {
        System.out.println("Hello, this is a Singleton instance!");
    }

    public static void main(String[] args) {
        DBConnection connection = DBConnection.getInstance();
        // System.out.println(connection);
        connection.showMessage();
    }
}

/*
Private Static Instance Variable: The instance variable is declared as private static to hold
the single instance of the class.

Private Constructor: The constructor is declared as private to prevent the instantiation of
the class from outside.

Public getInstance Method: This method checks if the instance is null. If it is null,
it creates a new instance. This ensures that only one instance is created, even in a multi-threaded environment.

Double-Checked Locking: The synchronized block ensures that the instance is created in a thread-safe manner
without the overhead of acquiring a lock every time the method is called.

Client Code: The Main class demonstrates how to get the Singleton instance and call its methods.*/
