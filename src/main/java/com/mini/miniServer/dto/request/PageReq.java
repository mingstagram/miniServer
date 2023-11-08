package com.mini.miniServer.dto.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageReq {

    protected LocalDateTime startDate = LocalDateTime.of(2000, 1, 1, 0, 0);    // 시작일
    protected LocalDateTime endDate = LocalDateTime.now();        // 종료일
    protected String keyword = "";                // 검색어
    protected int limit = 10;                    // 페이지당 로우 수
    protected int offset;                    // 0번부터시작, (pageNum-1)*offset
    protected int pageNum = 1;                // 페이지번호

    public int getOffset() {
        return this.limit * (this.pageNum - 1);
    }

    public void convertEndDate() {
        this.endDate = endDate.plusDays(1);
    }
}