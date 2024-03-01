package dev.umc.smuing.post.controller;

import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.post.service.GetMyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class GetMyPageController {

    private final GetMyPageService getMyPageService;

    @GetMapping("/{userId}/myPage")
    public BaseResponse<?> getMyPage(@RequestParam(name = "cursor") Long cursor, @RequestParam(name = "take") Integer take, @PathVariable Long userId) {
        PostResponseDto.PageListDto pageDtoList = getMyPageService.getMyPage(cursor, take, userId);
        return BaseResponse.onSuccess(pageDtoList);
    }

    @GetMapping("/{userId}/likes")
    public BaseResponse<?> getLikePage(@RequestParam(name = "cursor") Long cursor, @RequestParam(name = "take") Integer take, @PathVariable Long userId) {
        PostResponseDto.PageListDto pageDtoList = getMyPageService.getLikePage(cursor, take, userId);
        return BaseResponse.onSuccess(pageDtoList);
    }
}
