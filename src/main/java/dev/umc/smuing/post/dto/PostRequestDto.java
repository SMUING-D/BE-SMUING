package dev.umc.smuing.post.dto;

import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.global.Enum.PostType;
import dev.umc.smuing.postImage.PostImage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class PostRequestDto {

    @Getter
    public static class PostSaveDto {
        private String title;
        private String content;
        private CollegeType college;
        private PostType type;
        private LocalDateTime dueDate;
        private Integer memberCount;
        private String startDate;
    }


    @Getter
    public static class PostUpdateDto {
        private String title;
        private String content;
        private CollegeType college;
        private PostType type;
        private List<PostImage> postImageList;
        private String dueDate;
        private Integer memberCount;
        private String startDate;


    }
}
