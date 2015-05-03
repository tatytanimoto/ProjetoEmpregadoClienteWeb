import java.util.List;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;
import relacionamento.model.empregado.Empregado;
import relacionamento.model.projeto.Projeto;
import relacionamento.persistencia.acessoria.PersistenciaAcessoria;
import relacionamento.persistencia.cliente.PersistenciaCliente;
import relacionamento.persistencia.empregado.PersistenciaEmpregado;
import relacionamento.persistencia.projeto.PersistenciaProjeto;

/**
 * 
 */

/**
 * 
 * 
 * @author Baracho
 * 
 * @since 26/08/2014
 * 
 * @version 1.0
 * 
 */

public class MainTesteConsulta {

	public static void main(String[] args) {

		consultarAcessoria();

		consultarProjeto();

		consultarEmpregado();

		consultarCliente();

	}

	public static void consultarAcessoria() {

		// Declaração de variáveis

		Acessoria acessoria = null;

		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();

		// Processamento dos dados

		acessoria = persistenciaAcessoria.pesquisar(1);

		if (acessoria != null) {

			System.out.println("\n " + acessoria.toString());

			System.out.println("\n " + acessoria.getEmpregado().toString());

			System.out.println("\n " + acessoria.getCliente().toString());

			System.out.println("\n "
					+ acessoria.getCliente().getEndereco().toString());

			System.out.println("\n "
					+ acessoria.getEmpregado().getProjeto().toString());

			System.out.println("\n "
					+ acessoria.getEmpregado().getProjeto().getDepartamento()
							.toString());
		}

	}

	public static void consultarProjeto() {

		// Declaração de variáveis

		Projeto projeto = null;

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		// Processamento dos dados

		projeto = persistenciaProjeto.pesquisar(1);

		if (projeto != null) {

			System.out.println("\n " + projeto.toString());

			System.out.println("\n " + projeto.getDepartamento().toString());
		}

	}

	public static void consultarEmpregado() {

		// Declaração de variáveis

		Empregado empregado = null;

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		// Processamento dos dados

		empregado = persistenciaEmpregado.pesquisar(1);

		if (empregado != null) {

			System.out.println("\n " + empregado.toString());

			System.out.println("\n " + empregado.getProjeto().toString());

			System.out.println("\n "
					+ empregado.getProjeto().getDepartamento().toString());
		}

	}

	public static void consultarCliente() {

		// Declaração de variáveis

		Cliente cliente = null;

		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		List<Acessoria> acessorias = null;

		// Processamento dos dados

		cliente = persistenciaCliente.pesquisar(1);

		if (cliente != null) {

			System.out.println("\n " + cliente.toString());

			System.out.println("\n " + cliente.getEndereco().toString());

			acessorias = cliente.getAcessorias();

			if (acessorias != null && acessorias.size() > 0) {

				for (Acessoria acessoria : acessorias) {

					System.out.println("\n " + acessoria.toString());
				}

			} else {

				System.out.println("\n SEM ACESSORIAS.");
			}
		}
	}
}
