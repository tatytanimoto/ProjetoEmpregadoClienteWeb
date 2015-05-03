/**
 * 
 */
package relacionamento.persistencia.projeto;

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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import relacionamento.model.projeto.Projeto;
import relacionamento.util.HibernateUtil;

/**
 * Classe para realizar as operações de persistência de dados da classe Projeto.
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

class ProjetoDAO implements IProjetoDAO {

	// Variáveis de instância

	private Session session;

	private Transaction transaction;

	private Criteria criteria;

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

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			session.save(projeto);

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
	 * @see relacionamento.persistencia.projeto.IProjetoDAO#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> listar() {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Projeto> projetos = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Projeto.class);

			projetos = criteria.list();

			transaction.commit();

			msg += LISTAR_SUCESSO;

		} catch (Throwable e) {
			// TODO: handle exception

			if (this.transaction.isActive()) {

				this.transaction.rollback();
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

		return projetos;
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

		// Declaração de variáveis

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.update(projeto);

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
	 * relacionamento.persistencia.projeto.IProjetoDAO#excluir(relacionamento
	 * .model.projeto.Projeto)
	 */
	@Override
	public Boolean excluir(Projeto projeto) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Boolean flag = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.delete(projeto);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see relacionamento.persistencia.projeto.IProjetoDAO#pesquisar()
	 */
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

			criteria = session.createCriteria(Projeto.class).setProjection(
					Projections.max("codigoProjeto"));

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
	 * relacionamento.persistencia.projeto.IProjetoDAO#pesquisar(java.lang.Integer
	 * )
	 */
	@Override
	public Projeto pesquisar(Integer codigoProjeto) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		Projeto projeto = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Projeto.class);

			criteria.add(Restrictions.eq("codigoProjeto", codigoProjeto));

			projeto = (Projeto) criteria.uniqueResult();

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

		return projeto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * relacionamento.persistencia.projeto.IProjetoDAO#pesquisar(java.lang.String
	 * )
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> pesquisar(String nome) {
		// TODO Auto-generated method stub

		// Declaração de variáveis

		List<Projeto> projetos = null;

		String msg = this.getClass().getSimpleName();

		// Processamento dos dados

		nome = "%" + nome.toUpperCase() + "%";

		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			transaction = session.beginTransaction();

			criteria = session.createCriteria(Projeto.class).add(
					Restrictions.like("nomeProjeto", nome));

			projetos = criteria.list();

			transaction.commit();

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

		return projetos;
	}

}
