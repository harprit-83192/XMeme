package com.crio.starter.repository;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemesRepository extends MongoRepository<MemeEntity, String> {
    MemeEntity findByNameAndUrlAndCaption(String name, String url, String caption);
    
    // @Query(value = "{}", fields = "{_id: 0}", sort = "{id: -1}", count = 100)
    // List<MemeEntity> findTop100Memes();
    List<MemeEntity> findTop100ByOrderByIdDesc();
}
