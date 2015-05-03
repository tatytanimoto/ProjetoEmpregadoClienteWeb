/**
 * 
 */
package relacionamento.model.empregado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import relacionamento.model.projeto.Projeto;

/**
 * Classe para representar um Empregado.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Empregado")
public class Empregado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2612835452466826133L;

	// Variáveis de instância

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQUENCE_EMPREGADO")
	@Column(name = "Codigo_Empregado")
	private Integer codigoEmpregado;

	// Chave estrangeira - refere-se a tabela Projeto
	@ManyToOne
	@JoinColumn(name = "Codigo_Projeto")
	private Projeto projeto;

	@Column(name = "Nome_Empregado")
	private String nomeEmpregado;

	@Column(name = "Cargo")
	private String cargo;

	// Função construtora da classe

	public Empregado() {
		this.projeto = new Projeto();

	}

	public Empregado(String nomeEmpregado, String cargo) {

		setNomeEmpregado(nomeEmpregado);

		setCargo(cargo);
	}

	// Métodos de acesso

	/**
	 * @return the codigoEmpregado
	 */
	public Integer getCodigoEmpregado() {
		return codigoEmpregado;
	}

	/**
	 * @param codigoEmpregado
	 *            the codigoEmpregado to set
	 */
	public void setCodigoEmpregado(Integer codigoEmpregado) {

		if (codigoEmpregado != null && codigoEmpregado.intValue() > 0) {

			this.codigoEmpregado = codigoEmpregado;

		} else {

			this.codigoEmpregado = null;
		}
	}

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

	/**
	 * @return the nomeEmpregado
	 */
	public String getNomeEmpregado() {
		return nomeEmpregado;
	}

	/**
	 * @param nomeEmpregado
	 *            the nomeEmpregado to set
	 */
	public void setNomeEmpregado(String nomeEmpregado) {
		this.nomeEmpregado = nomeEmpregado;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	// Operações da clase

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String saida = null;

		saida = "\n Código Empregado: " + codigoEmpregado;

		saida += "\n Nome do Empregado: " + nomeEmpregado;

		saida += "\n Cargo: " + cargo;

		saida += "\n Código Projeto: " + projeto.getCodigoProjeto();

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
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result
				+ ((codigoEmpregado == null) ? 0 : codigoEmpregado.hashCode());
		result = prime * result
				+ ((nomeEmpregado == null) ? 0 : nomeEmpregado.hashCode());
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
		if (!(obj instanceof Empregado)) {
			return false;
		}
		Empregado other = (Empregado) obj;
		if (cargo == null) {
			if (other.cargo != null) {
				return false;
			}
		} else if (!cargo.equals(other.cargo)) {
			return false;
		}
		if (codigoEmpregado == null) {
			if (other.codigoEmpregado != null) {
				return false;
			}
		} else if (!codigoEmpregado.equals(other.codigoEmpregado)) {
			return false;
		}
		if (nomeEmpregado == null) {
			if (other.nomeEmpregado != null) {
				return false;
			}
		} else if (!nomeEmpregado.equals(other.nomeEmpregado)) {
			return false;
		}
		if (projeto == null) {
			if (other.projeto != null) {
				return false;
			}
		} else if (!projeto.equals(other.projeto)) {
			return false;
		}
		return true;
	}

}
