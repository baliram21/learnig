package org.nayan.design_pattern.abstractFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        GUIFactory factory;

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}
