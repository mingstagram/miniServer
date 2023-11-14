package com.mini.miniServer.service;

import java.util.List;

import org.springframework.stereotype.Service; 

import com.mini.miniServer.domain.Common;
import com.mini.miniServer.dto.request.FindCommonListReq;
import com.mini.miniServer.dto.response.PageRes;
import com.mini.miniServer.mapper.CommonMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonService {
 
	private final CommonMapper commonMapper;
 
	public int save(Common commonReq) {
		  
		int common = commonMapper.saveCommon(commonReq); 
		return common;
	}
	
	// 페이지 처리 
	public PageRes<Common> findAll(FindCommonListReq findCommonListReq){  
		List<Common> commonList = commonMapper.findAllCommon(findCommonListReq.getUsername());
		PageRes<Common> commonListCount = commonMapper.findAllCommonCount(findCommonListReq.getUsername()); 
		 
		commonListCount.parse(findCommonListReq);
		commonListCount.setList(commonList);
		
		return commonListCount;
	}

}
