package com.mini.miniServer.exception;

public class SelectFileException extends CommonException{
    public SelectFileException() {
        this.code = "-11";
        this.msg = "업로드할 파일을 선택해주세요.";
    }
}
