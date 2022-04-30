package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PictureDaoImpl implements PictureDAO{

    private Map<Integer, Picture> pictureMap;

    public PictureDaoImpl() {
        pictureMap = new HashMap<>();
        pictureMap.put(1, new Picture(1, "Album cover 1", "URL 1"));
        pictureMap.put(2, new Picture(2, "Blu-ray cover 1", "URL 1"));
    }

    @Override
    public Picture getPicture(int id) throws PictureNotFoundException {
        if (!pictureMap.containsKey(id)){
            throw new PictureNotFoundException();
        }
        return pictureMap.get(id);
    }

    @Override
    public List<Picture> getAllPicture() { return new ArrayList<Picture>(pictureMap.values()); }

    @Override
    public void insertPicture(Picture picture) {
        pictureMap.put(picture.getId(), picture);
    }

    @Override
    public void updatePicture(Picture picture) { pictureMap.replace(picture.getId(), picture); }

    @Override
    public void deletePicture(Picture picture) { pictureMap.remove(picture.getId(), picture); }

    @Override
    public boolean idUsed(int id) {
        return pictureMap.containsKey(id);
    }
}
