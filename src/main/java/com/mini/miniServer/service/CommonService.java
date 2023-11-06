package com.mini.miniServer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.miniServer.domain.Common;
import com.mini.miniServer.dto.request.SaveCommonReq;
import com.mini.miniServer.exception.DuplicateException;
import com.mini.miniServer.repository.CommonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonService {

	private final CommonRepository commonRepository;

	@Transactional
	public Common save(Common commonReq) {
		String username = commonReq.getUsername();
		int i = commonRepository.countByUsername(username);
		if (i != 0) {
			throw new DuplicateException("username이");
		}
		Common common = commonRepository.save(commonReq);
		
		return common;
	}

}
