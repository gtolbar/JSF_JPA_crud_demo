package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.crud.dao.ClienteDAO;
import com.crud.model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	public List<Cliente> obtenerClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		
		return clienteDAO.buscarTodos();
		/* List<Cliente> listaClientes =new ArrayList<>();
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		
		c1.setId(1L);
		c1.setNombres("Pepito");
		c1.setApellidos("Toledo");
		c1.setEmail("a@a.com");
		c1.setTelefono("3333333");
		c1.setDireccion("candido");
		
		c2.setId(2L);
		c2.setNombres("Pepito");
		c2.setApellidos("barandica");
		c2.setEmail("b@b.com");
		c2.setTelefono("4444444");
		c2.setDireccion("santa ines");
		
		listaClientes.add(c1);
		listaClientes.add(c2);
		
		return listaClientes; */
	}
	
	
}
