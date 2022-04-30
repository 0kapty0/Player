package hu.me.beadando.haladojava.Player.persist;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;

import java.util.List;

public interface PictureDAO {

    Picture getPicture(int id) throws PictureNotFoundException;

    List<Picture> getAllPicture();

    void insertPicture(Picture picture);

    void updatePicture(Picture picture);

    void deletePicture(Picture picture);

    boolean idUsed(int id);
}
