package mpa.service;

import mpa.domain.Item;
import mpa.repository.MRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    MRepository mongoRepository;

    @Override
    public Item findItem() {
        // first insert
        mongoRepository.insert(new Item("1003", "xidong"));

        // second query
        return mongoRepository.findById("1003").orElse(null);
    }
}
