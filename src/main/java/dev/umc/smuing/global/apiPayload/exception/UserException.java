package dev.umc.smuing.global.apiPayload.exception;


import dev.umc.smuing.global.apiPayload.code.BaseErrorCode;

public class UserException extends GeneralException {

    public UserException(BaseErrorCode code) {
        super(code);
    }
}
