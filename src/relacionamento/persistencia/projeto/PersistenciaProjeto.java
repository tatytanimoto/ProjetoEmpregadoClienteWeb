/**
 * 
 */
package relacionamento.persistencia.projeto;

import java.util.List;

import relacionamento.model.projeto.Projeto;

/**
 * Classe para implementar a interface entre o sistema e a camada de
 * persist�ncia para a entidade Projeto.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaProjeto implements IProjetoDAO {

	// Vari�veis de inst�ncia

	private ProjetoDAO projetoDAO;

	// Fun��o construtora

	public PersistenciaProjeto() {

		projetoDAO = new ProjetoDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#salvar(relacionamento
	 * .model.projeto.Projeto)
	 */
	@Override
	public void salvar(Projeto projeto) {
		// TODO Auto-generated method stub
		projetoDAO.salvar(projeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.projeto.IProjetoDAO#listar()
	 */
	@Override
	public List<Projeto> listar() {
		// TODO Auto-generated method stub
		return projetoDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#atualizar(relacionamento
	 * .model.projeto.Projeto)
	 */
	@Override
	public void atualizar(Projeto projeto) {
		// TODO Auto-generated method stub
		projetoDAO.atualizar(projeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#excluir(relacionamento
	 * .model.projeto.Projeto)
	 */
	@Override
	public Boolean excluir(Projeto projeto) {
		// TODO Auto-generated method stub
		return projetoDAO.excluir(projeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#pesquisarUltimoRegistro()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return projetoDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#pesquisar(java.lang.Integer
	 * )
	 */
	@Override
	public Projeto pesquisar(Integer codigoProjeto) {
		// TODO Auto-generated method stub
		return projetoDAO.pesquisar(codigoProjeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#pesquisar(java.lang.String
	 * )
	 */
	@Override
	public List<Projeto> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return projetoDAO.pesquisar(nome);
	}

}
