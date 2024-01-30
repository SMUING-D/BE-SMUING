package dev.umc.smuing.post.service;

import dev.umc.smuing.post.dto.PostResponseDto;

import java.util.List;

public interface GetMyPageService {


    PostResponseDto.PageListDto getMyPage(Long cursor, Long userId);

    PostResponseDto.PageListDto getLikePage(Long cursor, Long userId);
}
