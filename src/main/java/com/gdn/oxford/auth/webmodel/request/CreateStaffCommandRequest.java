package com.gdn.oxford.auth.webmodel.request;

import com.gdn.oxford.auth.model.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStaffCommandRequest {

  private String encodedPassword;

  private String email;

  private Role role;

  private String supervisorId;
}
