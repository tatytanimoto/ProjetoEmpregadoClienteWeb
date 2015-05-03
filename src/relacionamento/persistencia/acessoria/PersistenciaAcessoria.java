/**
 * 
 */
package relacionamento.persistencia.acessoria;

import java.util.List;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;

/**
 * Classe para implementar a interface entre o sistema e a camada de
 * persisteência para a entidade Acessoria.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaAcessoria implements IAcessoriaDAO {

	// Variáveis de instância

	private AcessoriaDAO acessoriaDAO;

	// Função construtora

	public PersistenciaAcessoria() {

		acessoriaDAO = new AcessoriaDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#salvar(relacionamento
	 * .model.acessoria.Acessoria)
	 */
	@Override
	public void salvar(Acessoria acessoria) {
		// TODO Auto-generated method stub
		acessoriaDAO.salvar(acessoria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.acessoria.IAcessoriaDAO#listar()
	 */
	@Override
	public List<Acessoria> listar() {
		// TODO Auto-generated method stub
		return acessoriaDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#atualizar(relacionamento
	 * .model.acessoria.Acessoria)
	 */
	@Override
	public void atualizar(Acessoria acessoria) {
		// TODO Auto-generated method stub
		acessoriaDAO.atualizar(acessoria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#excluir(relacionamento
	 * .model.acessoria.Acessoria)
	 */
	@Override
	public Boolean excluir(Acessoria acessoria) {
		// TODO Auto-generated method stub
		return acessoriaDAO.excluir(acessoria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return acessoriaDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar(java.lang
	 * .Integer)
	 */
	@Override
	public Acessoria pesquisar(Integer codigoAcessoria) {
		// TODO Auto-generated method stub
		return acessoriaDAO.pesquisar(codigoAcessoria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar(java.lang
	 * .String)
	 */
	@Override
	public List<Acessoria> pesquisar(String descricao) {
		// TODO Auto-generated method stub
		return acessoriaDAO.pesquisar(descricao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar(relacionamento
	 * .model.cliente.Cliente)
	 */
	@Override
	public List<Acessoria> pesquisar(Cliente cliente) {

		return acessoriaDAO.pesquisar(cliente);
	}

}
