package com.gdn.oxford.auth.webmodel.request;

import com.gdn.oxford.auth.validation.annotation.user.UserIdMustExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteStaffCommandWebRequest {

  @UserIdMustExists
  private String id;
}
