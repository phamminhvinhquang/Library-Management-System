// FileUploadService.java
package com.example.management_library_system.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public String uploadFile(MultipartFile multipartFile) throws IOException {
        // Tạo file tạm
        File file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }

        // Đổi tên file để tránh trùng lặp
        String fileName = UUID.randomUUID() + "_" + file.getName();

        // Upload lên S3 và set quyền Public Read để ai cũng xem được ảnh
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));

        // Xóa file tạm trên ổ cứng EC2
        file.delete();

        // Trả về URL của file trên S3
        return s3Client.getUrl(bucketName, fileName).toString();
    }
}