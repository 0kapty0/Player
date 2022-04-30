package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.VideoNotFoundException;
import hu.me.beadando.haladojava.Player.model.Video;
import hu.me.beadando.haladojava.Player.persist.VideoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    private VideoDAO videoDAO;

    @Autowired
    public VideoServiceImpl(VideoDAO videoDAO) { this.videoDAO = videoDAO; }

    @Override
    public Video getVideo(int id) throws VideoNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return videoDAO.getVideo(id);
    }

    @Override
    public List listAllVideo() {
        return videoDAO.getAllVideo();
    }

    @Override
    public void playVideo(Video video) {
        video.setStatus("Play");
        videoDAO.updateVideo(video);
    }

    @Override
    public void pauseVideo(Video video) {
        video.setStatus("Pause");
        videoDAO.updateVideo(video);
    }

    @Override
    public void stopVideo(Video video) {
        video.setStatus("Stop");
        videoDAO.updateVideo(video);
    }
}
