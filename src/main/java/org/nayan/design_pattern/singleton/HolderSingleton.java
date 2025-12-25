package org.nayan.design_pattern.singleton;

// Uses Java class-loading mechanism to ensure lazy loading + thread-safety.
// Pros: Fast, thread-safe, simple, no synchronization needed.
public final class HolderSingleton {

    private HolderSingleton() { }

    // Inner static class is NOT loaded until getInstance() is called
    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE; // Loaded and created only when called
    }
}
