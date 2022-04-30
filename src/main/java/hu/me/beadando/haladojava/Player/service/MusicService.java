package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.MusicNotFoundException;
import hu.me.beadando.haladojava.Player.model.Music;

import java.util.List;

// Ez egy elképzelt felhasználói felület ahol a zenéket csak
// kilistázni, meghallgatni, megállítani, leállítani tudjuk
// így feltöltés, módosítás funkció nem lesz (törlés végképp...)
public interface MusicService {

    Music getMusic(int id) throws MusicNotFoundException;

    List listAllMusic();

    void playMusic(Music music);

    void pauseMusic(Music music);

    void stopMusic(Music music);
}
