package com.study.app.domains.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.app.domains.members.MembersDTO;
import com.study.app.utils.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Map<String,Object>> signin(@RequestBody MembersDTO dto) {
    System.out.println("도착");    
    System.out.println(dto.getId()+":"+dto.getPw());
    	boolean isValid = authService.login(dto);
        if (isValid) {
        		
            String token = jwtUtil.createToken(dto.getId());
            Map<String,Object> result = new HashMap<>();
            result.put("token", token);
			result.put("id", dto.getId());
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
