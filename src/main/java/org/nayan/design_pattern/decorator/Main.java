package org.nayan.design_pattern.decorator;

public class Main {
    public static void main(String[] args) {

        Margherita margherita = new Margherita();

        System.out.println(margherita.cost());

        Mushroom mushroom = new Mushroom(margherita);  //new Mushroom(new Margherita())
        System.out.println(mushroom.cost());

        ExtraCheese extraCheese = new ExtraCheese(mushroom);  //new ExtraCheese(new Mushroom(new Margherita()));
        System.out.println(extraCheese.cost());
    }
}
