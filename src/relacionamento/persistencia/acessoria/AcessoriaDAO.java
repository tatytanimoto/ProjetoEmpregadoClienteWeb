/**
 * 
 */
package relacionamento.persistencia.acessoria;

import static relacionamento.persistencia.Persistencia.ATUALIZAR_ERRO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_ERRO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_SUCESSO;
import static relacionamento.persistencia.Persistencia.SALVAR_ERRO;
import static relacionamento.persistencia.Persistencia.SALVAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.SALVAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.LISTAR_ERRO;
import static relacionamento.persistencia.Persistencia.LISTAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.LISTAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_ERRO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_CHAVE_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ERRO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_ERRO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.SHOW_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;
import relacionamento.util.HibernateUtil;

/**
 * Classe para realizar as operações de persistência da classe Acessoria.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

class AcessoriaDAO implements IAcessoriaDAO {

	// Variáveis de instância

	private Session session;

	private Transaction transaction;

	private Criteria criteria;

	// Função construtora da classe

	public AcessoriaDAO() {

	}

	// Operações da classe

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

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.save(acessoria);

			transaction.commit();

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
	 * @see relacionamento.persistencia.acessoria.IAcessoriaDAO#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Acessoria> listar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Acessoria> acessorias = null;

		String msg = this.getClass().getSimpleName();

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Acessoria.class);

			acessorias = criteria.list();

			transaction.commit();

			msg += LISTAR_SUCESSO;

		} catch (Throwable e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += LISTAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					session.close();

				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += LISTAR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}
		}

		// Saída da informação

		return acessorias;
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

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.update(acessoria);

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

					session.close();
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
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#excluir(relacionamento
	 * .model.acessoria.Acessoria)
	 */
	@Override
	public Boolean excluir(Acessoria acessoria) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		boolean flag = false;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.delete(acessoria);

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

				if (this.session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				flag = false;

				msg += EXCLUIR_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}

		}

		// Saída da infomração

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		Integer value = null;

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Acessoria.class).setProjection(
					Projections.max("codigoAcessoria"));

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

				if (session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg += PESQUISAR_ULTIMO_ID_INSERIDO_ERRO + e.getMessage();
			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}

		}

		// Saída da infomração

		return value;
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

		// Declaração de variáveis

		Acessoria acessoria = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			criteria = session.createCriteria(Acessoria.class).add(
					Restrictions.eq("codigoAcessoria", codigoAcessoria));

			transaction = session.beginTransaction();

			acessoria = (Acessoria) criteria.uniqueResult();

			transaction.commit();

			msg += PESQUISAR_SUCESSO;

		} catch (Throwable e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += PESQUISAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (this.session.isOpen()) {

					session.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				msg = PESQUISAR_ERRO + e.getMessage();

			}

			if (SHOW_MESSAGE && msg != null) {

				System.err.println(msg);
			}
		}

		return acessoria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.acessoria.IAcessoriaDAO#pesquisar(java.lang
	 * .String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Acessoria> pesquisar(String descricao) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		ArrayList<Acessoria> acessorias = null;

		String msg = this.getClass().getSimpleName();

		// Inicialização de variáveis

		descricao = "%" + descricao.toUpperCase() + "%";

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Acessoria.class).add(
					Restrictions.like("descricaoAcessoria", descricao));

			acessorias = (ArrayList<Acessoria>) criteria.list();

			this.transaction.commit();

			msg += PESQUISAR_CHAVE_SUCESSO;

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

		return acessorias;

	}

	@SuppressWarnings("unchecked")
	public List<Acessoria> pesquisar(Cliente cliente) {

		// Declaração de variáveis

		List<Acessoria> acessorias = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Acessoria.class).add(
					Restrictions.eq("cliente", cliente));

			acessorias = criteria.list();

			msg += PESQUISAR_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += PESQUISAR_NAO_SUCESSO + e.getMessage();

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

		return acessorias;
	}
}
