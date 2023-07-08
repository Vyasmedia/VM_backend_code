package com.vm.Vyas_Media.Service;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.vm.Vyas_Media.Entity.ImageUtil;
import com.vm.Vyas_Media.Entity.Image;
import com.vm.Vyas_Media.Repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
    private ImageRepository imageRepo;
	
	public Image uploadImage(MultipartFile file) throws IOException {
		Image pImage = new Image();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
		return imageRepo.save(pImage);
	}
	
	public byte[] downloadImage(String fileName){
        Optional<Image> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}