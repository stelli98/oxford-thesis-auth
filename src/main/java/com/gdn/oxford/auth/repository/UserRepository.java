package com.gdn.oxford.auth.repository;

import com.gdn.oxford.auth.model.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserRepository extends ReactiveMongoRepository <User, String> {
  Flux<User> findAllBySupervisorId(String supervisorId);
}
