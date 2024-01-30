package dev.umc.smuing.post.converter;

import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.postLike.PostLike;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static PostResponseDto.PageDto toMyPageDto(UserPost userPost) {
        Post post = userPost.getPost();
        return PostResponseDto.PageDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .date(post.getCreatedAt())
                .build();
    }

    public static PostResponseDto.PageListDto toMyPageListDto(Page<UserPost> userPosts) {
        Long nextCursor = userPosts.getContent().get(userPosts.getContent().size() - 1).getId();
        List<PostResponseDto.PageDto> pageDtos = userPosts.stream().map(PostConverter::toMyPageDto).toList();
        return PostResponseDto.PageListDto.builder()
                                .pageDtos(pageDtos)
                                .isLast(userPosts.isLast())
                                .nextCursor(nextCursor)
                                .build();
    }

    public static PostResponseDto.PageDto toLikePageDto(PostLike postLike) {
        Post post = postLike.getPost();
        return PostResponseDto.PageDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .date(post.getCreatedAt())
                .build();
    }

    public static PostResponseDto.PageListDto toLikePageListDto(Page<PostLike> postLikes) {
        Long nextCursor = postLikes.getContent().get(postLikes.getContent().size() - 1).getId();
        List<PostResponseDto.PageDto> pageDtos = postLikes.stream().map(PostConverter::toLikePageDto).toList();
        return PostResponseDto.PageListDto.builder()
                        .nextCursor(nextCursor)
                        .pageDtos(pageDtos)
                        .isLast(postLikes.isLast())
                        .build();
    }
}
