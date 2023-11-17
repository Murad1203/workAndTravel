package com.workandtravel.workandtravelilwl.сontroller;

import com.workandtravel.workandtravelilwl.model.Feedback;
import com.workandtravel.workandtravelilwl.model.Image;
import com.workandtravel.workandtravelilwl.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getFeedBacks() {
        return ResponseEntity.ok(feedBackService.getAllFeedbacks());
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedBack(@PathVariable Long id) {
        return ResponseEntity.ok(feedBackService.getFeedbackById(id));
    }

    @PostMapping("/feedback/create")
    public ResponseEntity<String> createFeedBack(
            @RequestPart("personAvatar") MultipartFile personAvatar,
            @RequestPart("reviewPhotos") List<MultipartFile> reviewPhotos,
            @RequestBody Feedback feedback) throws IOException {

        String personalAvatar = uploadFile(personAvatar);
        List<Image> images = new ArrayList<>();

        for (MultipartFile reviewPhoto : reviewPhotos) {
            Image image = new Image();
            image.setPath(uploadFile(reviewPhoto));
            System.out.println(image.getPath());
            images.add(image);
        }

        System.out.println(images);

        feedback.setAvatarPath(personalAvatar);
        feedback.setImages(images);
        return ResponseEntity.ok("Успешно сохранен");
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

    @DeleteMapping("/feedback/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedBackService.deleteFeedbackById(id);
        return ResponseEntity.ok("Успешно удален");
    }



}
