package dev.umc.smuing.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class CategoryDto {
    @JsonProperty("posts")
    private List<PostDto> posts;

    // Constructors, Getters, and Setters
}
