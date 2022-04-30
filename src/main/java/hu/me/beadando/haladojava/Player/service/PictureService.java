package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;
import org.springframework.stereotype.Service;

import java.util.List;

// Itt már bármilyen felhasználó feltölthet albumképet, vagy film borítót
// amely moderálás után vagy elfogadásra kerül vagy nem (legalábbis ez az elképzelt élethelyzet)
@Service
public interface PictureService {

    Picture getPicture(int id) throws PictureNotFoundException;

    List listPictures();

    void createPicture(Picture picture);

    void modifyPicture(Picture picture);

    void removePicture(int id) throws PictureNotFoundException ;
}
