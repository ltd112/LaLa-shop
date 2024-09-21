package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.dto.ImageDto;
import com.dat.LaLa_shop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file, Long imageId);


}
