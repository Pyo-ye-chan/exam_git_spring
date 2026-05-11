package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private MembersService membersService;

	@GetMapping("/idCk/{id}")
	public ResponseEntity<Boolean> idCk(@PathVariable("id") String id) {
		boolean isAvailable = membersService.idCk(id); 
		return ResponseEntity.ok(isAvailable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MembersDTO> getMember(@PathVariable("id") String id){
		
		MembersDTO dto = membersService.getMember(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<Integer> signup(@RequestBody MembersDTO dto) {
		// 회원가입 로직 (추후 Service와 Repository를 연동하여 구현)
		//System.out.println("도착");
		//System.out.println(dto.getId()+":"+dto.getPw()+":"+dto.getName()+":"+dto.getEmail()+":"+dto.getZipcode()
		//+":"+dto.getAddress1()+":"+dto.getAddress2());
		int result = membersService.signup(dto);
		return ResponseEntity.ok(result);
	}

	@PutMapping
	public ResponseEntity<Integer> updateMember(@RequestBody MembersDTO dto) {
		int result = membersService.updateMember(dto);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteMember(@PathVariable("id") String id) {
		int result = membersService.deleteMember(id);
		return ResponseEntity.ok(result);
	}

}
