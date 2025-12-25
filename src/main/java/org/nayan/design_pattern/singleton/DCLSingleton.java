package org.nayan.design_pattern.singleton;

// This solves performance + thread-safety issues.
// Double-checking prevents unnecessary synchronization after instance is created.
// volatile ensures visibility across threads (important!!)
public final class DCLSingleton {

    private static volatile DCLSingleton instance;

    private DCLSingleton() { }

    public static DCLSingleton getInstance() {
        if (instance == null) {                      // 1st check - improves speed
            synchronized (DCLSingleton.class) {       // Lock only when needed
                if (instance == null) {              // 2nd check - thread safety
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
