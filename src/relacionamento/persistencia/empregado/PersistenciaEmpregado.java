/**
 * 
 */
package relacionamento.persistencia.empregado;

import java.util.List;

import relacionamento.model.empregado.Empregado;

/**
 * Classe para implementar a interface entre o sistema e a camada de
 * persistência para a entidade Empregado.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaEmpregado implements IEmpregadoDAO {

	// Variáveis de instância

	private EmpregadoDAO empregadoDAO;

	// Função construtora

	public PersistenciaEmpregado() {

		empregadoDAO = new EmpregadoDAO();
	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregadoDAO#salvar(relacionamento
	 * .model.empregado.Empregado)
	 */
	@Override
	public void salvar(Empregado empregado) {
		// TODO Auto-generated method stub
		empregadoDAO.salvar(empregado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.empregado.IEmpregadoDAO#listar()
	 */
	@Override
	public List<Empregado> listar() {
		// TODO Auto-generated method stub
		return empregadoDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregadoDAO#atualizar(relacionamento
	 * .model.empregado.Empregado)
	 */
	@Override
	public void atualizar(Empregado empregado) {
		// TODO Auto-generated method stub
		empregadoDAO.atualizar(empregado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregadoDAO#excluir(relacionamento
	 * .model.empregado.Empregado)
	 */
	@Override
	public Boolean excluir(Empregado empregado) {
		// TODO Auto-generated method stub
		return empregadoDAO.excluir(empregado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.empregado.IEmpregadoDAO#pesquisar()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return empregadoDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregadoDAO#pesquisar(java.lang
	 * .Integer)
	 */
	@Override
	public Empregado pesquisar(Integer codigoEmpregado) {
		// TODO Auto-generated method stub
		return empregadoDAO.pesquisar(codigoEmpregado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregadoDAO#pesquisar(java.lang
	 * .String)
	 */
	@Override
	public List<Empregado> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return empregadoDAO.pesquisar(nome);
	}

}
