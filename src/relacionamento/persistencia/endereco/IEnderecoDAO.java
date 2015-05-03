/**
 * 
 */
package relacionamento.persistencia.endereco;

import java.util.List;

import relacionamento.model.endereco.Endereco;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * EnderecoDAO.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

interface IEnderecoDAO {

	public void salvar(Endereco endereco);

	public List<Endereco> listar();

	public void atualizar(Endereco endereco);

	public Boolean excluir(Endereco endereco);

	public Integer pesquisar();

	public Endereco pesquisar(Integer codigoCliente);

	public List<Endereco> pesquisar(String rua);

}
