package dev.umc.smuing.global.apiPayload.exception;

import dev.umc.smuing.global.apiPayload.code.BaseErrorCode;

public class S3Exception extends GeneralException{
    public S3Exception(BaseErrorCode code) {
        super(code);
    }
}
