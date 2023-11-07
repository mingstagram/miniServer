package com.mini.miniServer.service;

import java.util.List;

import org.springframework.stereotype.Service; 

import com.mini.miniServer.domain.Common; 
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
	
	public List<Common> findAll(){
		List<Common> commonList = commonMapper.findAllCommon();
		return commonList;
	}

}
