package hu.me.beadando.haladojava.Player.controller;

import hu.me.beadando.haladojava.Player.exception.MusicNotFoundException;
import hu.me.beadando.haladojava.Player.model.Music;
import hu.me.beadando.haladojava.Player.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MusicController {

    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) { this.musicService = musicService; }

    //egy zene adatainak kiiratása id alapján
    @RequestMapping(value = "getOneMusic")
    @ResponseBody
    public Music getOneMusic(@RequestParam("id") int id) throws MusicNotFoundException{
        return musicService.getMusic(id);
    }

    //egy zene elindítása id alapján
    @RequestMapping(value = "playMusic")
    @ResponseBody
    public String playMusic(@RequestParam("id") int id) throws MusicNotFoundException{
        musicService.playMusic(musicService.getMusic(id));
        return "The song status is: Play.";
    }

    //egy zene megállítása id alapján
    @RequestMapping(value = "pauseMusic")
    @ResponseBody
    public String pauseMusic(@RequestParam("id") int id) throws MusicNotFoundException{
        musicService.pauseMusic(musicService.getMusic(id));
        return "The song status is: Pause.";
    }

    //egy zene leállítása id alapján
    @RequestMapping(value = "stopMusic")
    @ResponseBody
    public String stopMusic(@RequestParam("id") int id) throws MusicNotFoundException{
        musicService.stopMusic(musicService.getMusic(id));
        return "The song status is: Stop.";
    }

    @ExceptionHandler(MusicNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String musicNotFoundHandler() {
        return "No Music found with that id";
    }
}
