package com.study.app.domains.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService service;

    @PostMapping
    public int insert(@RequestBody ReplyDTO dto) {
        return service.insert(dto);
    }

    @GetMapping("/{parent_seq}")
    public List<ReplyDTO> selectAll(@PathVariable("parent_seq") Long parent_seq) {
        return service.selectAll(parent_seq);
    }

    @DeleteMapping("/{seq}")
    public int delete(@PathVariable("seq") Long seq) {
        return service.delete(seq);
    }

    @PutMapping
    public int update(@RequestBody ReplyDTO dto) {
        return service.update(dto);
    }
}
