package br.com.auth.dao;

import br.com.auth.entity.Usuario;

public interface UsuarioDAO {

	/**
	 * Retorna o usuario pelo nome
	 * @param userName
	 * @return
	 */
	Usuario getUser(String userName);
	
	/**
	 * Retorna o usuario pelo id
	 * @param userId
	 * @return
	 */
	Usuario getUser(int userId);
}
