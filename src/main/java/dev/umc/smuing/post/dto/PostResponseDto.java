package dev.umc.smuing.post.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.global.Enum.PostType;
import dev.umc.smuing.postImage.PostImage;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import dev.umc.smuing.user.dto.UserResponseDto.UserDto;

import javax.xml.stream.events.Comment;

public class PostResponseDto {


    @Getter
    @Builder
    public static class getAllMainPost {
        @JsonProperty("popularPosts")
        private List<PopularPostDto> popularPosts;

        @JsonProperty("categories")
        private Map<String, CategoryDto> categories;

    }

    // PostDetailDto.java

    @Builder
    @Getter
    public static class PostDetailDto {

        private PostTypeDto.StudyDto study;
        private PostTypeDto.JobDto job;
    }


//    @Builder
//    @Getter
//    public static class PostCollegeDto {
//        private
//
//    }


    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PageDto {
        private Long postId;
        private String title;
        private Integer viewCount;
        private Integer likes;
        private PostType postType;
        private LocalDateTime date;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PageListDto {
        private List<PageDto> pageDtos;
        private Long nextCursor;
        private Boolean isLast;
    }

}
