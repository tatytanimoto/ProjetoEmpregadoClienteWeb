/**
 * 
 */
package relacionamento.persistencia.endereco;

import java.util.List;

import relacionamento.model.endereco.Endereco;

/**
 * Classe para implementar a interface entre o sistema e a camada de
 * persist�ncia para a entidade Endereco.
 * 
 * @author Baracho
 * 
 * @since 25/08/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaEndereco implements IEnderecoDAO {

	// Vari�veis de inst�ncia

	private EnderecoDAO enderecoDAO;

	// Fun��o construtora

	public PersistenciaEndereco() {

		enderecoDAO = new EnderecoDAO();
	}

	// Opera��es da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#salvar(relacionamento
	 * .model.endereco.Endereco)
	 */
	@Override
	public void salvar(Endereco endereco) {
		// TODO Auto-generated method stub
		enderecoDAO.salvar(endereco);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.endereco.IEnderecoDAO#listar()
	 */
	@Override
	public List<Endereco> listar() {
		// TODO Auto-generated method stub
		return enderecoDAO.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#atualizar(relacionamento
	 * .model.endereco.Endereco)
	 */
	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		enderecoDAO.atualizar(endereco);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#excluir(relacionamento
	 * .model.endereco.Endereco)
	 */
	@Override
	public Boolean excluir(Endereco endereco) {
		// TODO Auto-generated method stub
		return enderecoDAO.excluir(endereco);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#pesquisarUltimoRegistro
	 * ()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#pesquisar(java.lang
	 * .Integer)
	 */
	@Override
	public Endereco pesquisar(Integer codigoCliente) {
		// TODO Auto-generated method stub
		return enderecoDAO.pesquisar(codigoCliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.endereco.IEnderecoDAO#pesquisar(java.lang
	 * .String)
	 */
	@Override
	public List<Endereco> pesquisar(String rua) {
		// TODO Auto-generated method stub
		return enderecoDAO.pesquisar(rua);
	}

}
