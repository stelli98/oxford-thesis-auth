package com.gdn.oxford.auth.command.user;

import com.blibli.oss.command.Command;
import com.gdn.oxford.auth.webmodel.request.UpdateStaffCommandRequest;
import com.gdn.oxford.auth.webmodel.response.StaffWebResponse;

public interface UpdateStaffCommand extends Command<UpdateStaffCommandRequest, StaffWebResponse > {}
