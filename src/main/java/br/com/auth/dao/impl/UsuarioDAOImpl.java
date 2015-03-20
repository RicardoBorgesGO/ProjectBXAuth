package br.com.auth.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.auth.dao.UsuarioDAO;
import br.com.auth.entity.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	// Query.getResultList, does not support generic
	public Usuario getUser(String userName) {
		String sql = "SELECT e FROM Usuario e WHERE e.login = :login";

		Query query = entityManager.createQuery(sql, Usuario.class);
		query.setParameter("login", userName);
		List<Usuario> users = query.getResultList();

		if (users != null && users.size() == 1) {
			return users.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public Usuario getUser(int userId) {
		Usuario user = null;

		Query query = entityManager.createQuery(
				"SELECT e FROM Usuario e WHERE e.id = :userId", Usuario.class);
		query.setParameter("userId", userId);

		List<Usuario> users = (List<Usuario>) query.getResultList();

		if (users != null && users.size() == 1) {
			user = users.get(0);
		}

		return user;
	}

}
