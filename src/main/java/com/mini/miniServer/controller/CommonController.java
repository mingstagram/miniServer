package com.mini.miniServer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.miniServer.domain.Common;
import com.mini.miniServer.dto.DefaultResponse;
import com.mini.miniServer.dto.request.SaveCommonReq;
import com.mini.miniServer.service.CommonService;
 
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/common/api/")
@RequiredArgsConstructor
public class CommonController {
 
	private final CommonService commonService;
	
	@PostMapping("/save")
	public DefaultResponse saveCommon(@RequestBody Common common) {  
		return new DefaultResponse(commonService.save(common));
	}
	
}
