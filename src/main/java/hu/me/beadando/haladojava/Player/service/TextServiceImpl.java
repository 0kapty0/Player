package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.TextNotFoundException;
import hu.me.beadando.haladojava.Player.model.Text;
import hu.me.beadando.haladojava.Player.persist.TextDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TextServiceImpl implements TextService{

    private TextDAO textDAO;

    @Autowired
    public TextServiceImpl(TextDAO textDAO) { this.textDAO = textDAO; }

    @Override
    public Text getText(int id) throws TextNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return textDAO.getText(id);
    }

    @Override
    public List listTexts() {
        return textDAO.getAllText();
    }

    @Override
    public void createText(Text text) {
        if (text.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (textDAO.idUsed(text.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        textDAO.insertText(text);
    }

    @Override
    public void modifyText(Text text) { textDAO.updateText(text); }

    @Override
    public void removeText(int id) throws TextNotFoundException {
        if (!textDAO.idUsed(id)) {
            throw new InvalidParameterException("Text does not exist");
        }
        textDAO.deleteText(textDAO.getText(id));
    }
}
