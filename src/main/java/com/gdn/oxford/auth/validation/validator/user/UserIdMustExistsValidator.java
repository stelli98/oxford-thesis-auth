package com.gdn.oxford.auth.validation.validator.user;

import com.gdn.oxford.auth.repository.UserRepository;
import com.gdn.oxford.auth.validation.annotation.user.UserIdMustExists;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UserIdMustExistsValidator implements ConstraintValidator<UserIdMustExists, String> {
  private final UserRepository userRepository;

  public UserIdMustExistsValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(id)
        .filter(cs -> !StringUtils.isEmpty(id))
        .map(this::isMemberIdExists)
        .orElse(true);
  }

  private boolean isMemberIdExists(String id) {
    return Optional.of(userRepository.existsById(id))
        .map(booleanMono -> booleanMono.block())
        .orElse(false);
  }
}
