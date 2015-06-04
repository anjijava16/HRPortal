package com.iwinner.belk.hrportal.service;

import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.AuditForm;

public interface StartUpServiceIF {

	public void insertAuditLog(AuditForm auditForm) throws ServiceException;
}
