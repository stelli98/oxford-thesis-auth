package com.gdn.oxford.auth.commandimpl.user;

import com.gdn.oxford.auth.command.user.GetAllStaffBySupervisorIdCommand;
import com.gdn.oxford.auth.model.document.User;
import com.gdn.oxford.auth.repository.UserRepository;
import com.gdn.oxford.auth.webmodel.request.GetAllStaffBySupervisorIdWebRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
public class GetAllStaffBySupervisorIdCommandImpl implements GetAllStaffBySupervisorIdCommand {

  private final UserRepository userRepository;

  public GetAllStaffBySupervisorIdCommandImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<List<StaffWebResponse>> execute(GetAllStaffBySupervisorIdWebRequest request) {
    return Flux.defer(() -> getAllStaffBySupervisorId(request.getSupervisorId()))
        .map(user -> toGetAllStaffBySupervisorIdWebResponse(user))
        .collectList();
  }

  private Flux<User> getAllStaffBySupervisorId(String supervisorId) {
    return userRepository.findAllBySupervisorId(supervisorId);
  }

  private StaffWebResponse toGetAllStaffBySupervisorIdWebResponse(User user) {
    return StaffWebResponse.builder()
        .id(user.getId())
        .role(user.getRole())
        .email(user.getEmail())
        .build();
  }
}
