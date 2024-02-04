package dev.umc.smuing.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostImageDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("originName")
    private String originName;

    @JsonProperty("postImagePath")
    private String postImagePath;

    // Constructors, Getters, and Setters
}
