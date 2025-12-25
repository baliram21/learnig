package org.nayan.exception;

public class Connection {
    void execute() { throw new RuntimeException("execute failed"); }
    void close() { System.out.println("closed"); }
}
