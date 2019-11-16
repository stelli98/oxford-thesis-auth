package com.gdn.oxford.auth.commandimpl.user;

import com.gdn.oxford.auth.command.user.CreateStaffCommand;
import com.gdn.oxford.auth.model.document.User;
import com.gdn.oxford.auth.repository.UserRepository;
import com.gdn.oxford.auth.webmodel.request.CreateStaffCommandRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateStaffCommandImpl implements CreateStaffCommand {

  private final UserRepository userRepository;

  public CreateStaffCommandImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<StaffWebResponse> execute(CreateStaffCommandRequest request) {
    return Mono.fromSupplier(() -> constructStaff(request))
        .flatMap(s -> userRepository.save(s))
        .map(user -> toCreateStaffWebResponse(user));
  }

  private User constructStaff(CreateStaffCommandRequest request) {
    return User.builder()
        .encodedPassword(request.getEncodedPassword())
        .email(request.getEmail())
        .role(request.getRole())
        .supervisorId(request.getSupervisorId())
        .build();
  }

  private StaffWebResponse toCreateStaffWebResponse(User user) {
    return StaffWebResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .role(user.getRole())
        .build();
  }
}
