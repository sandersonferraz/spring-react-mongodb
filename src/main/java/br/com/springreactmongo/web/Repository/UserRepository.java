package br.com.springreactmongo.web.Repository;

import br.com.springreactmongo.web.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String> {
}
