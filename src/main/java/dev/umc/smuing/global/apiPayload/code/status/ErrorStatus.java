package dev.umc.smuing.global.apiPayload.code.status;


import dev.umc.smuing.global.apiPayload.code.BaseErrorCode;
import dev.umc.smuing.global.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // User 관련
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "존재 하지 않는 사용자 입니다."),

    // Post 관련
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST_001", "존재 하지 않는 게시물 입니다."),

    // Comment 관련
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT_001", "존재 하지 않는 댓글 입니다."),
    COMMENT_ALREADY_DELETE(HttpStatus.BAD_REQUEST, "COMMENT_002", "이미 삭제된 댓글 입니다."),
    COMMENTCOMMENT_ALREADY_HAS(HttpStatus.BAD_REQUEST, "COMMENT_003", "대댓글의 대댓글은 작성이 불가능 합니다."),

    // CommentLike 관련
    COMMENT_LIKE_EXIST(HttpStatus.BAD_REQUEST, "COMMENT_LIKE_001", "이미 해당하는 좋아요가 존재합니다."),
    COMMENT_LIKE_NOT_FOUND(HttpStatus.BAD_REQUEST, "COMMENT_LIKE_002", "이미 해당하는 좋아요가 존재하지 않습니다."),

    // CommentReport 관련
    COMMENT_REPORT_EXIST(HttpStatus.BAD_REQUEST, "COMMENT_REPORT_001", "이미 해당하는 신고가 존재합니다."),

    //S3 관련
    S3_OBJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "S3_001", "이미지가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder().message(message).code(code).isSuccess(false).build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
