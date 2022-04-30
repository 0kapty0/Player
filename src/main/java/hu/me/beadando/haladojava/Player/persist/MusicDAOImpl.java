package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.MusicNotFoundException;
import hu.me.beadando.haladojava.Player.model.Music;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MusicDAOImpl implements MusicDAO{

    private Map<Integer, Music> musicMap;

    public MusicDAOImpl(){
        musicMap = new HashMap<>();
        musicMap.put(1, new Music(1, "One Song", "Best Artist", 3.5, "Rock", 1, 1, "playing"));
    }

    @Override
    public Music getMusic(int id) throws MusicNotFoundException {
        if (!musicMap.containsKey(id)){
            throw new MusicNotFoundException();
        }
        return musicMap.get(id);
    }

    @Override
    public List<Music> getAllMusic() { return new ArrayList<Music>(musicMap.values()); }

    @Override
    public void insertMusic(Music music) {
        musicMap.put(music.getId(), music);
    }

    @Override
    public void updateMusic(Music music) { musicMap.replace(music.getId(), music); }

    @Override
    public void deleteMusic(Music music) { musicMap.remove(music); }

    @Override
    public boolean idUsed(int id) {
        return musicMap.containsKey(id);
    }
}
