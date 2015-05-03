import java.util.List;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;
import relacionamento.model.departamento.Departamento;
import relacionamento.model.empregado.Empregado;
import relacionamento.model.endereco.Endereco;
import relacionamento.model.projeto.Projeto;
import relacionamento.persistencia.acessoria.PersistenciaAcessoria;
import relacionamento.persistencia.cliente.PersistenciaCliente;
import relacionamento.persistencia.departamento.PersistenciaDepartamento;
import relacionamento.persistencia.empregado.PersistenciaEmpregado;
import relacionamento.persistencia.endereco.PersistenciaEndereco;
import relacionamento.persistencia.projeto.PersistenciaProjeto;
import relacionamento.util.HibernateUtil;
import relacionamento.util.Util;

/**
 * 
 */

/**
 * @author 501051
 * 
 */
public class MainTestePesquisar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HibernateUtil.getSessionFactory().openSession();

		final String MENU = "MENU PESQUISAR:" + "\n\n\t 1. Departamento."
				+ "\n\t 2. Projeto." + "\n\t 3. Empregado."
				+ "\n\t 4. Acessoria." + "\n\t 5. Cliente."
				+ "\n\t 6. Endereço." + "\n\t 7. Sair do programa."
				+ "\n\n Entre com sua opção: ";

		int opcao = 0;

		boolean flag = false;

		do {

			flag = true;

			opcao = Util.validarInt(MENU);

			switch (opcao) {

			case 1: // Pesquisar por Departamento

				pesquisarDepartamento();

				break;

			case 2: // Pesquisar por Projeto

				pesquisarProjeto();

				break;

			case 3: // Pesquisar por Empregado

				pesquisarEmpregado();

				break;

			case 4: // Pesquisar por Acesssoria

				pesquisarAcessoria();

				break;

			case 5: // Pesquisar por Cliente

				pesquisarCliente();

				break;

			case 6: // Pesquisar por Endereço

				pesquisarEndereco();

				break;

			case 7: // Sair do programa

				flag = false;

			}

		} while (flag);

		System.out.println(" FIM DO PROGRAMA.");

	}

	public static void pesquisarDepartamento() {

		PersistenciaDepartamento persistenicaDepartamento = new PersistenciaDepartamento();

		int codigo = Util.validarInt("Entre com o código do Departamento: ");

		Departamento departamento = persistenicaDepartamento.pesquisar(codigo);

		if (departamento != null) {

			System.out.println(departamento.toString());

		} else {

			System.out
					.println("Não foi possível localizar o Departamento código: "
							+ codigo);
		}

		String nome = Util.validarString("Entre com um nome de departamento: ");

		List<Departamento> resultado = persistenicaDepartamento.pesquisar(nome);

		if (resultado != null && resultado.size() > 0) {

			for (Departamento depto : resultado) {

				System.out.println("\n Nome do Departamento: "
						+ depto.getNomeDepartamento());

			}

		} else {

			System.out
					.println("\n Não foi possível localicar Departamento com nome = '"
							+ nome + "'.");
		}

		Integer ultimoID = persistenicaDepartamento.pesquisar();

		if (ultimoID != null) {

			System.out
					.println("\n ID do último registro inserido: " + ultimoID);

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}

	public static void pesquisarProjeto() {

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		Integer codigo = new Integer(
				Util.validarInt("Entre com o código do Projeto: "));

		Projeto projeto = persistenciaProjeto.pesquisar(codigo);

		if (projeto != null) {

			System.out.println(projeto.toString());

		} else {

			System.out.println("Não foi possível localizar o Projeto código: "
					+ codigo);
		}

		String nome = Util.validarString("Entre com um nome de Projeto: ");

		List<Projeto> resultado = persistenciaProjeto.pesquisar(nome);

		if (resultado != null && resultado.size() > 0) {

			for (Projeto proj : resultado) {

				System.out.println("\n Nome do Projeto: "
						+ proj.getNomeProjeto());

			}

		} else {

			System.out
					.println("\n Não foi possível localicar Proejto com nome = '"
							+ nome + "'.");
		}

		Integer ultimoID = persistenciaProjeto.pesquisar();

		if (ultimoID != null) {

			System.out
					.println("\n ID do último registro inserido: " + ultimoID);

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}

	public static void pesquisarEmpregado() {

		PersistenciaEmpregado persistenciaEempregado = new PersistenciaEmpregado();

		Integer codigo = new Integer(
				Util.validarInt("Entre com o código do Departamento: "));

		Empregado empregado = persistenciaEempregado.pesquisar(codigo);

		if (empregado != null) {

			System.out.println(empregado.toString());

		} else {

			System.out
					.println("Não foi possível localizar o Empregado código: "
							+ codigo);
		}

		String nome = Util.validarString("Entre com um nome de Empregado: ");

		List<Empregado> resultado = persistenciaEempregado.pesquisar(nome);

		if (resultado != null && resultado.size() > 0) {

			for (Empregado emp : resultado) {

				System.out.println("\n Nome do Departamento: "
						+ emp.getNomeEmpregado());

			}

		} else {

			System.out
					.println("\n Não foi possível localicar Empregado com nome = '"
							+ nome + "'.");
		}

		Integer ultimoID = persistenciaEempregado.pesquisar();

		if (ultimoID != null) {

			System.out
					.println("\n ID do último registro inserido: " + ultimoID);

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}

	public static void pesquisarAcessoria() {

		PersistenciaAcessoria persistenicaAcessoria = new PersistenciaAcessoria();

		int codigo = Util.validarInt("Entre com o código da Acessoria: ");

		Acessoria acessoria = persistenicaAcessoria.pesquisar(codigo);

		if (acessoria != null) {

			System.out.println(acessoria.toString());

		} else {

			System.out
					.println("Não foi possível localizar o Acessoria código: "
							+ codigo);
		}

		String descricao = Util
				.validarString("Entre com a descrição da acessoria: ");

		List<Acessoria> resultado = persistenicaAcessoria.pesquisar(descricao);

		if (resultado != null && resultado.size() > 0) {

			for (Acessoria access : resultado) {

				System.out.println("\n Descrição da Acessoria: "
						+ access.getDescricaoAcessoria());

			}

		} else {

			System.out
					.println("\n Não foi possível localizar Acessoria com a descrição = '"
							+ descricao + "'.");
		}

		Integer ultimoID = persistenicaAcessoria.pesquisar();

		if (ultimoID != null && ultimoID.intValue() > 0) {

			System.out.println("\n ID do último registro inserido: "
					+ ultimoID.toString());

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}

	public static void pesquisarCliente() {

		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		Integer codigo = Util.validarInt("Entre com o código do Cliente: ");

		Cliente cliente = persistenciaCliente.pesquisar(codigo);

		if (cliente != null) {

			System.out.println(cliente.toString());

		} else {

			System.out.println("Não foi possível localizar o Cliente código: "
					+ codigo);
		}

		String nome = Util.validarString("Entre com um nome do Cliente: ");

		List<Cliente> resultado = persistenciaCliente.pesquisar(nome);

		if (resultado != null && resultado.size() > 0) {

			for (Cliente cli : resultado) {

				System.out.println("\n Nome do Cliente: "
						+ cli.getNomeCliente());

			}

		} else {

			System.out
					.println("\n Não foi possível localizar o Cliente com nome = '"
							+ nome + "'.");
		}

		Integer ultimoID = persistenciaCliente.pesquisar();

		if (ultimoID != null) {

			System.out
					.println("\n ID do último registro inserido: " + ultimoID);

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}

	public static void pesquisarEndereco() {

		PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();

		Integer codigo = new Integer(
				Util.validarInt("Entre com o código do cliente: "));

		Endereco endereco = persistenciaEndereco.pesquisar(codigo);

		if (endereco != null) {

			System.out.println(endereco.toString());

		} else {

			System.out
					.println("Não foi possível localizar o Endereço do cliente código: "
							+ codigo);
		}

		String rua = Util.validarString("Entre com um nome da rua: ");

		List<Endereco> resultado = persistenciaEndereco.pesquisar(rua);

		if (resultado != null && resultado.size() > 0) {

			for (Endereco localizacao : resultado) {

				System.out.println("\n Nome do Departamento: "
						+ localizacao.getRua());

			}

		} else {

			System.out
					.println("\n Não foi possível localicar Endereço pela rua = '"
							+ rua + "'.");
		}

		Integer ultimoID = persistenciaEndereco.pesquisar();

		if (ultimoID != null) {

			System.out
					.println("\n ID do último registro inserido: " + ultimoID);

		} else {

			System.out
					.println("\n Não foi possível pesquisar ID do último registro inserido.");
		}

	}
}
