package com.gdn.oxford.auth.webmodel.response;

import com.gdn.oxford.auth.model.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class StaffWebResponse {

  private String id;

  private String email;

  private Role role;

  private String supervisorId;
}
