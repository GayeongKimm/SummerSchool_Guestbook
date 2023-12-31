package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.service.GuestbookService;

// /guestbook
@RequestMapping("/guestbook")
@RestController //JSON
@RequiredArgsConstructor
@Slf4j
public class GuestbookController {
    // C POSST :
    private final GuestbookService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody GuestbookDTO dto
    ){
        log.info("———— DTO : {}", dto);
        service.register(dto);
    }
    // R GET : /{gno}, GET : /list
    @GetMapping("/list")
    public PageResultDTO list(PageRequestDTO dto){
        log.info("..........list : {}", dto);
        return service.getList(dto);
    }


    //localhost:8080/guestbook/303
    @GetMapping("/{gno}")
    public GuestbookDTO read(
            @PathVariable("gno") Long gno
    ){
        log.info("------------------ gno : " + gno);
        return service.read(gno);
    }

    // U PUT :
    @PutMapping("")
    public ResponseEntity modify(
            @RequestBody GuestbookDTO dto
    ){
        log.info("............. DTO : {}",dto);
        service.modify(dto);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("success");
    }

    // D DELETE : /{gno}
    @DeleteMapping("/{gno}")
    public void remove(
            @PathVariable("gno") Long gno
    ){
        service.remove(gno);
    }


}
