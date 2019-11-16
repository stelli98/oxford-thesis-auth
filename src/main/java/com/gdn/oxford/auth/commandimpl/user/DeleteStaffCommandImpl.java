package com.gdn.oxford.auth.commandimpl.user;

import com.gdn.oxford.auth.command.user.DeleteStaffCommand;
import com.gdn.oxford.auth.model.document.User;
import com.gdn.oxford.auth.repository.UserRepository;
import com.gdn.oxford.auth.webmodel.request.DeleteStaffCommandWebRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteStaffCommandImpl implements DeleteStaffCommand {

  private final UserRepository userRepository;

  public DeleteStaffCommandImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<Boolean> execute(DeleteStaffCommandWebRequest request) {
    return Mono.defer(() -> findUser(request.getId()))
        .flatMap(user -> deleteUser(user))
        .thenReturn(true);
  }

  private Mono<Void> deleteUser(User user) {
    return userRepository.delete(user);
  }

  private Mono<User> findUser(String id) {
    return userRepository.findById(id);
  }
}
