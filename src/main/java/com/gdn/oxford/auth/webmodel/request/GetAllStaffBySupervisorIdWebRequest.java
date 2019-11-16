package com.gdn.oxford.auth.webmodel.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllStaffBySupervisorIdWebRequest {

  private String supervisorId;
}
