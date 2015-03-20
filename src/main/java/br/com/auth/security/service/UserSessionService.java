package br.com.auth.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.auth.dao.impl.UsuarioDAOImpl;
import br.com.auth.entity.Usuario;
import br.com.auth.security.SessionCookieData;
import br.com.auth.security.UserSession;

@Service
@Transactional
public class UserSessionService {

	@Autowired
	private UsuarioDAOImpl userDao;

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
