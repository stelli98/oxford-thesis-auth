package com.gdn.oxford.auth.controller;

import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

  private final CommandExecutor executor;

  private final Scheduler scheduler;

  public AuthController(CommandExecutor executor, Scheduler scheduler) {
    this.executor = executor;
    this.scheduler = scheduler;
  }

  @PostMapping(path = "/login")
  public Mono<Response> login() {
    return Mono.empty();
  }

  @DeleteMapping(path = "/logout")
  public Mono<Response> logout (){
    return Mono.empty();
  }
}
