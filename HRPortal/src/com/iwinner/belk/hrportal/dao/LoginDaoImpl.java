package com.iwinner.belk.hrportal.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iwinner.belk.hrportal.dao.mapper.PasswordMapper;
import com.iwinner.belk.hrportal.dao.mapper.UserMapper;
import com.iwinner.belk.hrportal.dao.mapper.UserRowMapperCount;
import com.iwinner.belk.hrportal.dto.UserDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;
import com.iwinner.belk.hrportal.utils.DateUtils;

public class LoginDaoImpl implements LoginDaoIF {
	
	private static Logger LOGGER = Logger.getLogger(StartUpDaoImpl.class);

	private static DataSource dataSource=null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public boolean verifyCreds(String username, String password)
			throws DaoException {
		LOGGER.info("$$$verifyCreds() $$$$");
		boolean verifyCreds=false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int count=jdbcTemplate.queryForInt(HRPortalConstants.SELECT_USER_VERIFY,new Object[]{username,password});
			if(count==1){
				verifyCreds=true;
			}else{
				verifyCreds=false;
			}
		} catch (Exception e) {
			LOGGER.error("Error into the verifyCreds(String username, String password) "+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}
		return verifyCreds;
	}
	public UserDTO userInfo(String username) throws DaoException {
		UserDTO userDTO=new UserDTO();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			userDTO=(UserDTO)jdbcTemplate.queryForObject(HRPortalConstants.SELECT_USER_DETAILS, new Object[]{username}, new UserMapper());
		} catch (Exception e) {
			LOGGER.error("Error into the  userInfo(String username)"+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}
		return userDTO;
	}
	public void updatenNumberOfLoginTimes(String username)throws DaoException{
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int countIncrement=countLoginTimes(username);
			jdbcTemplate.update(HRPortalConstants.UPDATE_LOGIN_COUNT, new Object[]{countIncrement+HRPortalConstants.COUNT_PLUS,username});
		} catch (Exception e) {
			LOGGER.error("Error into the  updatenNumberOfLoginTimes(String username)"+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}
		}
		public int countLoginTimes(String username)throws DaoException{
			Integer count=0;
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				 count=jdbcTemplate.queryForInt(HRPortalConstants.SELECT_LAST_HITS_COUNT,new Object[]{username});
			} catch (Exception e) {
				LOGGER.error("Error into the countLoginTimes(String username) "+e.getMessage());
				e.printStackTrace();
				throw new DaoException();
			}		
			return count;
		}
	
  public void updatLastLoginTime(String username)throws DaoException{
	  
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Timestamp currentTimestamp=new Timestamp(new Date().getTime());
			Date currentDate=new Date();
			jdbcTemplate.update(HRPortalConstants.UPDATE_LAST_LOGIN_TIMES, new Object[]{currentTimestamp,currentDate,currentTimestamp,username});
		} catch (Exception e) {
			LOGGER.error("Error into the updatLastLoginTime(String username)"+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}		
  }
  public Integer updateConsetiveSuccess(String username)throws DaoException{
	  Integer updateConstetiveSuccess=0;
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				Timestamp currentTimestamp=new Timestamp(new Date().getTime());
				Date currentDate=new Date();
                updateConstetiveSuccess=jdbcTemplate.update(HRPortalConstants.UPDATE_CONSERTIVE_SUCCESS, new Object[]{HRPortalConstants.COUNT_ZERO,
                		 currentTimestamp,currentDate,currentTimestamp,username});
			} catch (Exception e) {
				LOGGER.error("Error into the findConsetiveFailureCount(String username) "+e.getMessage());
				e.printStackTrace();
				throw new DaoException();
			}		
			return updateConstetiveSuccess;
  }
  public Integer updateConsectiveFailures(String username)throws DaoException{
	  int consetiveFailureCount=0;
	  try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			 consetiveFailureCount=findConsetiveFailureCount(username);
			if(consetiveFailureCount==0){
				jdbcTemplate.update(HRPortalConstants.UPDATE_CONSERTIVE_FAILUR, new Object[]{HRPortalConstants.COUNT_PLUS,username});	
				return findConsetiveFailureCount(username);
			}
			  if(consetiveFailureCount<3){
				jdbcTemplate.update(HRPortalConstants.UPDATE_CONSERTIVE_FAILUR, new Object[]{consetiveFailureCount+HRPortalConstants.COUNT_PLUS,username});
				consetiveFailureCount=findConsetiveFailureCount(username);
			  }else{
				  return consetiveFailureCount;
			  }
		} catch (Exception e) {
			LOGGER.error("Error into the  updateConsectiveFailures(String username)"+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}
	  return consetiveFailureCount;
  }
  public Integer findConsetiveFailureCount(String username)throws DaoException{
	  Integer count=0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Integer> listCount=(List<Integer>)jdbcTemplate.query(HRPortalConstants.SELECT_CONSERTIVE_FAILURE_COUNT,new Object[]{username}, new UserRowMapperCount());
           for(Integer countV:listCount){
        	   count=countV;
           }
		} catch (Exception e) {
			LOGGER.error("Error into the findConsetiveFailureCount(String username) "+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
		}		
		return count;
  }
  public void updateConsetiveFailureZero(String username)throws DaoException{
	  try {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  jdbcTemplate.update(HRPortalConstants.UPDATE_CONSERTIVE_FAILURE_ZERO, new Object[]{username});
	} catch (Exception e) {
		LOGGER.error("Error into the updateConsetiveFailureZero(String username) "+e.getMessage());
		e.printStackTrace();
		throw new DaoException();
	}
  }
  public Integer expireDateVerification(String username)throws DaoException{
	  Integer returnExpireDateValue=0;
	  try{
	  UserDTO userDTO=userInfo(username);
	  Date expireDate=userDTO.getExpirePasswordDate();
	  Date currentDate=new Date();
      if(currentDate.before(expireDate)){
    	  returnExpireDateValue=HRPortalConstants.DATE_CORRECT;
      }else if(currentDate.after(expireDate)){
    	  returnExpireDateValue=HRPortalConstants.DATE_EXPIRED;
      }else if(currentDate.equals(expireDate)) {
    	  returnExpireDateValue=HRPortalConstants.DATE_EQUAL;
      }
	  }catch(Exception e){
		  LOGGER.error("Error into the expireDateVerification()"+e.getMessage());
			e.printStackTrace();
			throw new DaoException();
	  }
	  return returnExpireDateValue;
  }
  
  public Integer userChecking(String username)throws DaoException{
	  Integer userChecking=0;
	  try {
		  UserDTO userDTO=userInfo(username);
		  String userStatus=userDTO.getAccountStatus();
		  if("ACTIVE".equals(userStatus)){
			  userChecking=HRPortalConstants.ACTIVE_STATUS;
		  }else if("INACTIVE".equals(userStatus)){
			  userChecking=HRPortalConstants.INACTIVE_STATUS;
		  }else if("DISABLE".equals(userStatus)){
			  userChecking=HRPortalConstants.DISABLE_STATUS;
		  }
	} catch (Exception e) {
		LOGGER.error("Error into the userChecking "+e.getMessage());
		e.printStackTrace();
		throw new DaoException();
	}
	  return userChecking;
  }
  public String userRole(String username)throws DaoException{
	  String userRole="";
	  try {
		  UserDTO userDTO=userInfo(username);
		  userRole=userDTO.getRole();
		  if("ADMIN".equals(userRole)){
			  userRole=HRPortalConstants.ADMIN_ROLE_ID.toString();
		  } else if("NORMAL".equals(userRole)){
			  userRole=HRPortalConstants.NORMA_USER_ID.toString();
		  }else if("DEV".equals(userRole)){
			  userRole=HRPortalConstants.HR_USER_ID.toString();
		  }else if("CUSTOMER".equals(userRole)){
			  userRole=HRPortalConstants.CUSTOMER_USER_ID.toString();
		  }
	} catch (Exception e) {
		LOGGER.error("Error into the userChecking "+e.getMessage());
		e.printStackTrace();
		throw new DaoException();
	}
	  return userRole;
  }
  public Integer passwordUpdate(String username,String currentpassword,String newPassword)throws DaoException{
	  Integer passwordId=HRPortalConstants.COUNT_ZERO;
	  LOGGER.info("$$$$passwordUpdate() is statred$$$$");
	  try {
		  
		  if(currentPasswordChecking(username,currentpassword)){
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<UserDTO> userInfo=listOfPastPassword(username);
			if(userInfo.contains(currentpassword)){
				passwordId=HRPortalConstants.PASSWORD_USED_BEFORE;		
			}else{
				if(updatePasswordDetails(username)){
				for(UserDTO userDTO:userInfo){
					jdbcTemplate.update(HRPortalConstants.UPDATE_PASSWORD,new Object[]{newPassword,currentpassword,userDTO.getPastPasswordOne(),userDTO.getPastPasswordTwo(),username});
					passwordId=HRPortalConstants.PASSWORD_CHANGED_SUCCESS;
    				}
				}else{
					passwordId=HRPortalConstants.PASSWORD_CHANGED_ERROR;
				}
			}
		  }else{
			  passwordId=HRPortalConstants.CURRENT_PASSWORD_INCORRECT;
		  }
			
	} catch (Exception e) {
		passwordId=HRPortalConstants.PASSWORD_CHANGED_ERROR;
		LOGGER.error("Error into the passwordUpdate "+e.getMessage());

	}
	  
	  LOGGER.info("$$$$passwordUpdate() is ended$$$$");
	  return passwordId;
  }
  public List<UserDTO> listOfPastPassword(String username)throws DaoException{
	  List<UserDTO> listOfPastPassword=new ArrayList<UserDTO>();
	  try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			listOfPastPassword=(List<UserDTO>)jdbcTemplate.query(HRPortalConstants.SELECT_PAST_PASSWORD, new Object[]{username},new PasswordMapper());
			
	} catch (Exception e) {
		LOGGER.error("Error into the listOfPastPassword "+e.getMessage());
	}
	  return listOfPastPassword;
  }
  
  public boolean currentPasswordChecking(String username,String password){
	  boolean currentPassword=false;
	  try {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  Integer id=jdbcTemplate.queryForInt(HRPortalConstants.SELECT_FIND_CURRENT_PASSWORD,new Object[]{username,password});
		  if(id==1){
			  currentPassword=true;
		  }else{
			  currentPassword=false;
		  }
	} catch (Exception e) {
		LOGGER.error("Error into the currentPasswordChecking "+e.getMessage());
	}
	  return currentPassword;
  }
  public boolean updatePasswordDetails(String username){
	  boolean updatePassword=false;
	  try {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  Integer id=jdbcTemplate.update(HRPortalConstants.UPDATE_PASSWORD_CHANGED_DETAILS,new Object[]{DateUtils.after60DaysFromCurrentDate(),username});
		  if(id==1){
			  updatePassword=true;
		  }else{
			  updatePassword=false;
		  }
	} catch (Exception e) {
		LOGGER.error("Error into the updatePasswordDetails "+e.getMessage());
	}  
	  return updatePassword;
  }
  
}
