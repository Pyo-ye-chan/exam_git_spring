package com.study.app.domains.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> list(Long cpage) {
    	
		int totalCount = boardService.totalCount();
		
		System.out.println("페이지: " + cpage);
		
		Long startNum = cpage * 10-9;
		Long endNum = cpage * 10;

		
		List<BoardDTO> list = boardService.getBoardList(startNum, endNum);
		
		Map<String, Object> resp = new HashMap<>();
		
		resp.put("list", list);
		resp.put("totalCount", totalCount);
		
		System.out.println(list.size());
		
		return ResponseEntity.ok(resp);
		
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
