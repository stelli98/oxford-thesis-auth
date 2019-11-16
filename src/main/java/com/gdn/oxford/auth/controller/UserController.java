package com.gdn.oxford.auth.controller;

import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import com.gdn.oxford.auth.command.user.CreateStaffCommand;
import com.gdn.oxford.auth.command.user.DeleteStaffCommand;
import com.gdn.oxford.auth.command.user.GetAllStaffBySupervisorIdCommand;
import com.gdn.oxford.auth.command.user.UpdateStaffCommand;
import com.gdn.oxford.auth.model.document.User;
import com.gdn.oxford.auth.webmodel.request.CreateStaffCommandRequest;
import com.gdn.oxford.auth.webmodel.request.DeleteStaffCommandWebRequest;
import com.gdn.oxford.auth.webmodel.request.GetAllStaffBySupervisorIdWebRequest;
import com.gdn.oxford.auth.webmodel.request.UpdateStaffCommandRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
  private final CommandExecutor executor;

  private final Scheduler scheduler;

  public UserController(CommandExecutor executor, Scheduler scheduler) {
    this.executor = executor;
    this.scheduler = scheduler;
  }

  @PostMapping(path = "/staff")
  public Mono<Response<StaffWebResponse>> createStaff(@RequestBody User user) {

    CreateStaffCommandRequest request = CreateStaffCommandRequest.builder()
        .email(user.getEmail())
        .encodedPassword(user.getEncodedPassword())
        .role(user.getRole())
        .supervisorId(user.getSupervisorId())
        .build();

    return executor.execute(CreateStaffCommand.class, request).map(ResponseHelper::ok).subscribeOn(scheduler);
  }

//  @PutMapping(path = "/staff")
//  public Mono<Response<StaffWebResponse>> updateStaff(@RequestBody User user) {
//
//    UpdateStaffCommandRequest request = UpdateStaffCommandRequest.builder()
//        .id(user.getId())
//        .email(user.getEmail())
//        .encodedPassword(user.getEncodedPassword())
//        .build();
//
//    return executor.execute(UpdateStaffCommand.class, request).map(ResponseHelper::ok).subscribeOn(scheduler);
//  }

  @DeleteMapping(path = "/staff/{staffId}")
  public Mono<Response<Boolean>> deleteStaff(@PathVariable String staffId) {

    DeleteStaffCommandWebRequest request = DeleteStaffCommandWebRequest.builder()
        .id(staffId)
        .build();

    return executor.execute(DeleteStaffCommand.class, request).map(ResponseHelper::ok).subscribeOn(scheduler);
  }

 //getAllStaffBySupervisorId
 @GetMapping(path = "/{supervisorId}/staff")
 public Mono<Response<List<StaffWebResponse>>> getAllStaffBySupervisorId(@PathVariable String supervisorId) {

   GetAllStaffBySupervisorIdWebRequest request = GetAllStaffBySupervisorIdWebRequest.builder()
       .supervisorId(supervisorId)
       .build();

   return executor.execute(GetAllStaffBySupervisorIdCommand.class, request).map(ResponseHelper::ok).subscribeOn(scheduler);
 }


}
