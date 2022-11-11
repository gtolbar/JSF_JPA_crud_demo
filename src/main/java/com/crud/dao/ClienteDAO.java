package com.crud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.crud.model.Cliente;
import com.crud.model.JPAUtil;


public class ClienteDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar cliente
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	//Actualizar cliente
	public void actualizar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Cliente buscar(Long id) {
		Cliente c = new Cliente();
		c=entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return c;
	}
	
	public List<Cliente> buscarTodos() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes= q.getResultList();
		return listaClientes;
	}
	
	//eliminar cliente
	public void eliminar(Long id) {
		Cliente c = new Cliente();
		c=entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();		
	}
	
	
}
