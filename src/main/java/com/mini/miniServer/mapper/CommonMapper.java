package com.mini.miniServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;  

import com.mini.miniServer.domain.Common;

@Mapper 
public interface CommonMapper {

	@Insert("INSERT INTO `mini`.`common` (`email`, `password`, `username`) VALUES (#{email}, #{password}, #{username});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveCommon(Common common);
	
	List<Common> findAllCommon();
}
