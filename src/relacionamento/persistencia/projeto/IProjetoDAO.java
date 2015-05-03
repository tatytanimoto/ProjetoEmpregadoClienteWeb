/**
 * 
 */
package relacionamento.persistencia.projeto;

import java.util.List;

import relacionamento.model.projeto.Projeto;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * ProjetoDAO.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

interface IProjetoDAO {

	public void salvar(Projeto projeto);

	public List<Projeto> listar();

	public void atualizar(Projeto projeto);

	public Boolean excluir(Projeto projeto);

	public Integer pesquisar();

	public Projeto pesquisar(Integer codigoProjeto);

	public List<Projeto> pesquisar(String nome);

}
