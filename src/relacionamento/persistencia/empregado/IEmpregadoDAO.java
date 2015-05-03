/**
 * 
 */
package relacionamento.persistencia.empregado;

import java.util.List;

import relacionamento.model.empregado.Empregado;

/**
 * Interface para definir as operações no Banco de Dados para a classe
 * EmpregadoDAO.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

interface IEmpregadoDAO {

	public void salvar(Empregado empregado);

	public List<Empregado> listar();

	public void atualizar(Empregado empregado);

	public Boolean excluir(Empregado empregado);

	public Integer pesquisar();

	public Empregado pesquisar(Integer codigoEmpregado);

	public List<Empregado> pesquisar(String nome);

}
