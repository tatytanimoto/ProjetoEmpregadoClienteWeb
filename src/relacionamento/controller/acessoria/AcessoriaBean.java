/**
 * 
 */
package relacionamento.controller.acessoria;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.cliente.Cliente;
import relacionamento.model.empregado.Empregado;
import relacionamento.persistencia.acessoria.PersistenciaAcessoria;
import relacionamento.persistencia.cliente.PersistenciaCliente;
import relacionamento.persistencia.empregado.PersistenciaEmpregado;


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

@Named("acessoriaBean")
@RequestScoped
public class AcessoriaBean implements Serializable {

	// Variáveis de instância

	private Acessoria acessoria;
	private Integer selectedCliente1;
//	private Integer selectedProjeto1;
//	private Integer selectedDepartamento1;
	private Integer selectedEmpregado;
	
	//private Integer selectedProjeto;
	


	private PersistenciaAcessoria persistenciaAcessoria;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6929357788255347478L;

	/**
	 * 
	 */
	public AcessoriaBean() {
		// TODO Auto-generated constructor stub

		acessoria = new Acessoria();
		

		persistenciaAcessoria = new PersistenciaAcessoria();
	}

	// Métodos de acesso

	/**
	 * @return the acessoria
	 */
	public Acessoria getAcessoria() {
		return acessoria;
	}

	/**
	 * @param acessoria
	 *            the acessoria to set
	 */
	public void setAcessoria(Acessoria acessoria) {
		this.acessoria = acessoria;
	}
	public Integer getSelectedCliente1() {
		return selectedCliente1;
	}
	public void setSelectedCliente1(Integer selectedCliente1) {
		this.selectedCliente1 = selectedCliente1;
	}
	
//	public Integer getSelectedProjeto1() {
//		return selectedProjeto1;
//	}
//	public void setSelectedProjeto1(Integer selectedProjeto1) {
//		this.selectedProjeto1 = selectedProjeto1;
//	}
//	public Integer getSelectedDepartamento1() {
//		return selectedDepartamento1;
//	}
//	public void setSelectedDepartamento1(Integer selectedDepartamento1) {
//		this.selectedDepartamento1 = selectedDepartamento1;
//	}
	public Integer getSelectedEmpregado() {
		return selectedEmpregado;
	}
	public void setSelectedEmpregado(Integer selectedEmpregado) {
		this.selectedEmpregado = selectedEmpregado;
	}
	
	// Operações da classe

	public String salvar() {
		
		PersistenciaCliente persistenciaCliente = new PersistenciaCliente();
		acessoria.setCliente(persistenciaCliente.pesquisar(this.selectedCliente1));
		
//		PersistenciaProjeto persistenciaProjeto = new PersistenciaProjeto();
//		acessoria.setProjeto(persistenciaProjeto.pesquisar(this.selectedProjeto1));
		
//		PersistenciaDepartamento persistenciaDepartamento = new PersistenciaDepartamento();
//		acessoria.setDepartamento(persistenciaDepartamento.pesquisar(this.selectedDepartamento1));
		
		PersistenciaEmpregado persistenciaEmpregado = new PersistenciaEmpregado();
		acessoria.setEmpregado(persistenciaEmpregado.pesquisar(this.selectedEmpregado));
		
		if(acessoria.getCodigoAcessoria() == null) {
			persistenciaAcessoria.salvar(acessoria);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Salvo com sucesso"));
		} else {
			persistenciaAcessoria.atualizar(acessoria);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", "Alterado com sucesso"));

		}
		
		return "cadastrarAcessoria";

	}

	public List<Acessoria> consultarAcessorias() {

		return persistenciaAcessoria.listar();
	}
	
	public List<Cliente> consultarCliente() {
	
		return new PersistenciaCliente().listar();
	}
	
//	public List<Projeto> consultarProjeto() {
//		
//		return new PersistenciaProjeto().listar();
//	}
	
//	public List<Departamento> consultarDepartamento() {
//		
//		return new PersistenciaDepartamento().listar();
//	}
	
	public List<Empregado> consultarEmpregado() {
		
		return new PersistenciaEmpregado().listar();
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
				+ ((acessoria == null) ? 0 : acessoria.hashCode());
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
		if (!(obj instanceof AcessoriaBean)) {
			return false;
		}
		AcessoriaBean other = (AcessoriaBean) obj;
		if (acessoria == null) {
			if (other.acessoria != null) {
				return false;
			}
		} else if (!acessoria.equals(other.acessoria)) {
			return false;
		}
		return true;
	}

}
