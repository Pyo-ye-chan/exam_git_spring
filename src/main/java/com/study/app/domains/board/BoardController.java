package com.study.app.domains.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/board/list")
public class BoardController {
	
	@Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardDTO>> list() {
    	List<BoardDTO> list = boardService.getBoardList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{seq}")
    public ResponseEntity<BoardDTO> get(@PathVariable String seq) {
    	
    	System.out.println("seq :" + seq);
        BoardDTO dto = boardService.getBoard(seq);
    	return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody BoardDTO board) {
        boardService.registerBoard(board);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{seq}")
    public ResponseEntity<Void> modify(@PathVariable String seq, @RequestBody BoardDTO board) {
        board.setSeq(seq);
        boardService.modifyBoard(board);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> remove(@PathVariable String seq) {
        boardService.removeBoard(seq);
        return ResponseEntity.ok().build();
    }
}
