package br.com.auth.dao;

import br.com.infra.commons.entity.Usuario;


public interface UsuarioDAO {

	boolean consultaUsuario(Usuario usuario);
	
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
