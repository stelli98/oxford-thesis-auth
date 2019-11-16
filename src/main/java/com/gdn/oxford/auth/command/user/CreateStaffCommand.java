package com.gdn.oxford.auth.command.user;

import com.blibli.oss.command.Command;
import com.gdn.oxford.auth.webmodel.request.CreateStaffCommandRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;

public interface CreateStaffCommand extends Command<CreateStaffCommandRequest, StaffWebResponse> {}
