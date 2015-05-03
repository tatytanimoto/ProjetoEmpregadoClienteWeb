/**
 * 
 */
package relacionamento.controller.departamento;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import relacionamento.model.departamento.Departamento;
import relacionamento.persistencia.departamento.PersistenciaDepartamento;

/**
 * Backing Bean para dar suporte às páginas JSF.
 * 
 * @author Baracho
 * 
 * @since 31/10/2013
 * 
 * @version 1.0
 * 
 */

@Named("departamentoBean")
@SessionScoped
@ManagedBean
public class DepartamentoBean implements Serializable {

	// Variáveis de instância

	/**
	 * 
	 */
	private static final long serialVersionUID = -4079207324273127280L;

	private Departamento departamento;
	private String mensagem;
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	private PersistenciaDepartamento persistenciaDepartamento;

	/**
	 * 
	 */
	public DepartamentoBean() {
		// TODO Auto-generated constructor stub

		departamento = new Departamento();

		persistenciaDepartamento = new PersistenciaDepartamento();
	}

	// Métodos de acesso

	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	// Operações da classe

	public String salvar() {
		departamento.getCodigoDepartamento();
		persistenciaDepartamento.salvar(departamento);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "SALVO COM SUCESSO"));
		return "cadastrarDepartamento";
	}

	public List<Departamento> consultarDepartamentos() {

		return persistenciaDepartamento.listar();
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
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result
				+ ((persistenciaDepartamento == null) ? 0 : persistenciaDepartamento.hashCode());
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
		if (!(obj instanceof DepartamentoBean)) {
			return false;
		}
		DepartamentoBean other = (DepartamentoBean) obj;
		if (departamento == null) {
			if (other.departamento != null) {
				return false;
			}
		} else if (!departamento.equals(other.departamento)) {
			return false;
		}
		if (persistenciaDepartamento == null) {
			if (other.persistenciaDepartamento != null) {
				return false;
			}
		} else if (!persistenciaDepartamento.equals(other.persistenciaDepartamento)) {
			return false;
		}
		return true;
	}

}
