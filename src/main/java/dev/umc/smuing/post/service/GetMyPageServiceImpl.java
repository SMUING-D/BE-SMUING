package dev.umc.smuing.post.service;

import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.mapping.repository.UserPostRepository;
import dev.umc.smuing.post.converter.PostConverter;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.postLike.repository.PostLikeRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMyPageServiceImpl implements GetMyPageService {
    private final UserRepository userRepository;
    private final UserPostRepository userPostRepository;
    private final PostLikeRepository postLikeRepository;
    private int pageSize = 5;
    @Override
    public PostResponseDto.PageListDto getMyPage(Long cursor, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        Page<UserPost> userPosts = userPostRepository.findByIdGreaterThanAndUserOrderByIdAsc(cursor, user, PageRequest.of(0, pageSize));

        return PostConverter.toMyPageListDto(userPosts);
    }

    @Override
    public PostResponseDto.PageListDto getLikePage(Long cursor, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));

        Page<PostLike> postLikes = postLikeRepository.findByIdGreaterThanAndUserOrderByIdAsc(cursor, user, PageRequest.of(0, pageSize));

        return PostConverter.toLikePageListDto(postLikes);
    }
}
