package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.PublicMemory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicMemoryRepository extends MongoRepository<PublicMemory, String> {
    List<PublicMemory> findAllByCreatorId(String id);
    List<PublicMemory> findAll();
    List<PublicMemory> findAllByName(String name);
    List<PublicMemory> findAllByTagList(String tag);
}


