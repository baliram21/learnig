package org.nayan.design_pattern.facade;

public class HomeTheaterFacade {

    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem soundSystem) {
        this.dvd = dvd;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.widescreenMode();
        soundSystem.on();
        soundSystem.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
    }
}
