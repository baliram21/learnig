package org.nayan.design_pattern.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade facade = new HomeTheaterFacade(dvd, projector, sound);

        facade.watchMovie("Iron Man");
        facade.endMovie();
    }
}
