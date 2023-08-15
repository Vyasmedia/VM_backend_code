package com.vm.Vyas_Media.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import com.vm.Vyas_Media.Entity.FileModel;

public interface FileService {

	FileModel uploadvideo(String path, MultipartFile file) throws IOException;

	InputStream getvideofile(String path, String fileName, int id) throws FileNotFoundException;

}
