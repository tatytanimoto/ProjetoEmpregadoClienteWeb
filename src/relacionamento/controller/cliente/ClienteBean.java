/**
 * 
 */
package relacionamento.controller.cliente;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import relacionamento.model.cliente.Cliente;
import relacionamento.model.endereco.Endereco;
import relacionamento.persistencia.cliente.PersistenciaCliente;
import relacionamento.persistencia.endereco.PersistenciaEndereco;


/**
 * Backing Bean para dar suporte às páginas JSF
 * 
 * @author Baracho
 * 
 * @since 31/10/2013
 * 
 * @version 1.0
 * 
 */

@Named("clienteBean")
@RequestScoped
public class ClienteBean implements Serializable {

	// Variáveis de instância

	/**
	 * 
	 */
	private static final long serialVersionUID = 1974744125592589358L;

	private Cliente cliente;

	private PersistenciaCliente persistenciaCliente;

	private Endereco endereco;

	private PersistenciaEndereco persistenciaEndereco;

	/**
	 * 
	 */
	public ClienteBean() {
		// TODO Auto-generated constructor stub

		cliente = new Cliente();

		persistenciaCliente = new PersistenciaCliente();

		endereco = new Endereco();

		persistenciaEndereco = new PersistenciaEndereco();
	}

	// Métodos de acesso

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// Operações da classe

	public String salvar() {
		this.endereco.setCliente(this.cliente);

		if(cliente.getCodigoCliente() == null) {
			
			persistenciaEndereco.salvar(endereco);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Salvo com sucesso"));
		} else {
			persistenciaCliente.atualizar(cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alterado com sucesso"));

		}
		return "cadastrarCliente";
	}

	public List<Cliente> consultarClientes() {

		
		return persistenciaCliente.listar();
	}
	
	public List<Cliente> consultarEndereco() {

		
		return persistenciaCliente.listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClienteBean)) {
			return false;
		}
		ClienteBean other = (ClienteBean) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (endereco == null) {
			if (other.endereco != null) {
				return false;
			}
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		return true;
	}

}
