package com.gdn.oxford.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class ReactiveConfiguration {

  @Bean
  public Scheduler scheduler() {
    return Schedulers.elastic();
  }
}
