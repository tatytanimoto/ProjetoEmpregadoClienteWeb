/**
 * 
 */
package relacionamento.persistencia.cliente;

import java.util.List;

import relacionamento.model.cliente.Cliente;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * ClienteDAO.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

interface IClienteDAO {

	public void salvar(Cliente cliente);

	public List<Cliente> listar();

	public void atualizar(Cliente cliente);

	public Boolean excluir(Cliente cliente);

	public Integer pesquisar();

	public Cliente pesquisar(Integer codigoCliente);

	public List<Cliente> pesquisar(String nome);

}
