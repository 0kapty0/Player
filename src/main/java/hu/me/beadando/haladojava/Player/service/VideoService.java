package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.VideoNotFoundException;
import hu.me.beadando.haladojava.Player.model.Video;

import java.util.List;

// Ugyanaz a helyzet mint a MusicSevice-nél
// listázás, lejátszás, megállítás, leállítás a használható funkció
public interface VideoService {

    Video getVideo(int id) throws VideoNotFoundException;

    List listAllVideo();

    void playVideo(Video video);

    void pauseVideo(Video video);

    void stopVideo(Video video);
}
