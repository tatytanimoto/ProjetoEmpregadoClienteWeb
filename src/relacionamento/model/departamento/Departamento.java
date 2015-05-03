/**
 * 
 */
package relacionamento.model.departamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para representar um Departamento.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Departamento")
public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3794697564992799791L;

	// variáveis de instância

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQUENCE_DEPARTAMENTO")
	@Column(name = "CODIGO_DEPARTAMENTO", nullable = false)
	private Integer codigoDepartamento;

	@Column(name = "NOME_DEPARTAMENTO", length = 20, nullable = false)
	private String nomeDepartamento;

	// Função construtora da classe

	public Departamento() {

	}

	public Departamento(String nomeDepartamento) {

		setNomeDepartamento(nomeDepartamento);
	}

	// Métodos de acesso

	/**
	 * @return the codigoDepartamento
	 */
	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * @param codigoDepartamento
	 *            the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(Integer codigoDepartamento) {

		if (codigoDepartamento != null && codigoDepartamento.intValue() > 0) {

			this.codigoDepartamento = codigoDepartamento;

		} else {

			this.codigoDepartamento = null;
		}
	}

	/**
	 * @return the nomeDepartamento
	 */
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	/**
	 * @param nomeDepartamento
	 *            the nomeDepartamento to set
	 */
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento.toUpperCase();
	}

	// Operações da classe

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String saida = null;

		saida = "\n Código do Departamento: " + codigoDepartamento;

		saida += "\n Nome do Departamento: " + nomeDepartamento;

		return saida;
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
				+ ((codigoDepartamento == null) ? 0 : codigoDepartamento.hashCode());
//		result = prime * result + codigoDepartamento;
		result = prime
				* result
				+ ((nomeDepartamento == null) ? 0 : nomeDepartamento.hashCode());
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
		if (!(obj instanceof Departamento)) {
			return false;
		}
		Departamento other = (Departamento) obj;
		if (codigoDepartamento != other.codigoDepartamento) {
			return false;
		}
		if (nomeDepartamento == null) {
			if (other.nomeDepartamento != null) {
				return false;
			}
		} else if (!nomeDepartamento.equals(other.nomeDepartamento)) {
			return false;
		}
		return true;
	}

}
