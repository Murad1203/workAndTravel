package com.workandtravel.workandtravelilwl.сontroller;

import com.workandtravel.workandtravelilwl.model.Travel;
import com.workandtravel.workandtravelilwl.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class TravelController {

    @Autowired
    private TravelService travelService;


    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/travels")
    public ResponseEntity<List<Travel>> getAllTravel() {
        return ResponseEntity.ok(travelService.getAllTravel());
    }

    @GetMapping("/travel/{id}")
    public ResponseEntity<Travel> getTravel(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.getTravelById(id));
    }

    @PostMapping("/travel/create")
    public ResponseEntity<String> createTravel(
            @RequestParam("file") MultipartFile file,
            @RequestBody Travel travel) throws IOException {
        travel.setPathImage(uploadFile(file));
        travelService.createTravel(travel);
        return ResponseEntity.ok("Успешно создан");
    }

    @PutMapping("/travel/update")
    public ResponseEntity<String> updateTravel(
            @RequestParam("file") MultipartFile file,
            @RequestBody Travel travel) throws IOException {
        travel.setPathImage(uploadFile(file));
        travelService.createTravel(travel);
        return ResponseEntity.ok("Успешно изменен");
    }

    @DeleteMapping("/travel/delete/{id}")
    public ResponseEntity<String> getAllTravel(@PathVariable Long id) {
        travelService.deleteTravelById(id);
        return ResponseEntity.ok("Успешно удален!");
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
