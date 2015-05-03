/**
 * 
 */
package relacionamento.persistencia.cliente;

import static relacionamento.persistencia.Persistencia.ATUALIZAR_ERRO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_ERRO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_SUCESSO;
import static relacionamento.persistencia.Persistencia.LISTAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.LISTAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_ERRO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ERRO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.SALVAR_ERRO;
import static relacionamento.persistencia.Persistencia.SALVAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.SALVAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.SHOW_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import relacionamento.model.cliente.Cliente;
import relacionamento.persistencia.acessoria.PersistenciaAcessoria;
import relacionamento.util.HibernateUtil;

/**
 * Classe para realizar as operações de persistência da classe Cliente.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

class ClienteDAO implements IClienteDAO {

	// Variáveis de instância

	private Session session;

	private Transaction transaction;

	private Criteria criteria;

	private PersistenciaAcessoria persistenciaAcessoria;

	// Função construtora

	public ClienteDAO() {

		persistenciaAcessoria = new PersistenciaAcessoria();

	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.ICliente#salvar(relacionamento.model
	 * .cliente.Cliente)
	 */
	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.save(cliente);

			transaction.commit();

			cliente.setAcessorias(persistenciaAcessoria.pesquisar(cliente));

			msg += SALVAR_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();
			}

			msg += SALVAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += SALVAR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.cliente.ICliente#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Cliente> clientes = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Cliente.class);

			clientes = criteria.list();

			transaction.commit();

			if (clientes != null) {

				for (Cliente cliente : clientes) {

					cliente.setAcessorias(persistenciaAcessoria
							.pesquisar(cliente));
				}

				msg += LISTAR_SUCESSO;
			}

		} catch (Throwable e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += LISTAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					this.session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += SALVAR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);

			}
		}

		// Saída da informação

		return clientes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.ICliente#atualizar(relacionamento
	 * .model.cliente.Cliente)
	 */
	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.update(cliente);

			transaction.commit();

			msg += ATUALIZAR_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();
			}

			msg += ATUALIZAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					this.session.close();

				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += ATUALIZAR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.cliente.ICliente#excluir(relacionamento.model
	 * .cliente.Cliente)
	 */
	@Override
	public Boolean excluir(Cliente cliente) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Boolean flag = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.delete(cliente);

			transaction.commit();

			flag = true;

			msg += EXCLUIR_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();

			}

			flag = false;

			msg += EXCLUIR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				flag = false;

				msg += EXCLUIR_ERRO + e.getMessage();
			}

			System.err.println(msg);

		}

		return flag;
	}

	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Integer value = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Cliente.class).setProjection(
					Projections.max("codigoCliente"));

			value = (Integer) criteria.uniqueResult();

			transaction.commit();

			msg += PESQUISAR_ULTIMO_ID_INSERIDO_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();

			}

			msg += PESQUISAR_ULTIMO_ID_INSERIDO_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					this.session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += PESQUISAR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}

		}

		// Saída da informação

		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.cliente.ICliente#pesquisar(int)
	 */
	@Override
	public Cliente pesquisar(Integer codigoCliente) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Cliente cliente = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Cliente.class);

			criteria.add(Restrictions.eq("codigoCliente", codigoCliente));

			cliente = (Cliente) criteria.uniqueResult();

			transaction.commit();

			if (cliente != null) {

				cliente.setAcessorias(persistenciaAcessoria.pesquisar(cliente));

				msg += PESQUISAR_SUCESSO;

			}

		} catch (Throwable e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += PESQUISAR_NAO_SUCESSO;

		} finally {

			try {

				if (session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += PESQUISAR_ERRO + e.getMessage();

			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);

			}
		}

		// Saída da informação

		return cliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> pesquisar(String nome) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		ArrayList<Cliente> clientes = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		nome = "%" + nome.toUpperCase() + "%";

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Cliente.class).add(
					Restrictions.like("nomeCliente", nome));

			clientes = (ArrayList<Cliente>) criteria.list();

			this.transaction.commit();

			if (clientes != null) {

				for (Cliente cliente : clientes) {

					cliente.setAcessorias(persistenciaAcessoria
							.pesquisar(cliente));
				}

				msg += PESQUISAR_CHAVE_SUCESSO;

			}

		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();
			}

			msg += PESQUISAR_CHAVE_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					this.session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += PESQUISAR_CHAVE_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}
		}

		// Saída da informação

		return clientes;
	}

}
