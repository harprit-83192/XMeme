package com.crio.starter.controller;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memes")
public class MemesController {

    private final MemeService memeService;

    @Autowired
    public MemesController(MemeService memeService){
        this.memeService = memeService;
    }
    
    @GetMapping
    public ResponseEntity<List<MemeEntity>> getMemes(){
        List<MemeEntity> memes = memeService.getMemes();
        return ResponseEntity.ok(memes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemeEntity> getMemeById(@PathVariable String id){
        MemeEntity meme = memeService.getMemeById(id);
        if(meme != null){
            return ResponseEntity.ok(meme);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postMeme(@RequestBody MemeEntity meme){
        try{
            String id = memeService.postMeme(meme);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
