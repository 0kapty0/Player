package hu.me.beadando.haladojava.Player.controller;

import hu.me.beadando.haladojava.Player.exception.VideoNotFoundException;
import hu.me.beadando.haladojava.Player.model.Video;
import hu.me.beadando.haladojava.Player.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) { this.videoService = videoService; }

    //egy videó adatainak kiiratása id alapján
    @RequestMapping(value = "getOneVideo")
    @ResponseBody
    public Video getOneVideo(@RequestParam("id") int id) throws VideoNotFoundException {
        return videoService.getVideo(id);
    }

    //egy videó elindítása id alapján
    @RequestMapping(value = "playVideo")
    @ResponseBody
    public String playVideo(@RequestParam("id") int id) throws VideoNotFoundException{
        videoService.playVideo(videoService.getVideo(id));
        return "The video status is: Play.";
    }

    //egy videó megállítása id alapján
    @RequestMapping(value = "pauseVideo")
    @ResponseBody
    public String pauseVideo(@RequestParam("id") int id) throws VideoNotFoundException{
        videoService.pauseVideo(videoService.getVideo(id));
        return "The video status is: Pause.";
    }

    //egy videó leállítása id alapján
    @RequestMapping(value = "stopVideo")
    @ResponseBody
    public String stopVideo(@RequestParam("id") int id) throws VideoNotFoundException{
        videoService.stopVideo(videoService.getVideo(id));
        return "The video status is: Stop.";
    }

    @ExceptionHandler(VideoNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String videoNotFoundHandler() {
        return "No Video found with that id";
    }
}
