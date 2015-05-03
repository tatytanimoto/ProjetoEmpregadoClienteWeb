/**
 * 
 */
package relacionamento.model.projeto;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import relacionamento.model.departamento.Departamento;

/**
 * Classe para representar um Projeto.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Projeto")
public class Projeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7867026807025346352L;

	// Variáveis de instância

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQUENCE_PROJETO")
	@Column(name = "Codigo_Projeto", nullable = false)
	private Integer codigoProjeto;

	// Chave estrangeira - refere-se à tabela Departamento
	@ManyToOne
	@JoinColumn(name = "Codigo_Departamento")
	private Departamento departamento;

	@Column(name = "Nome_Projeto")
	private String nomeProjeto;

	@Column(name = "Descricao_Projeto")
	private String descricaoProjeto;

	@Column(name = "Data_Inicio")
	private Date dataInicio;
	
	// Função construtora da classe

	public Projeto() {

	}

	public Projeto(String nomeProjeto, String descricaoProjeto, Date dataInicio) {

		setNomeProjeto(nomeProjeto);

		setDescricaoProjeto(descricaoProjeto);

		setDataInicio(dataInicio);
	}

	// Métodos de acesso

	/**
	 * @return the codigoProjeto
	 */
	public Integer getCodigoProjeto() {
		return codigoProjeto;
	}

	/**
	 * @param codigoProjeto
	 *            the codigoProjeto to set
	 */
	public void setCodigoProjeto(Integer codigoProjeto) {

		if (codigoProjeto != null && codigoProjeto.intValue() > 0) {

			this.codigoProjeto = codigoProjeto;

		} else {

			this.codigoProjeto = null;
		}
	}

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

	/**
	 * @return the nomeProjeto
	 */
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	/**
	 * @param nomeProjeto
	 *            the nomeProjeto to set
	 */
	public void setNomeProjeto(String nomeProjeto) {

		if (nomeProjeto != null && !nomeProjeto.equals("")) {

			this.nomeProjeto = nomeProjeto.toUpperCase();

		} else {

			this.nomeProjeto = null;
		}
	}

	/**
	 * @return the descricaoProjeto
	 */
	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}

	/**
	 * @param descricaoProjeto
	 *            the descricaoProjeto to set
	 */
	public void setDescricaoProjeto(String descricaoProjeto) {

		if (descricaoProjeto != null && !descricaoProjeto.equals("")) {

			this.descricaoProjeto = descricaoProjeto;

		} else {

			this.descricaoProjeto = null;
		}
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 *            the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

		saida = "\n Código do Projeto: " + codigoProjeto;

		saida += "\n Código do Departamento: "
				+ departamento.getCodigoDepartamento();

		saida += "\n Nome do Projeto: " + nomeProjeto;

		saida += "\n Descrição do Projeto: " + descricaoProjeto;

		saida += "\n Data de Início: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(dataInicio);

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
				+ ((codigoProjeto == null) ? 0 : codigoProjeto.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime
				* result
				+ ((descricaoProjeto == null) ? 0 : descricaoProjeto.hashCode());
		result = prime * result
				+ ((nomeProjeto == null) ? 0 : nomeProjeto.hashCode());
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
		if (!(obj instanceof Projeto)) {
			return false;
		}
		Projeto other = (Projeto) obj;
		if (codigoProjeto == null) {
			if (other.codigoProjeto != null) {
				return false;
			}
		} else if (!codigoProjeto.equals(other.codigoProjeto)) {
			return false;
		}
		if (dataInicio == null) {
			if (other.dataInicio != null) {
				return false;
			}
		} else if (!dataInicio.equals(other.dataInicio)) {
			return false;
		}
		if (departamento == null) {
			if (other.departamento != null) {
				return false;
			}
		} else if (!departamento.equals(other.departamento)) {
			return false;
		}
		if (descricaoProjeto == null) {
			if (other.descricaoProjeto != null) {
				return false;
			}
		} else if (!descricaoProjeto.equals(other.descricaoProjeto)) {
			return false;
		}
		if (nomeProjeto == null) {
			if (other.nomeProjeto != null) {
				return false;
			}
		} else if (!nomeProjeto.equals(other.nomeProjeto)) {
			return false;
		}
		return true;
	}

}
