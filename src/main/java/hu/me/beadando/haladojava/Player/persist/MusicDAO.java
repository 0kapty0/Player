package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.MusicNotFoundException;
import hu.me.beadando.haladojava.Player.model.Music;

import java.util.List;

public interface MusicDAO {

    Music getMusic(int id) throws MusicNotFoundException;

    List<Music> getAllMusic();

    void insertMusic(Music music);

    void updateMusic(Music music);

    void deleteMusic(Music music);

    boolean idUsed(int id);
}
