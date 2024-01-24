package dev.umc.smuing.global.apiPayload.exception;


import dev.umc.smuing.global.apiPayload.code.BaseErrorCode;

public class PostException extends GeneralException {

    public PostException(BaseErrorCode code) {
        super(code);
    }
}
