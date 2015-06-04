package com.iwinner.belk.hrportal.service;

import java.lang.reflect.InvocationTargetException;



import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.iwinner.belk.hrportal.dao.StartUpDaoIF;
import com.iwinner.belk.hrportal.dto.AuditDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.AuditForm;
import com.iwinner.belk.hrportal.helper.DaoFactory;

@Service
public class StartUpServiceImpl implements StartUpServiceIF {
	private static Logger LOGGER = Logger.getLogger(StartUpServiceImpl.class);
	private StartUpDaoIF startUpDaoIF = null;

	public void insertAuditLog(AuditForm auditForm) throws ServiceException {
		LOGGER.info("insertAuditLog is started auditForm=["+auditForm+"]");
		AuditDTO auditDTO = new AuditDTO();
		try {
			BeanUtils.copyProperties(auditDTO, auditForm);
			startUpDaoIF = DaoFactory.startUpDaoFactory();
			try {
				startUpDaoIF.insertAudit(auditDTO);
				LOGGER.debug("transfed to DB layer ");
			} catch (DaoException e) {
				LOGGER.error("Error at the "+e.getMessage());
				e.printStackTrace();
				throw new ServiceException(e);
			}
		} catch (IllegalAccessException e) {
			LOGGER.error("Error at the "+e.getMessage()+"BeanUtils is conversion not working");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			LOGGER.error("Error at the "+e.getMessage()+"BeanUtils is conversion not working ");
		}
		LOGGER.info("insertAuditLog is ended auditForm=["+auditDTO+"]");
	}
}
