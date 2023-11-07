package com.mini.miniServer.domain;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class Common { 
	private Integer id; // 시퀀스, auto_increment 
	private String username; // 아이디 
	private String password;  
	private String email; 
	
}
