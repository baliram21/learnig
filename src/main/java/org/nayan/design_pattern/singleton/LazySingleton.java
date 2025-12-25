package org.nayan.design_pattern.singleton;

// LAZY initialization means: object is created only when first requested.
// But this version is NOT thread-safe (multiple threads may create multiple instances).
public final class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        if (instance == null) {   // Instance created only when needed
            instance = new LazySingleton(); // NOT thread-safe
        }
        return instance;
    }
}
