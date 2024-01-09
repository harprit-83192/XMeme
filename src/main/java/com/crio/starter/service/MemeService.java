package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import org.springframework.stereotype.Service;

@Service
public interface MemeService {
    public MemeEntity getMemeById(String id);
    public List<MemeEntity> getMemes();
    public String postMeme(MemeEntity meme);
}
