package com.workandtravel.workandtravelilwl.service;

import com.workandtravel.workandtravelilwl.model.Advice;
import com.workandtravel.workandtravelilwl.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    Image getImageById(Long id);
    void createImage(Image image);
    void createImages(List<Image> images);
    void deleteImageById(Long id);
}
