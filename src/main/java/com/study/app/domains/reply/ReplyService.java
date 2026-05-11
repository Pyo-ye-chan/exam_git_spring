package com.study.app.domains.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyDAO dao;

    public int insert(ReplyDTO dto) {
        return dao.insert(dto);
    }

    public List<ReplyDTO> selectAll(Long parent_seq) {
        return dao.selectAll(parent_seq);
    }

    public int delete(Long seq) {
        return dao.delete(seq);
    }

    public int update(ReplyDTO dto) {
        return dao.update(dto);
    }
}
