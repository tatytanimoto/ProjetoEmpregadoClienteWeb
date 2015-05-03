/**
 * 
 */
package relacionamento.persistencia.empregado;

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
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_NAO_SUCESSO;
import static relacionamento.persistencia.Persistencia.PESQUISAR_ULTIMO_ID_INSERIDO_SUCESSO;
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

import relacionamento.model.empregado.Empregado;
import relacionamento.util.HibernateUtil;

/**
 * Classe para realizar as operações de persistência da classe Empregado.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

class EmpregadoDAO implements IEmpregadoDAO {

	// Variáveis de instância

	private Session session;

	private Transaction transaction;

	private Criteria criteria;

	// Função construtora da classe

	public EmpregadoDAO() {

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

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.save(empregado);

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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.empregado.IEmpregado#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Empregado> listar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Empregado> empregados = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Empregado.class);

			empregados = criteria.list();

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

					this.session.close();
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

		return empregados;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.empregado.IEmpregado#atualizar(relacionamento
	 * .model.empregado.Empredo)
	 */
	@Override
	public void atualizar(Empregado empregado) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.update(empregado);

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
	 * relacionamento.persistencia.empregado.IEmpregado#excluir(relacionamento
	 * .model.empregado.Empredo)
	 */
	@Override
	public Boolean excluir(Empregado empregado) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Boolean flag = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.delete(empregado);

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

					this.session.close();
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

			criteria = session.createCriteria(Empregado.class).setProjection(
					Projections.max("codigoEmpregado"));

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

					this.session.close();
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
	 * @see relacionamento.persistencia.empregado.IEmpregado#pesquisar(int)
	 */
	@Override
	public Empregado pesquisar(Integer codigoEmpregado) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Empregado Empregado = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Empregado.class);

			criteria.add(Restrictions.eq("codigoEmpregado", codigoEmpregado));

			Empregado = (Empregado) criteria.uniqueResult();

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

		return Empregado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empregado> pesquisar(String nome) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		ArrayList<Empregado> empregados = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		nome = "%" + nome.toUpperCase() + "%";

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Empregado.class).add(
					Restrictions.like("nomeEmpregado", nome));

			empregados = (ArrayList<Empregado>) criteria.list();

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

		return empregados;
	}

}
