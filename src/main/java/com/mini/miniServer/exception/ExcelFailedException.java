package com.mini.miniServer.exception;

public class ExcelFailedException extends CommonException{
    public ExcelFailedException() {
        this.code = "-11";
        this.msg = "엑셀 업로드에 실패했습니다";
    }
}
