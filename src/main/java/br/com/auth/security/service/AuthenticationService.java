package br.com.auth.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.auth.dao.impl.UsuarioDAOImpl;
import br.com.auth.entity.Usuario;


@Service
@Transactional
public class AuthenticationService {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UsuarioDAOImpl userDao;

	public Usuario login(String login, String password) {
		boolean isPasswordValid = false;
		Usuario user = userDao.getUser(login);
		if(user!=null) {
//			try {
				isPasswordValid = user.getPassword().equals(password);

				//TODO transformar para sha1
//				isPasswordValid = user.getPassword().equals(SecurityUtil.hashPassword(password, user.getSalt()));
//			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//				logger.error("Error authenticating, " + login, e);
//			}
		}

		if(user!=null && !isPasswordValid) {
			user=null;
		}else if(user!=null && isPasswordValid) {
			user.getUserRoles();
		}

		return user;
	}

}
