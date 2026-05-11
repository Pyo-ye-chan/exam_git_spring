package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

    @Autowired
    private MembersDAO membersDAO;

    public boolean idCk(String id) {
        return membersDAO.idCk(id) == 0;
    }

    public int signup(MembersDTO dto) {
        return membersDAO.signup(dto);
    }
    public MembersDTO getMember (String id) {
    		return membersDAO.getMember(id);
    }

    public int deleteMember(String id) {
        return membersDAO.deleteMember(id);
    }

    public int updateMember(MembersDTO dto) {
        return membersDAO.updateMember(dto);
    }
}
