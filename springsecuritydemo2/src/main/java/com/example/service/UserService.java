package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;

public record UserService(UserInfoRepository repository,
		                  PasswordEncoder passwordEncoder) {
	
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Thêm user thành công";
	}

}
