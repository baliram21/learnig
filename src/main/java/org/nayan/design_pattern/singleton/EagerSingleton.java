package org.nayan.design_pattern.singleton;

// EAGER initialization means: object is created at class loading time.
// Pros: Simple, thread-safe automatically.
// Cons: Instance is created even if application never uses it.
public final class EagerSingleton {

    // Instance is created immediately when class loads
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor prevents outside instantiation
    private EagerSingleton() { }

    // Global access point
    public static EagerSingleton getInstance() {
        return INSTANCE; // Always returns the already-created instance
    }
}
