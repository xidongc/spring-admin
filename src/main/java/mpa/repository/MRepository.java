package mpa.repository;

import mpa.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MRepository extends MongoRepository<Item, String> {

}
