package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.MusicNotFoundException;
import hu.me.beadando.haladojava.Player.model.Music;
import hu.me.beadando.haladojava.Player.persist.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    private MusicDAO musicDAO;

    @Autowired
    public MusicServiceImpl(MusicDAO musicDAO){ this.musicDAO = musicDAO; }

    @Override
    public Music getMusic(int id) throws MusicNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return musicDAO.getMusic(id);
    }

    @Override
    public List listAllMusic() {
        return musicDAO.getAllMusic();
    }

    @Override
    public void playMusic(Music music) {
        music.setStatus("Play");
        musicDAO.updateMusic(music);
    }

    @Override
    public void pauseMusic(Music music) {
        music.setStatus("Pause");
        musicDAO.updateMusic(music);
    }

    @Override
    public void stopMusic(Music music) {
        music.setStatus("Stop");
        musicDAO.updateMusic(music);
    }
}
