/**
 * 
 */
package relacionamento.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe para o arquivo de configuração hibernate.cfg.xml e instancializar a
 * SessionFactory.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		ServiceRegistry serviceRegistry = null;

		try {

			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			// TODO: handle exception

			System.err
					.println("Criação inicial do Objeto SessionFactory falhou. Erro: "
							+ e.getMessage());

			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declaração de variáveis

		Session session = null;

		// Processamento dos dados

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("\n Objeto SessionFactory criado com sucesso.");

		} finally {

			if (session.isOpen()) {

				session.close();

			}
		}

	}

}
