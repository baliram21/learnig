package org.nayan.design_pattern.singleton;

// This makes the whole method synchronized.
// Pros: Thread-safe.
// Cons: Slow performance due to synchronization on every call.
public final class SynchronizedLazySingleton {

    private static SynchronizedLazySingleton instance;

    private SynchronizedLazySingleton() { }

    public static synchronized SynchronizedLazySingleton getInstance() {
        if (instance == null) { // Instance is created lazily
            instance = new SynchronizedLazySingleton();
        }
        return instance;
    }
}
