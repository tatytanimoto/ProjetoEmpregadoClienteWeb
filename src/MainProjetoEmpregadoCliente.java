import java.sql.Date;
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
 * Programa para implementar uma Locadora d eProjetos.
 * 
 * @author Baracho
 * 
 * @since 08/02/2012
 * 
 * @version 1.0
 * 
 */
public class MainProjetoEmpregadoCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declaração de variáveis

		HibernateUtil.getSessionFactory().openSession();

		String menuPrincipal = null;

		String menuConsulta = null;

		String menuCadastro = null;

		int opcao;

		boolean flag;

		String resposta;

		// inicialização de variáveis

		// Menu Principal

		menuPrincipal = "\n\t Projeto - Menu Principal";

		menuPrincipal += "\n\n\t 1. Acessória.";

		menuPrincipal += "\n\t 2. Consulta.";

		menuPrincipal += "\n\t 3. Cadastro.";

		menuPrincipal += "\n\t 4. Sair do Programa.";

		menuPrincipal += "\n\n\t Entre com a sua opção: ";

		// Menu Cadastro

		menuCadastro = "\n\t Projeto - Menu Cadastro";

		menuCadastro += "\n\n\t 1. Cadastrar Cliente.";

		menuCadastro += "\n\t 2. Cadastrar Projetos.";

		menuCadastro += "\n\t 3. Cadastrar Empregado";

		menuCadastro += "\n\t 4. Cadastrar Departamento";

		menuCadastro += "\n\t 5. Retornar ao Menu Principal.";

		menuCadastro += "\n\n\t Entre com a sua opção: ";

		// Menu Consulta

		menuConsulta = "\n\t Projeto - Menu Consulta";

		menuConsulta += "\n\n\t 1. Acessorias.";

		menuConsulta += "\n\t 2. Clientes.";

		menuConsulta += "\n\t 3. Projetos.";

		menuConsulta += "\n\t 4. Departamentos.";

		menuConsulta += "\n\t 5. Empregados";

		menuConsulta += "\n\t 6. Retornar ao Menu Principal.";

		menuConsulta += "\n\n\t Entre com a sua opção: ";

		// Processamento dos dados

		do {

			opcao = Util.validarInt(menuPrincipal);

			switch (opcao) {

			case 1: // Acessorias

				cadastrarAcessoria();

				break;

			case 2: // Consultas

				flag = true;

				do {

					opcao = Util.validarInt(menuConsulta);

					switch (opcao) {

					case 1: // Acessorias

						consularAcessorias();

						break;

					case 2: // Clientes

						consultarClientes();

						break;

					case 3: // Projetos

						consultarProjetos();

						break;

					case 4: // Departamentos

						consultarDepartamentos();

						break;

					case 5: // Empregados

						consultarEmpregados();

						break;

					case 6: // Retornar ao Menu Principal

						flag = false;

						break;
					}

				} while (flag);

				break;

			case 3: // Cadastros

				flag = true;

				do {

					opcao = Util.validarInt(menuCadastro);

					switch (opcao) {

					case 1: // Cadastrar Cliente

						cadastrarCliente();

						break;

					case 2:// Cadastrar Projeto

						cadastrarProjeto();

						break;

					case 3: // Cadastrar Empregados

						cadastrarEmpregados();

						break;

					case 4: // Cadastrar Departamento

						cadastrarDepartamento();

						break;

					case 5: // Retornar ao Menu Principal

						flag = false;

					}

				} while (flag);

				break;

			case 4: // Sair do programa

				resposta = Util.validarString("\n\t Sair do Programa (S/N)? ")
						.toUpperCase();

				if (resposta.charAt(0) == 'S') {

					System.out.println("\n\t FIM DO PROGRAMA.");

					System.exit(0);

				}

				break;
			}

		} while (true);
	}

	/**
	 * Método para consultar acessorias.
	 * 
	 * 02/06/2013
	 */
	public static void consularAcessorias() {

		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();

		List<Acessoria> resultado = persistenciaAcessoria.listar();

		if (resultado != null && resultado.size() > 0) {

			for (Acessoria acessoria : resultado) {

				System.out.println(acessoria.toString());

			}
		}
	}

	/**
	 * Método para consultar clientes.
	 * 
	 * 02/06/2013
	 */
	public static void consultarClientes() {

		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		List<Cliente> resultado = persistenciaCliente.listar();

		if (resultado != null && resultado.size() > 0) {

			for (Cliente cliente : resultado) {

				System.out.println(cliente.toString());
			}
		}
	}

	/**
	 * Método para consultar projetos.
	 * 
	 * 02/06/2013
	 */
	public static void consultarProjetos() {

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		List<Projeto> resultado = persistenciaProjeto.listar();

		if (resultado != null && resultado.size() > 0) {

			for (Projeto Projeto : resultado) {

				System.out.println(Projeto.toString());
			}
		}
	}

	/**
	 * Método para consultar Departamentos.
	 * 
	 * 02/06/2013
	 */
	public static void consultarDepartamentos() {

		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		List<Departamento> resultado = persistenciaDepartamento.listar();

		if (resultado != null && resultado.size() > 0) {

			for (Departamento Departamento : resultado) {

				System.out.println(Departamento.toString());
			}
		}
	}

	/**
	 * Método para consultar Empregados.
	 * 
	 * 02/06/2013
	 */
	public static void consultarEmpregados() {

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		List<Empregado> resultado = persistenciaEmpregado.listar();

		if (resultado != null && resultado.size() > 0) {

			for (Empregado empregado : resultado) {

				System.out.println(empregado.toString());
			}
		}
	}

	/**
	 * Método para cadastrar Acessoria.
	 * 
	 * 02/06/2013
	 */

	public static void cadastrarAcessoria() {

		// Variáveis de instância

		Acessoria acessoria = null;
		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();

		Cliente cliente = null;
		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		Empregado empregado = null;
		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		Integer codigo = null;

		String strParam = null;

		java.util.Date dataParam = null;

		String resposta = null;

		// Processamento dos dados

		System.out.println("\n\t Clientes Cadastrados: ");

		consultarClientes();

		codigo = Util.validarInt("Entre com o código do cliente: ");

		cliente = persistenciaCliente.pesquisar(codigo);

		if (cliente != null) {

			do {

				codigo = null;

				System.out.println("\n\t Mídias Cadastradas: ");

				consultarEmpregados();

				codigo = Util.validarInt("Entre com o código da mídia: ");

				empregado = persistenciaEmpregado.pesquisar(codigo);

				if (empregado != null) {

					acessoria = new Acessoria();

					strParam = Util
							.validarString("Informe a data da devolução (dd/mm/aaaa): ");

					dataParam = Util.convertStringToDate(strParam);

					if (dataParam != null) {

						acessoria
								.setDataAcessoria(new Date(dataParam.getTime()));

					} else {

						acessoria.setDataAcessoria(null);
					}

					acessoria.setDescricaoAcessoria(Util
							.validarString("Descrição: "));

					acessoria.setCliente(cliente);

					acessoria.setEmpregado(empregado);

					persistenciaAcessoria.salvar(acessoria);

				}

				resposta = Util.validarString("Locar mais Projetos (S/N)? ");

				resposta = resposta.toUpperCase();

			} while (resposta.charAt(0) != 'N');

		} else {

			System.out.println("\n Cliente código = " + codigo
					+ " não localizado.");
		}

	}

	/**
	 * Método para cadastrar Cliente.
	 * 
	 * 02/06/2013
	 */
	public static void cadastrarCliente() {

		Cliente cliente = new Cliente();
		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		Endereco endereco = new Endereco();
		PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();

		cliente.setNomeCliente(Util
				.validarString("Entre com o nome do cliente: "));
		cliente.setTelefone(Util.validarString("Entre com o telefone:  "));

		cliente.setEndereco(endereco);

		cadastrarEndereco(endereco);

		endereco.setCliente(cliente);

		persistenciaCliente.salvar(cliente);

		persistenciaEndereco.salvar(endereco);

	}

	/**
	 * Método para cadastrar Endereço.
	 * 
	 * 02/06/2013
	 */

	public static void cadastrarEndereco(Endereco endereco) {

		endereco.setRua(Util.validarString("Entre com o nome da rua: "));
		endereco.setNumero(Util.validarInt("Entre com o número: "));
		endereco.setBairro(Util.validarString("Entre com o nome do bairro: "));
		endereco.setCep(Util.validarString("Entre com o CEP: "));
		endereco.setCidade(Util.validarString("Entre com o nome da cidade: "));
		endereco.setEstado(Util.validarString("Entre com o nome do Estado: "));
		endereco.setComplemento(Util.validarString("Complemento: "));

	}

	/**
	 * Método para cadastrar Projeto.
	 * 
	 * 02/06/2013
	 */
	public static void cadastrarProjeto() {

		// Declaração de variáveis

		Departamento departamento = null;
		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		Projeto projeto = null;
		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		String strParam = null;
		java.util.Date dataParam;

		// Processamento dos dados

		System.out.println("\n Departamentos Cadastradas:");
		consultarDepartamentos();

		Integer codigo = Util
				.validarInt("\t Informe o código da Departamento: ");

		departamento = persistenciaDepartamento.pesquisar(codigo);

		if (departamento != null) {

			projeto = new Projeto();

			projeto.setDescricaoProjeto(Util
					.validarString("Informe a descrição do Projeto: "));

			strParam = Util
					.validarString("Entre com o ano do Projeto (dd/MM/yyyy) ");

			dataParam = Util.convertStringToDate(strParam);

			if (dataParam != null) {

				projeto.setDataInicio(new Date(dataParam.getTime()));

			} else {

				projeto.setDataInicio(null);
			}

			projeto.setDepartamento(departamento);

			persistenciaProjeto.salvar(projeto);

		}
	}

	/**
	 * Método para cadastrar Empregado.
	 * 
	 * 02/06/2013
	 */
	public static void cadastrarEmpregados() {

		Empregado empregado = null;
		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		Projeto projeto = null;
		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		System.out.println("\n\t Projetos Cadastrados: ");

		consultarProjetos();

		Integer codigo = Util.validarInt("Informe o código do Projeto: ");

		projeto = persistenciaProjeto.pesquisar(codigo);

		if (projeto != null) {

			empregado = new Empregado();

			empregado.setProjeto(projeto);

			persistenciaEmpregado.salvar(empregado);

		}
	}

	/**
	 * Método para cadastrar Departamento.
	 * 
	 * 02/06/2013
	 */
	public static void cadastrarDepartamento() {

		Departamento departamento = new Departamento();

		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		departamento.setNomeDepartamento(Util
				.validarString("informe o nome do departamento: "));

		persistenciaDepartamento.salvar(departamento);

	}
}
