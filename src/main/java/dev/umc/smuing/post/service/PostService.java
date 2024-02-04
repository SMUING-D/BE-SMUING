package dev.umc.smuing.post.service;

import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.post.dto.PostRequestDto;
import dev.umc.smuing.post.dto.PostResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface PostService {

    void postSave(PostRequestDto.PostSaveDto postSaveDto);
    void postUpdate(PostRequestDto.PostUpdateDto postUpdateDto, Long id);
    void postDelete(Long postId);

    PostResponseDto.getAllMainPost getAllMainPost();

    @Transactional(readOnly = true)
    PostResponseDto getAllPostListByCollege(CollegeType collegeType);


    @Transactional(readOnly = true)
    PostResponseDto.PostDetailDto getPostById(Long postId);


    void postUpdate(PostRequestDto.PostSaveDto postSaveDto);
}
