/**
 * 
 */
package relacionamento.persistencia.acessoria;

import java.util.List;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * AcessoriaDAO.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

interface IAcessoriaDAO {

	public void salvar(Acessoria acessoria);

	public List<Acessoria> listar();

	public void atualizar(Acessoria acessoria);

	public Boolean excluir(Acessoria acessoria);
	
	public Integer pesquisar();

	public Acessoria pesquisar(Integer codigoAcessoria);
	
	public List<Acessoria> pesquisar(String descricao);
	
	public List<Acessoria> pesquisar(Cliente cliente);

}
