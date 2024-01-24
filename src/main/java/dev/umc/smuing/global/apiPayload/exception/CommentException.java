package dev.umc.smuing.global.apiPayload.exception;

import dev.umc.smuing.global.apiPayload.code.BaseErrorCode;

public class CommentException extends GeneralException{
    public CommentException(BaseErrorCode code) {
        super(code);
    }
}
