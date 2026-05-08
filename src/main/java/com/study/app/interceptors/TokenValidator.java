package com.study.app.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.study.app.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenValidator implements HandlerInterceptor {
	
	@Autowired
	private JWTUtil jwt;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		
		if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}
		
	    // 로그인 구현 전: 게시판 GET 요청 허용
	    if (request.getRequestURI().startsWith("/board")
	            && request.getMethod().equalsIgnoreCase("GET")) {
	        return true;
	    }

	    String authHeader = request.getHeader("Authorization");

	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
	    }

	    return true;
		
//		if(request.getRequestURI().equals("/signup/idcheck")) {
//		    return true;
//		}
//		
//		if(request.getRequestURI().equals("/signup")
//				&& request.getMethod().equalsIgnoreCase("POST")) {
//		    return true;
//		}
//
//		
//		if(request.getRequestURI().equals("/member") 
//				&& request.getMethod().equalsIgnoreCase("POST")) {
//			return true;
//			}
//		
//		
//		String authHeader = request.getHeader("Authorization");
//		System.out.println("authHeader: " + authHeader);
//		
//		
//		
//		if(authHeader != null && authHeader.startsWith("Bearer ")) {
//			String token = authHeader.substring(7);
//
//			System.out.println("token: " + token);
//			
//			
//			try {
//				String id = jwt.getSubject(token);
//				request.setAttribute("id", id);
//				return true;
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}

	}
}
