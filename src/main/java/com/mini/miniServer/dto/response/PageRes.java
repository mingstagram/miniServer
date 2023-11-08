package com.mini.miniServer.dto.response;

import java.util.List;

import com.mini.miniServer.dto.request.PageReq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRes<T> {
	private List<T> list;
	private int total;
	private Boolean isLast;
	private int lastPage;
	private int currentPage;

	public void parse(PageReq req) {
		this.currentPage = req.getPageNum();
		
		if(req.getLimit() != 0) {
			if (this.total % req.getLimit() == 0)
				this.lastPage = this.total / req.getLimit();
			else
				this.lastPage = this.total / req.getLimit() + 1;
		}else {
			if (this.total % 10 == 0)
				this.lastPage = this.total / 10;
			else
				this.lastPage = this.total / 10 + 1;
		}
		
		if(lastPage == currentPage) isLast = true;
		else isLast = false;
	}
}
