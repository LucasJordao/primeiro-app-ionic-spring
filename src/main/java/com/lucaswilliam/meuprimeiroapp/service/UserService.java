package com.lucaswilliam.meuprimeiroapp.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.security.UserSS;

@Service
public class UserService {
	
	public static UserSS autheticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
	}
}
