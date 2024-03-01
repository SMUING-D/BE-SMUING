package dev.umc.smuing.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class PostImageDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("originName")
    private String originName;

    @JsonProperty("postImagePath")
    private String postImagePath;

    // Constructors, Getters, and Setters
}
