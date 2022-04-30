package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.TextNotFoundException;
import hu.me.beadando.haladojava.Player.model.Text;

import java.util.List;

public interface TextDAO {

    Text getText(int id) throws TextNotFoundException;

    List<Text> getAllText();

    void insertText(Text text);

    void updateText(Text text);

    void deleteText(Text text);

    boolean idUsed(int id);
}
