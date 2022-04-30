package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.VideoNotFoundException;
import hu.me.beadando.haladojava.Player.model.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VideoDAOImpl implements VideoDAO{

    private Map<Integer, Video> videoMap;

    public VideoDAOImpl() {
        videoMap = new HashMap<>();
        videoMap.put(1, new Video(1, "Video 1", "ME-Film", 145, "documentary", 2, 2, "stop"));
    }

    @Override
    public Video getVideo(int id) throws VideoNotFoundException {
        if(!videoMap.containsKey(id)){
            throw new VideoNotFoundException();
        }
        return videoMap.get(id);
    }

    @Override
    public List<Video> getAllVideo() {
        return new ArrayList<Video>(videoMap.values());
    }

    @Override
    public void insertVideo(Video video) { videoMap.put(video.getId(), video); }

    @Override
    public void updateVideo(Video video) { videoMap.replace(video.getId(), video); }

    @Override
    public void deleteVideo(Video video) { videoMap.remove(video); }

    @Override
    public boolean idUsed(int id) {
        return videoMap.containsKey(id);
    }
}
