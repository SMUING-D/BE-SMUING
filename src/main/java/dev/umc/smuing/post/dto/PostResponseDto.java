package dev.umc.smuing.post.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PageDto {
        private Long postId;
        private String title;
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
