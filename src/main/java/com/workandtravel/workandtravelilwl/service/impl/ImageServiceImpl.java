package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.Image;
import com.workandtravel.workandtravelilwl.repository.ImageRepository;
import com.workandtravel.workandtravelilwl.service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нету Объекта с таким id: " + id));
    }

    @Override
    public void createImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void createImages(List<Image> images) {
        imageRepository.saveAll(images);
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.deleteById(id);
    }
}
