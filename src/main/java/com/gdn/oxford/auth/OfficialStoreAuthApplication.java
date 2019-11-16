package com.gdn.oxford.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories("com.gdn.oxford.auth.repository")
public class OfficialStoreAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(OfficialStoreAuthApplication.class, args);
  }
}
