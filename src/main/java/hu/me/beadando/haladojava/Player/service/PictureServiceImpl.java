package hu.me.beadando.haladojava.Player.service;

import hu.me.beadando.haladojava.Player.exception.PictureNotFoundException;
import hu.me.beadando.haladojava.Player.model.Picture;
import hu.me.beadando.haladojava.Player.persist.PictureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{

    private PictureDAO pictureDAO;

    @Autowired
    public PictureServiceImpl(PictureDAO pictureDAO) { this.pictureDAO = pictureDAO; }

    @Override
    public Picture getPicture(int id) throws PictureNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return pictureDAO.getPicture(id);
    }

    @Override
    public List listPictures() {
        return pictureDAO.getAllPicture();
    }

    @Override
    public void createPicture(Picture picture){
        if (picture.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (pictureDAO.idUsed(picture.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        pictureDAO.insertPicture(picture);
    }

    @Override
    public void modifyPicture(Picture picture) {
        pictureDAO.updatePicture(picture);
    }

    @Override
    public void removePicture(int id)  throws PictureNotFoundException {
        if (!pictureDAO.idUsed(id)) {
            throw new InvalidParameterException("Picture does not exist");
        }
        pictureDAO.deletePicture(pictureDAO.getPicture(id));
    }
}
