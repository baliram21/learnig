package org.nayan.design_pattern.singleton;

// Simplest & safest singleton.
// Pros: Thread-safe, serialization-safe, reflection-safe.
// Cons: Cannot lazy-load, cannot extend a class.
public enum EnumSingleton {

    INSTANCE; // This is the only instance of the singleton

    public void doSomething() {
        System.out.println("Doing something...");
    }
}
