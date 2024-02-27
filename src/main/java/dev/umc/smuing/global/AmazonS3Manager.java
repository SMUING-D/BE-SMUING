package dev.umc.smuing.global;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.S3Exception;
import dev.umc.smuing.global.config.AmazonConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Manager {
    private final AmazonS3 amazonS3;
    private final AmazonConfig amazonConfig;
    private final UuidRepository uuidRepository;

    public String uploadFile(String keyName, MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        try {
            amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName, file.getInputStream(), metadata));
        } catch (IOException e) {
            log.error("error at AmazonS3Manager uploadFile : {}", (Object) e.getStackTrace());
        }

        return amazonS3.getUrl(amazonConfig.getBucket(), keyName).toString();
    }

    public void deleteFile(String keyName) throws S3Exception {
        try {
            String modifiedKeyName = modifyDeleteKeyName(keyName);
            System.out.println(modifiedKeyName);
            if (amazonS3.doesObjectExist(amazonConfig.getBucket(), modifiedKeyName)) {
                amazonS3.deleteObject(amazonConfig.getBucket(), modifiedKeyName);
            } else {
                throw new IOException();
            }
        } catch (Exception e) {
            throw new S3Exception(ErrorStatus.S3_OBJECT_NOT_FOUND);
        }
    }

    private String modifyDeleteKeyName(String keyName) {
        return keyName.split("/")[3] + '/' + keyName.split("/")[4];
    }


    public String generatePostKeyName(Uuid uuid, String filename) {
        return amazonConfig.getPostPath() + '/' + uuid.getUuid() + "_" + filename;
    }
}
