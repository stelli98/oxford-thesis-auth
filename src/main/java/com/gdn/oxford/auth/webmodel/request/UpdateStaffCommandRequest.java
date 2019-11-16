package com.gdn.oxford.auth.webmodel.request;

import com.gdn.oxford.auth.model.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffCommandRequest {

  private String email;

  private String encodedPassword;

  private String id;
}
