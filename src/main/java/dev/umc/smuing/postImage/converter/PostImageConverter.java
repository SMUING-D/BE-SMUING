package dev.umc.smuing.postImage.converter;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.dto.PostRequestDto;
import dev.umc.smuing.postImage.PostImage;
import org.springframework.web.multipart.MultipartFile;

public class PostImageConverter {

    public static PostImage toPostImage(Post post, MultipartFile file, String pictureUrl) {
        return PostImage.builder()
                .imageType(file.getContentType())
                .postImagePath(pictureUrl)
                .post(post)
                .originName(file.getOriginalFilename())
                .dbName(file.getName())
                .build();
    }
}
