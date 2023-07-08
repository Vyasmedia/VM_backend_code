package com.vm.Vyas_Media.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vm.Vyas_Media.Entity.FileModel;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public FileModel uploadvideo(String path, MultipartFile file) throws IOException {
		FileModel fileModel= new FileModel();
		String filename=file.getOriginalFilename();
		
		String randomId = UUID.randomUUID().toString();
		String finalname=randomId.concat(filename).substring(filename.indexOf("."));
		
		String filepath=path + File.separator+finalname;
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		Files.copy(file.getInputStream(), Paths.get(filepath));
		fileModel.setVideoFileName(finalname);
		return fileModel;
	}

	@Override
	public InputStream getvideofile(String path, String fileName, int id) throws FileNotFoundException {
	String fullpath=path + File.separator+fileName;
	InputStream inputstream= new FileInputStream(fullpath);
	return inputstream;
	}

}
