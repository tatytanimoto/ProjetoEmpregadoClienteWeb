/**
 * 
 */
package relacionamento.persistencia.cliente;

import java.util.List;

import relacionamento.model.cliente.Cliente;

/**
 * Classe para implementar a interface entra o sistema e a camada de
 * persistência para a entidade Cliente.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaCliente implements IClienteDAO {

	// Variáveis de instância

	private ClienteDAO clienteDAO;

	// Função construtora

	public PersistenciaCliente() {

		clienteDAO = new ClienteDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.IClienteDAO#salvar(relacionamento
	 * .model.cliente.Cliente)
	 */
	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.salvar(cliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.cliente.IClienteDAO#listar()
	 */
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return clienteDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.IClienteDAO#atualizar(relacionamento
	 * .model.cliente.Cliente)
	 */
	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.atualizar(cliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.IClienteDAO#excluir(relacionamento
	 * .model.cliente.Cliente)
	 */
	@Override
	public Boolean excluir(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDAO.excluir(cliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.cliente.IClienteDAO#pesquisar()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return clienteDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.IClienteDAO#pesquisar(java.lang.Integer
	 * )
	 */
	@Override
	public Cliente pesquisar(Integer codigoCliente) {
		// TODO Auto-generated method stub
		return clienteDAO.pesquisar(codigoCliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.IClienteDAO#pesquisar(java.lang.String
	 * )
	 */
	@Override
	public List<Cliente> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return clienteDAO.pesquisar(nome);
	}

}
