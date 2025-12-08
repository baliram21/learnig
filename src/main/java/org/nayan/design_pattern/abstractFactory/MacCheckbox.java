package org.nayan.design_pattern.abstractFactory;

public class MacCheckbox implements Checkbox {
    @Override
    public void select() {
        System.out.println("Selecting Mac Checkbox");
    }
}
