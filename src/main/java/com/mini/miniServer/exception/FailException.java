package com.mini.miniServer.exception;

public class FailException extends CommonException{
    public FailException(String msg) {
        this.code = "-3";
        this.msg = msg + " 이미 존재합니다.";this.msg = msg + " 관련된 데이터가 있어 실패했습니다.";
    }
}
