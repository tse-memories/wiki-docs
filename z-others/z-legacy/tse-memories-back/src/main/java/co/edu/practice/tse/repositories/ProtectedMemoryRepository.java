package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.ProtectedMemory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtectedMemoryRepository extends CrudRepository<ProtectedMemory, String> {
    List<ProtectedMemory> findAllByCreatorId(String id);
    List<ProtectedMemory> findAllByAuthorizedEmailList(String email);

}