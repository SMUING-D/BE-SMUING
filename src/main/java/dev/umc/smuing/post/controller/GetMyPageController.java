package dev.umc.smuing.post.controller;

import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.global.token.ExtractUserId;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.post.service.GetMyPageService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class GetMyPageController {

    private final GetMyPageService getMyPageService;

    @GetMapping("/myPage")
    @Parameter(name = "userId", hidden = true)
    public BaseResponse<?> getMyPage(@ExtractUserId Long userId, @RequestParam(name = "cursor") Long cursor, @RequestParam(name = "take") Integer take) {
        PostResponseDto.PageListDto pageDtoList = getMyPageService.getMyPage(cursor, take, userId);
        return BaseResponse.onSuccess(pageDtoList);
    }

    @GetMapping("/likes")
    @Parameter(name = "userId", hidden = true)
    public BaseResponse<?> getLikePage(@RequestParam(name = "cursor") Long cursor, @RequestParam(name = "take") Integer take, @ExtractUserId Long userId) {
        PostResponseDto.PageListDto pageDtoList = getMyPageService.getLikePage(cursor, take, userId);
        return BaseResponse.onSuccess(pageDtoList);
    }
}
