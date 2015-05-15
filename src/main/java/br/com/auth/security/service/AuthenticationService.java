package br.com.auth.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.auth.dao.UsuarioDAO;
import br.com.infra.commons.entity.Usuario;

@Service
@Transactional
public class AuthenticationService {
	
	@Autowired
	private UsuarioDAO userDao;
	
	public Usuario login(Usuario user) {
		boolean isPasswordValid = false;
		Usuario usuarioThis = userDao.getUser(user.getLogin());
		
		if (usuarioThis != null) {
			isPasswordValid = usuarioThis.getSenha().equals(usuarioThis.getSenha());
			
			// TODO transformar para sha1
			// isPasswordValid =
			// user.getPassword().equals(SecurityUtil.hashPassword(password,
			// user.getSalt()));
		}

		if (user != null && !isPasswordValid) {
			user = null;
		} else if (user != null && isPasswordValid) {
			usuarioThis.getUserRoles();
		}

		return usuarioThis;
	}

}
