package com.mini.miniServer.dto.request;

import lombok.Data;

@Data
public class SaveCommonReq {
 
	private String username; 
    private String password; 
    private String email;
	
}
