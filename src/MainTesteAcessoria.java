import java.sql.Date;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;
import relacionamento.model.empregado.Empregado;
import relacionamento.persistencia.acessoria.PersistenciaAcessoria;
import relacionamento.persistencia.cliente.PersistenciaCliente;
import relacionamento.persistencia.empregado.PersistenciaEmpregado;
import relacionamento.util.Util;

public class MainTesteAcessoria {

	public static void main(String[] args) {

		PersistenciaAcessoria persistenciaAcessoria = new PersistenciaAcessoria();

		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();

		Cliente cliente = persistenciaCliente.pesquisar(1);

		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();

		Empregado empregado = persistenciaEmpregado.pesquisar(1);

		Acessoria acessoria = new Acessoria();

		acessoria.setDataAcessoria(new Date(Util.convertStringToDate("12/4/2009")
				.getTime()));

		acessoria.setDescricaoAcessoria("acessoria muito boa");

		acessoria.setCliente(cliente);

		acessoria.setEmpregado(empregado);

		persistenciaAcessoria.salvar(acessoria);
		
		if(acessoria != null) {
			
			System.out.println(acessoria.toString());
		}

	}

}
