package br.com.auth.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.auth.dao.UsuarioDAO;
import br.com.infra.commons.entity.Usuario;
import br.com.medical.proxy.client.IClientMedicalProxy;
import br.com.medical.proxy.client.impl.ClientMedicalProxy;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

//	@PersistenceContext
//	private EntityManager entityManager;
	
	//TODO Injetar
	private IClientMedicalProxy medicalProxy = new ClientMedicalProxy();

	@Override
	public boolean consultaUsuario(br.com.infra.commons.entity.Usuario usuario) {
		return medicalProxy.consultaUsuario(usuario);
	}

	@Override
	public Usuario getUser(String userName) {
		return medicalProxy.consultaUsuarioPorLogin(userName);
	}

	@Override
	public Usuario getUser(int userId) {
		return medicalProxy.consultaUsuarioPorId(userId);
	}
	
//	@SuppressWarnings("unchecked")
	// Query.getResultList, does not support generic
//	public Usuario getUser(String userName) {
//		String sql = "SELECT e FROM Usuario e WHERE e.login = :login";
//		
//		Query query = entityManager.createQuery(sql, Usuario.class);
//		query.setParameter("login", userName);
//		List<Usuario> users = query.getResultList();
//
//		if (users != null && users.size() == 1) {
//			return users.get(0);
//		}
//
//		return null;
//	}

//	@SuppressWarnings("unchecked")
//	public Usuario getUser(int userId) {
//		Usuario user = null;
//
//		Query query = entityManager.createQuery(
//				"SELECT e FROM Usuario e WHERE e.id = :userId", Usuario.class);
//		query.setParameter("userId", userId);
//
//		List<Usuario> users = (List<Usuario>) query.getResultList();
//
//		if (users != null && users.size() == 1) {
//			user = users.get(0);
//		}
//
//		return user;
//	}

}
