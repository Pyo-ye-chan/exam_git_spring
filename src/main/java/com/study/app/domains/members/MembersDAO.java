package com.study.app.domains.members;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int idCk(String id) {
		return mybatis.selectOne("Members.idCk",id);
	}
	public int signup(MembersDTO dto) {
		return mybatis.insert("Members.signup", dto);
	}
	public int login(MembersDTO dto) {
		return mybatis.selectOne("Members.login",dto);
	}
	public MembersDTO getMember(String id) {
		return mybatis.selectOne("Members.getMember",id);
	}
	public int deleteMember(String id) {
		return mybatis.delete("Members.deleteMember",id);
	}
	public int updateMember(MembersDTO dto) {
		return mybatis.update("Members.updateMember",dto);
	}
    
}
