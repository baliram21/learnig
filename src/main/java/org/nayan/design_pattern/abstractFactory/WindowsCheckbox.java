package org.nayan.design_pattern.abstractFactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void select() {
        System.out.println("Selecting Windows Checkbox");
    }
}
