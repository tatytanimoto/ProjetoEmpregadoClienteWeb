import org.hibernate.Session;

import relacionamento.util.HibernateUtil;

/**
 * 
 */

/**
 * Programa para verificar e testar a conexão com o banco de dados.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

public class MainTesteConexao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("\n Objeto Session construído com sucesso.");

		} finally {

			session.close();
		}

	}

}
