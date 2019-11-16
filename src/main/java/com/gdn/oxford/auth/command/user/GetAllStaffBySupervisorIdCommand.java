package com.gdn.oxford.auth.command.user;

import com.blibli.oss.command.Command;
import com.gdn.oxford.auth.webmodel.request.GetAllStaffBySupervisorIdWebRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;

import java.util.List;

public interface GetAllStaffBySupervisorIdCommand extends Command<GetAllStaffBySupervisorIdWebRequest, List<StaffWebResponse>> {}
