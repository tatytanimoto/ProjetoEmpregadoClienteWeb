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

/**
 * 
 */

/**
 * 
 * 
 * @author Baracho
 * 
 * @since 27/05/2013
 * 
 * @version 1.0
 * 
 */

public class MainTesteListar {

	public MainTesteListar() {

		HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		listarDepartamentos();
		listarProjetos();
		listarEmpregados();
		listarClientes();
		listarEnderecos();
		listarAcessorias();
	}

	public static void listarDepartamentos() {

		// Listar Departamentos

		List<Departamento> departamentos = null;

		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		departamentos = persistenciaDepartamento.listar();

		if (departamentos != null && departamentos.size() > 0) {

			for (Departamento departamento : departamentos) {

				System.out.println(departamento.toString());
			}
		}

	}

	public static void listarProjetos() {

		// Listar Projetos

		List<Projeto> projetos = null;

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		projetos = persistenciaProjeto.listar();

		if (projetos != null && projetos.size() > 0) {

			for (Projeto projeto : projetos) {

				System.out.println(projeto.toString());
			}

		}

	}

	public static void listarEmpregados() {

		// Listar Empregados

		List<Empregado> empregados = null;

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		empregados = persistenciaEmpregado.listar();

		if (empregados != null && empregados.size() > 0) {

			for (Empregado empregado : empregados) {

				System.out.println(empregado.toString());
			}
		}

	}

	public static void listarClientes() {

		// Listar Clientes

		List<Cliente> clientes = null;

		PersistenciaCliente persistenicaCliente = new PersistenciaCliente();

		clientes = persistenicaCliente.listar();

		if (clientes != null && clientes.size() > 0) {

			for (Cliente cliente : clientes) {

				System.out.print(cliente.toString());
				System.out.println(cliente.getEndereco().toString());
			}

		}

	}

	public static void listarEnderecos() {

		// Listar Enderecos

		List<Endereco> enderecos = null;

		PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();

		enderecos = persistenciaEndereco.listar();

		if (enderecos != null && enderecos.size() > 0) {

			for (Endereco endereco : enderecos) {

				System.out.println(endereco.toString());
			}

		} else {

			System.err.println("\n Não foi possível listar os endereços.");
		}

	}

	public static void listarAcessorias() {

		// Listar Acessorias

		List<Acessoria> acessorias = null;

		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();

		acessorias = persistenciaAcessoria.listar();

		if (acessorias != null && acessorias.size() > 0) {

			for (Acessoria acessoria : acessorias) {

				System.out.println(acessoria.toString());
			}

		}

	}

}
