package com.crud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.crud.dao.ClienteDAO;
import com.crud.model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	public List<Cliente> obtenerClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarTodos();
	}
	
	public String editar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c=clienteDAO.buscar(id);
		System.out.println(c.toString());
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/editar.xhtml";
	}
	
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado exitosamente");
		return "/faces/index.xhtml";
	}
	
	public String nuevo() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Date fechaActual= new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		clienteDAO.guardar(cliente);
		System.out.println("Se guardar el cliente exitosamente");
		return "/faces/index.xhtml";
	}
	
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Date fechaActual= new Date();
		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		clienteDAO.actualizar(cliente);
		return "/faces/index.xhtml";
	}
}
