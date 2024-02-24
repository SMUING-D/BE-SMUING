package dev.umc.smuing.post.converter;

import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.dto.PopularPostDto;
import dev.umc.smuing.post.dto.PostDto;
import dev.umc.smuing.post.dto.PostRequestDto;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.dto.UserResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dev.umc.smuing.user.converter.UserConverter.toUserDto;

public class PostConverter {

    public static Post toPost(PostRequestDto.PostSaveDto postSaveDto) {
        return Post.builder()
                .title(postSaveDto.getTitle())
                .content(postSaveDto.getContent())
                .memberCount(postSaveDto.getMemberCount()) // 예시로 현재 시간 설정
                .postType(postSaveDto.getType()) // 예시로 PostType 설정
                .dueDate(postSaveDto.getDueDate())
                .college(postSaveDto.getCollege()) // 예시로 CollegeType 설정
                .viewCount(0)
                .build();
    }
    public static PopularPostDto convertToPopularPostDto(Post post, User user, Integer likeCount, Boolean isLike){
        return PopularPostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .college(post.getCollege().toString())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                //.memberCount(Integer.parseInt(post.getMemberCount()))
                .memberCount(5) //임시
                .dueDate(String.valueOf(LocalTime.now()))
                .viewCount(Integer.parseInt(String.valueOf(post.getViewCount())))
                .userDto(toUserDto(user))
                .postLikeCount(likeCount)
                .isPostLike(isLike)
                .build();
    }

    public static PostDto convertToPostDto(Post post, User user, Integer likeCount, Boolean isLike) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .college(post.getCollege().toString())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                .memberCount(post.getMemberCount())
                .dueDate(post.getDueDate())
                .viewCount(post.getViewCount())
                .userDto(toUserDto(user))
                .postLikeCount(likeCount)
                .isPostLike(isLike)
                .build();
    }
    public static PostResponseDto.PageDto toMyPageDto(UserPost userPost) {
        Post post = userPost.getPost();
        return PostResponseDto.PageDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .date(post.getCreatedAt())
                .likes(post.getLikeSum())
                .viewCount(post.getViewCount())
                .postType(post.getPostType())
                .build();
    }

    public static PostResponseDto.PageListDto toMyPageListDto(Page<UserPost> userPosts) {
        List<PostResponseDto.PageDto> pageDtos = null;
        Long nextCursor = null;

        if (!userPosts.getContent().isEmpty()) {
            pageDtos = userPosts.stream().map((UserPost userPost) -> toMyPageDto(userPost)).toList();
            nextCursor = userPosts.getContent().get(userPosts.getContent().size() - 1).getId();
        }

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
                .likes(post.getLikeSum())
                .viewCount(post.getViewCount())
                .postType(post.getPostType())
                .build();
    }

    public static PostResponseDto.PageListDto toLikePageListDto(Page<PostLike> postLikes) {
        List<PostResponseDto.PageDto> pageDtos = null;
        Long nextCursor = null;

        if (!postLikes.getContent().isEmpty()) {
            pageDtos = postLikes.stream().map((PostLike postLike) -> toLikePageDto(postLike)).toList();
            nextCursor = postLikes.getContent().get(postLikes.getContent().size() - 1).getId();
        }


        return PostResponseDto.PageListDto.builder()
                        .nextCursor(nextCursor)
                        .pageDtos(pageDtos)
                        .isLast(postLikes.isLast())
                        .build();
    }
}
