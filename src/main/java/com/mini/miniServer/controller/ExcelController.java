package com.mini.miniServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mini.miniServer.domain.Common;
import com.mini.miniServer.dto.DefaultResponse;
import com.mini.miniServer.dto.request.FindCommonListReq;
import com.mini.miniServer.dto.response.PageRes;
import com.mini.miniServer.exception.ExcelFailedException;
import com.mini.miniServer.exception.SelectFileException;
import com.mini.miniServer.service.CommonService;
import com.mini.miniServer.service.ExcelService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/excel/api/")
@RequiredArgsConstructor
public class ExcelController {
	
	private final CommonService commonService;
	private final ExcelService excelService;

	@GetMapping("/download")
	public DefaultResponse excelDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageRes<Common> commonData = commonService.findAll();  
		excelService.reqExcelDownload(request, response, commonData);
		return new DefaultResponse();
	}
	
	@PostMapping("/upload")
	public DefaultResponse excelUpload(@RequestParam("file") MultipartFile file) {
	
		if(!file.isEmpty()) {
			try {
				excelService.processExcelFile(file);
				return new DefaultResponse();
			} catch (Exception e) {
				throw new ExcelFailedException();
			}
			 
		} else {
			throw new SelectFileException();
		} 
	}
	
}
