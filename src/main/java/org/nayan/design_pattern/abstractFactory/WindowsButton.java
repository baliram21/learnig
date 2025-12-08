package org.nayan.design_pattern.abstractFactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}

