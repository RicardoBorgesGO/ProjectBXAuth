package br.com.auth.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.auth.dao.impl.UsuarioDAOImpl;
import br.com.infra.commons.entity.Usuario;


@Service
@Transactional
public class AuthenticationService {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioDAOImpl userDao;
	
	public Usuario login(String login, String password) {
//		boolean isPasswordValid = false;
//		Usuario user = userDao.getUser(login);
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(password);
		
		boolean userExist = userDao.consultaUsuario(user);
		
		if(!userExist) {
			user = null;
//			try {
//				isPasswordValid = user.getPassword().equals(password);

				//TODO transformar para sha1
//				isPasswordValid = user.getPassword().equals(SecurityUtil.hashPassword(password, user.getSalt()));
//			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//				logger.error("Error authenticating, " + login, e);
//			}
		} else {
			user.getUserRoles();
		}

//		if(user!=null && !isPasswordValid) {
//			user=null;
//		}else if(user!=null && isPasswordValid) {
//		}

		return user;
	}

}
