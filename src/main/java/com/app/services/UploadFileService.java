package com.app.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {
    private final String folder="src/main/resources/images//";

    public String saveImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            Files.write(path,bytes);
            return file.getOriginalFilename();
        }

        return "default.jpg";

    }

    public void deleteImage(String nombre){
        if (nombre == null){
            return;
        }
        if(!nombre.equals("default.jpg")){
            File file = new File(folder+nombre);
            file.delete();
        }
    }
}
