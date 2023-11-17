package com.workandtravel.workandtravelilwl.сontroller;


import com.workandtravel.workandtravelilwl.model.Favor;
import com.workandtravel.workandtravelilwl.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ServiceController {

    @Autowired
    @Qualifier("FavorService")
    private FavorService favorService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/services")
    public ResponseEntity<List<Favor>> getAllServices() {
        return ResponseEntity.ok(favorService.getAllServices());
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<Favor> getService(@PathVariable Long id) {
        return ResponseEntity.ok(favorService.getServiceById(id));
    }

    @PostMapping("/service/create")
    public ResponseEntity<String> saveService(
            @RequestBody Favor favor,
            @RequestParam("file") MultipartFile file) {
        try {
            String res = uploadFile(file);
            favor.setIconPath(res);
            favorService.createService(favor);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Успешно создан");
    }

    @DeleteMapping("/service/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        favorService.deleteServiceById(id);
        return ResponseEntity.ok("Успещно удален");
    }

    @PutMapping("/service/update")
    public ResponseEntity<String> update(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestBody Favor favor) throws IOException {

        if (file != null && !file.isEmpty()) {
            String res = uploadFile(file);
            favor.setIconPath(res);
        }
        favorService.createService(favor);
        return ResponseEntity.ok("Объект успешно обновлен");
    }


    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "Выберите файл для загрузки.";
        }
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadPath + "/" + resultFileName));
        return resultFileName;
    }

}
