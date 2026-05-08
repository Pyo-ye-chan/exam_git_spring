package com.study.app.domains.members;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController {

	@GetMapping("/idCk/{id}")
	public ResponseEntity<Boolean> idCk(@PathVariable("id") String id) {
		// ID 중복 체크 로직 (추후 Service와 Repository를 연동하여 구현)
		// true: 사용 가능, false: 중복 또는 사용 불가
		boolean isAvailable = true; 
		return ResponseEntity.ok(isAvailable);
	}

}
