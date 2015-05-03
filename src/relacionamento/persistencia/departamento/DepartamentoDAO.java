/**
 * 
 */
package relacionamento.persistencia.departamento;

import static relacionamento.persistencia.Persistencia.ATUALIZAR_ERRO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.ATUALIZAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_ERRO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.EXCLUIR_SUCESSO;
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
import static relacionamento.persistencia.Persistencia.SALVAR_ERRO;
import static relacionamento.persistencia.Persistencia.SALVAR_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.SALVAR_SUCESSO;
import static relacionamento.persistencia.Persistencia.SHOW_MESSAGE;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import relacionamento.model.departamento.Departamento;
import relacionamento.util.HibernateUtil;

/**
 * Classe para realizar as operações de persistência da classe Departamento.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

class DepartamentoDAO implements IDepartamentoDAO {

	// Variáveis de instância

	private Session session;

	private Transaction transaction;

	private Criteria criteria;

	// Função construtora

	public DepartamentoDAO() {

	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.departamento.IDepartamento#salvar(relacionamento
	 * .model.departamento.Departamento)
	 */
	@Override
	public void salvar(Departamento departamento) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.save(departamento);

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
	 * @see relacionamento.persistencia.departamento.IDepartamento#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> listar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Departamento> departamentos = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Departamento.class);

			departamentos = criteria.list();

			transaction.commit();

			msg += LISTAR_SUCESSO;

		} catch (HibernateException e) {
			// TODO: handle exception

			if (transaction.isActive()) {

				transaction.rollback();
			}

			msg += LISTAR_NAO_SUCESSO + e.getMessage();

		} finally {

			try {

				if (session.isOpen()) {

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

		return departamentos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.departamento.IDepartamento#atualizar(
	 * relacionamento.model.departamento.Departamento)
	 */
	@Override
	public void atualizar(Departamento departamento) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.update(departamento);

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
	 * relacionamento.persistencia.departamento.IDepartamento#excluir(relacionamento
	 * .model.departamento.Departamento)
	 */
	@Override
	public Boolean excluir(Departamento departamento) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Boolean flag = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.delete(departamento);

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

		// Saída da informação

		return flag;
	}

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

			criteria = session.createCriteria(Departamento.class)
					.setProjection(Projections.max("codigoDepartamento"));

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

		// Saída da informação

		return value;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.departamento.IDepartamento#pesquisar(int)
	 */
	@Override
	public Departamento pesquisar(Integer codigoDepartamento) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Departamento departamento = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Departamento.class);

			criteria.add(Restrictions.eq("codigoDepartamento",
					codigoDepartamento));

			departamento = (Departamento) criteria.uniqueResult();

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

		return departamento;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> pesquisar(String nome) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Departamento> departamentos = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		nome = "%" + nome.toUpperCase() + "%";

		try {

			this.session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			this.transaction = session.beginTransaction();

			criteria = session.createCriteria(Departamento.class).add(
					Restrictions.like("nomeDepartamento", nome));

			departamentos = criteria.list();

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

		return departamentos;
	}

}
