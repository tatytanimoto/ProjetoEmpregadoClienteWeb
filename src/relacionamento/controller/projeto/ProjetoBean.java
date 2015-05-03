/**
 * 
 */
package relacionamento.controller.projeto;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import relacionamento.model.departamento.Departamento;
import relacionamento.model.projeto.Projeto;
import relacionamento.persistencia.departamento.PersistenciaDepartamento;
import relacionamento.persistencia.projeto.PersistenciaProjeto;

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

@Named("projetoBean")
@RequestScoped
public class ProjetoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6880104925281079052L;

	// variáveis de instância
	/**
	 * 
	 */

	private Projeto projeto;

	private PersistenciaProjeto persistenciaProjeto;
	private Integer selectedDepartamento;

	public ProjetoBean() {
		// TODO Auto-generated constructor stub

		projeto = new Projeto();

		persistenciaProjeto = new PersistenciaProjeto();
	}

	// Métodos de acesso

	/**
	 * @return the projeto
	 */
	public Projeto getProjeto() {
		return projeto;
	}

	/**
	 * @param projeto
	 *            the projeto to set
	 */
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	// Operações da classe

	public String salvar(){
		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();
		projeto.setDepartamento(persistenciaDepartamento.pesquisar(this.selectedDepartamento));
		if(projeto.getCodigoProjeto() == null) {
			persistenciaProjeto.salvar(projeto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Salvo com sucesso"));
		} else {
			persistenciaProjeto.atualizar(projeto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alterado com sucesso"));

		}
		return "cadastrarProjeto";

		
	}

	public List<Projeto> consultarProjetos() {
			
		return persistenciaProjeto.listar();
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
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
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
		if (!(obj instanceof ProjetoBean)) {
			return false;
		}
		ProjetoBean other = (ProjetoBean) obj;
		if (projeto == null) {
			if (other.projeto != null) {
				return false;
			}
		} else if (!projeto.equals(other.projeto)) {
			return false;
		}
		return true;
	}
	public List<Departamento> listaDepartamento() {
		
		List<Departamento> listaDepartamento;
	    PersistenciaDepartamento a = new PersistenciaDepartamento();
	    
	    listaDepartamento = a.listar();
		return listaDepartamento;
	}

	public Integer getSelectedDepartamento() {
		return selectedDepartamento;
	}

	public void setSelectedDepartamento(Integer selectedDepartamento) {
		this.selectedDepartamento = selectedDepartamento;
	}

	
}
