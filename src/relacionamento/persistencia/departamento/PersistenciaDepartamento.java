/**
 * 
 */
package relacionamento.persistencia.departamento;

import java.util.List;

import relacionamento.model.departamento.Departamento;

/**
 * Classe para implementar a interface entre o sistema e a camada de
 * persistência para a entidade Departamento.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaDepartamento implements IDepartamentoDAO {

	// Variáveis de instância

	private DepartamentoDAO departamentoDAO;

	// Função construtora

	public PersistenciaDepartamento() {

		departamentoDAO = new DepartamentoDAO();
	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.departamento.IDepartamentoDAO#salvar(
	 * relacionamento.model.departamento.Departamento)
	 */
	@Override
	public void salvar(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoDAO.salvar(departamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.departamento.IDepartamentoDAO#listar()
	 */
	@Override
	public List<Departamento> listar() {
		// TODO Auto-generated method stub
		return departamentoDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.departamento.IDepartamentoDAO#atualizar(
	 * relacionamento.model.departamento.Departamento)
	 */
	@Override
	public void atualizar(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoDAO.atualizar(departamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.departamento.IDepartamentoDAO#excluir(
	 * relacionamento.model.departamento.Departamento)
	 */
	@Override
	public Boolean excluir(Departamento departamento) {
		// TODO Auto-generated method stub
		return departamentoDAO.excluir(departamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.departamento.IDepartamentoDAO#pesquisar()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return departamentoDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.departamento.IDepartamentoDAO#pesquisar(java
	 * .lang.Integer)
	 */
	@Override
	public Departamento pesquisar(Integer codigoDepartamento) {
		// TODO Auto-generated method stub
		return departamentoDAO.pesquisar(codigoDepartamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.departamento.IDepartamentoDAO#pesquisar(java
	 * .lang.String)
	 */
	@Override
	public List<Departamento> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return departamentoDAO.pesquisar(nome);
	}

}
