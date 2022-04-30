package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.TextNotFoundException;
import hu.me.beadando.haladojava.Player.model.Text;

import java.util.List;

// a PictureService-hoz hasonlóan, ide már lehet feltölteni módosítani feliratokat vagy dalszövegeket
public interface TextService  {

    Text getText(int id) throws TextNotFoundException;

    List listTexts();

    void createText(Text text);

    void modifyText(Text text);

    void removeText(int id) throws TextNotFoundException ;
}
