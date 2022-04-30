package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.TextNotFoundException;
import hu.me.beadando.haladojava.Player.model.Text;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TextDAOImpl implements TextDAO{

    private Map<Integer, Text> textMap;

    public TextDAOImpl() {
        textMap = new HashMap<>();
        textMap.put(1, new Text(1, "Lyrics 1", "Lalalalalaaaa~dzsiumdisu~nanananannaaa"));
        textMap.put(2, new Text(2, "Subtitle 2",
                "Réges-rég egy messzi-messzi galaxisban, Halado JAVA órán..."));
    }

    @Override
    public Text getText(int id) throws TextNotFoundException {
        if(!textMap.containsKey(id)){
            throw new TextNotFoundException();
        }
        return textMap.get(id);
    }

    @Override
    public List<Text> getAllText() {
        return new ArrayList<Text>(textMap.values());
    }

    @Override
    public void insertText(Text text) {
        textMap.put(text.getId(), text);
    }

    @Override
    public void updateText(Text text) { textMap.replace(text.getId(), text); }

    @Override
    public void deleteText(Text text) { textMap.remove(text.getId(), text); }

    @Override
    public boolean idUsed(int id) { return textMap.containsKey(id); }
}
