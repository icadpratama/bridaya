package team.kasta.bridaya.service.impl;

import team.kasta.bridaya.model.common.Image;
import team.kasta.bridaya.repository.ImageRepository;
import team.kasta.bridaya.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }
}
