package com.iwinner.belk.hrportal.dao;

import com.iwinner.belk.hrportal.dto.AuditDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;

public interface StartUpDaoIF {
	public void insertAudit(AuditDTO auditDTO) throws DaoException;
}
