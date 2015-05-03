/**
 * 
 */
package relacionamento.controller.empregado;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import relacionamento.model.empregado.Empregado;
import relacionamento.model.projeto.Projeto;
import relacionamento.persistencia.empregado.PersistenciaEmpregado;
import relacionamento.persistencia.projeto.PersistenciaProjeto;


/**
 * Backing Bean para dar suporte às páginas JSF.
 * 
 * @author Baracho
 * 
 * @since 28/10/2013
 * 
 * @version 1.0
 * 
 */

@Named("empregadoBean")
@SessionScoped
public class EmpregadoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5103373288514466278L;

	// Variáveis de instância
	
	private Empregado empregado;
	
	private PersistenciaEmpregado persistenciaEmpregado;
	private Integer selectedProjeto;

	/**
	 * 
	 */
	public EmpregadoBean() {
		// TODO Auto-generated constructor stub
		
		empregado = new Empregado();
		
		persistenciaEmpregado = new PersistenciaEmpregado();
	}
	
	// Métodos de acesso

	/**
	 * @return the empregado
	 */
	public Empregado getEmpregado() {
		return empregado;
	}

	/**
	 * @param empregado the empregado to set
	 */
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
	// Operações da classe
	
	public String salvar() {
		
		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();
		empregado.setProjeto(persistenciaProjeto.pesquisar(this.selectedProjeto));
		if(empregado.getCodigoEmpregado() == null) {
			persistenciaEmpregado.salvar(empregado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Salvo com sucesso"));
		} else {
			persistenciaEmpregado.atualizar(empregado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alterado com sucesso"));

		}
		return "cadastrarEmpregado";
	}
	
	public Integer getSelectedProjeto() {
		return selectedProjeto;
	}

	public void setSelectedProjeto(Integer selectedProjeto) {
		this.selectedProjeto = selectedProjeto;
	}

	public List<Empregado> consultarEmpregados() {
		
		return persistenciaEmpregado.listar();
	}
	public List<Projeto> listaProjeto() {
		
		List<Projeto> listaProjeto;
	    PersistenciaProjeto p = new PersistenciaProjeto();
	    
	    listaProjeto = p.listar();
		return listaProjeto;
	}
	
}
