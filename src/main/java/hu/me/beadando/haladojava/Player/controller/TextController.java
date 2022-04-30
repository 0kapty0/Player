package hu.me.beadando.haladojava.Player.controller;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.exception.TextNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;
import hu.me.beadando.haladojava.Player.model.Text;
import hu.me.beadando.haladojava.Player.service.PictureService;
import hu.me.beadando.haladojava.Player.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class TextController {

    private TextService textService;

    @Autowired
    public TextController(TextService textService) { this.textService = textService; }

    @GetMapping("getOneText")
    @ResponseBody
    public Text getOneText(@RequestParam("id") int id) throws TextNotFoundException {
        return textService.getText(id);
    }

    @GetMapping("getListOfTexts")
    @ResponseBody
    public List getListOfTexts() {
        return textService.listTexts();
    }

    @RequestMapping("addText")
    @ResponseBody
    public String addText(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("text") String text) {
        textService.createText(new Text(id, name, text));
        return "The Text added. The ID is: " + id;
    }

    @RequestMapping("modifyText")
    @ResponseBody
    public String modifyText(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("text") String text) {
        textService.modifyText(new Text(id, name, text));
        return "The Text was modified. The ID is: " + id;
    }

    @GetMapping("deleteText")
    @ResponseBody
    public String deleteText(@RequestParam("id") int id) throws TextNotFoundException {
        textService.removeText(id);
        return "The Text was deleted";
    }

    @ExceptionHandler(TextNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String textNotFoundHandler() {
        return "No Text found with that id";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
