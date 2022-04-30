package hu.me.beadando.haladojava.Player.controller;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;
import hu.me.beadando.haladojava.Player.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class PictureController {

    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) { this.pictureService = pictureService; }

    @GetMapping("getOnePicture")
    @ResponseBody
    public Picture getOnePicture(@RequestParam("id") int id) throws PictureNotFoundException {
        return pictureService.getPicture(id);
    }

    @GetMapping("getListOfPictures")
    @ResponseBody
    public List getListOfPictures() {
        return pictureService.listPictures();
    }

    @RequestMapping("addPicture")
    @ResponseBody
    public String addPicture(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("url") String url) {
        pictureService.createPicture(new Picture(id, name, url));
        return "The picture added. The ID is: " + id;
    }

    @RequestMapping("modifyPicture")
    @ResponseBody
    public String modifyPicture(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("url") String url) {
        pictureService.modifyPicture(new Picture(id, name, url));
        return "The picture was modified. The ID is: " + id;
    }

    @GetMapping("deletePicture")
    @ResponseBody
    public String deletePicture(@RequestParam("id") int id) throws PictureNotFoundException {
        pictureService.removePicture(id);
        return "The Picture was deleted";
    }

    @ExceptionHandler(PictureNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String pictureNotFoundHandler() {
        return "No Picture found with that id";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
