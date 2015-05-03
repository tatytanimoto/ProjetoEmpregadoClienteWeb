/**
 * 
 */
package relacionamento.persistencia.departamento;

import java.util.List;

import relacionamento.model.departamento.Departamento;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * DepartamentoDAO.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

interface IDepartamentoDAO {

	public void salvar(Departamento departamento);

	public List<Departamento> listar();

	public void atualizar(Departamento departamento);

	public Boolean excluir(Departamento departamento);

	public Integer pesquisar();

	public Departamento pesquisar(Integer codigoDepartamento);

	public List<Departamento> pesquisar(String nome);
}
