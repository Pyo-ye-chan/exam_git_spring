package com.study.app.domains.reply;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAO {

    @Autowired
    private SqlSessionTemplate sql;

    public int insert(ReplyDTO dto) {
        return sql.insert("Reply.insert", dto);
    }

    public List<ReplyDTO> selectAll(Long parent_seq) {
        return sql.selectList("Reply.selectAll", parent_seq);
    }

    public int delete(Long seq) {
        return sql.delete("Reply.delete", seq);
    }

    public int update(ReplyDTO dto) {
        return sql.update("Reply.update", dto);
    }
}
