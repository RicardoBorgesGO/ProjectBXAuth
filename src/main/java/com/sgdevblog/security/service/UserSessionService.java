package com.sgdevblog.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgdevblog.dao.UserDAO;
import com.sgdevblog.model.Usuario;
import com.sgdevblog.security.SessionCookieData;
import com.sgdevblog.security.UserSession;

@Service
@Transactional
public class UserSessionService {

	@Autowired
	private UserDAO userDao;

	public UserSession getUserSession(SessionCookieData sessionData){
		UserSession session = new UserSession();

		if(sessionData==null || sessionData.getUserId()==0){
			return null;
		}

		Usuario user = userDao.getUser(sessionData.getUserId());

		if(user==null) {
			return null;
		}

		user.getUserRoles();
		session.setUser(user);
//		session.setSite(user.getSite());

		return session;
	}

}
