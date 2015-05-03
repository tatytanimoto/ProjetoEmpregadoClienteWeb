/**
 * 
 */
import java.sql.Date;

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
import relacionamento.util.Util;

/**
 * Programa para cadastrar Projetos;
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

public class MainTesteCadastro {

	public static void main(String[] args) {

		cadastrarDepartamentos();
		cadastrarProjetos();
		cadastrarEmpregados();

		PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();
		Endereco endereco = new Endereco("Rua XV", 1500, "Centro",
				"80.900-400", "Curitiba", "Paraná");

		Cliente cliente = new Cliente("maria da silva", "(41) 3344-5566");
		PersistenciaCliente persistenicaCliente = new PersistenciaCliente();

		cliente.setEndereco(endereco);
		endereco.setCliente(cliente);

		persistenicaCliente.salvar(cliente);
		persistenciaEndereco.salvar(endereco);

		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();
		Acessoria acessoria = new Acessoria();

		acessoria.setDataAcessoria(new Date(Util.convertStringToDate(
				"12/4/2009").getTime()));

		acessoria.setCliente(cliente);

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();
		Empregado empregado = (Empregado) persistenciaEmpregado.pesquisar(1);
		acessoria.setEmpregado(empregado);

		persistenciaAcessoria.salvar(acessoria);

	}

	public static void cadastrarDepartamentos() {

		String departamentos[] = { "Compras", "Vendas", "Informática" };
		Departamento departamento = null;
		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		for (int i = 0; i < departamentos.length; i++) {
			departamento = new Departamento();
			departamento.setNomeDepartamento(departamentos[i]);
			persistenciaDepartamento.salvar(departamento);
		}
	}

	public static void cadastrarProjetos() {

		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();

		String[] projetos = { "Redução de preços", "Melhoria das vendas",
				"Sistemas Web" };

		String[] descricao = {
				"Desenvolver medidas para realizar a redução de custo operacionais",
				"Insentivar o aumento dasd vendas por meio do Depto de Markting.",
				"Migrar o sistema da empresa para Web" };

		Date[] dataInicioProjetos = {
				new Date(Util.convertStringToDate("20/1/2009").getTime()),
				new Date(Util.convertStringToDate("21/2/2010").getTime()),
				new Date(Util.convertStringToDate("22/3/2011").getTime()) };

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();
		Projeto projeto = null;

		for (int i = 0; i < projetos.length; i++) {

			projeto = new Projeto();
			projeto.setNomeProjeto(projetos[i]);
			projeto.setDescricaoProjeto(descricao[i]);
			projeto.setDataInicio(dataInicioProjetos[i]);
			projeto.setDepartamento(persistenciaDepartamento.pesquisar(i + 1));
			persistenciaProjeto.salvar(projeto);
		}
	}

	public static void cadastrarEmpregados() {
		String[] cargos = { "Gerente de Compras", "Supervisor de vendas",
				"Analista" };

		String[] nomes = { "João Cardoso", "Karla Kamurati", "Manoel Pereira" };

		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		Empregado empregado = null;

		for (int i = 0; i < nomes.length; i++) {
			empregado = new Empregado();
			empregado.setNomeEmpregado(nomes[i]);
			empregado.setCargo(cargos[i]);
			empregado.setProjeto(persistenciaProjeto.pesquisar(i + 1));
			persistenciaEmpregado.salvar(empregado);
		}
	}
}
