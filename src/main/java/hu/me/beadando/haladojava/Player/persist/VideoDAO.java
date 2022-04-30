package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.VideoNotFoundException;
import hu.me.beadando.haladojava.Player.model.Video;

import java.util.List;

public interface VideoDAO {

    Video getVideo(int id) throws VideoNotFoundException;

    List<Video> getAllVideo();

    void insertVideo(Video video);

    void updateVideo(Video video);

    void deleteVideo(Video video);

    boolean idUsed(int id);
}
