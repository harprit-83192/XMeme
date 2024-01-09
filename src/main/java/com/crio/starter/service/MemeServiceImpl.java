package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.repository.MemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService{
    private final MemesRepository memesRepository;

    @Autowired
    public MemeServiceImpl(MemesRepository memesRepository){
        this.memesRepository = memesRepository;
    }

    public MemeEntity getMemeById(String id){
        return memesRepository.findById(id).orElse(null);
    }

    public List<MemeEntity> getMemes(){
        return memesRepository.findTop100Memes();
    }

    public String postMeme(MemeEntity meme){
        MemeEntity saveMeme = memesRepository.save(meme);
        return saveMeme.getId();
    }
}
