package com.mini.miniServer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Common {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private Integer id; // 시퀀스, auto_increment
	
	@Column(nullable = true, length = 100, unique = true) // not null varchar(30)
	private String username; // 아이디
	
	@Column(nullable = true, length = 100) // 길이를 넉넉하게 주는이유 - 나중에 해쉬로 변경(비밀번호 암호화)
	private String password; 
	
	@Column(nullable = true, length = 50) 
	private String email; 
	
}
