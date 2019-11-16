package com.gdn.oxford.auth.model.document;

import com.gdn.oxford.auth.model.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @NotBlank
  private String encodedPassword;

  @Id
  private String id;

  @NotBlank
  private String email;

  @NotBlank
  private Role role;

  @NotBlank
  private String supervisorId;
}
