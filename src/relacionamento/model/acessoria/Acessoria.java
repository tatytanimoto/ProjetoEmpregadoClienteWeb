/**
 * 
 */
package relacionamento.model.acessoria;

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
import relacionamento.model.cliente.Cliente;
import relacionamento.model.departamento.Departamento;
import relacionamento.model.empregado.Empregado;



/**
 * Classe para representar uma Acessoria.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Acessoria")
public class Acessoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8219363027918847793L;

	// Variáveis de instância

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQUENCE_ACESSORIA")
	@Column(name = "Codigo_Acessoria")
	private Integer codigoAcessoria;

	// Chave estangeira - refere-se a tabela Cliente
	@ManyToOne
	@JoinColumn(name = "Codigo_Cliente")
	private Cliente cliente;

	// Chave Estrangeira - refere-se a tabela Empregado
	@ManyToOne
	@JoinColumn(name = "Codigo_Empregado")
	private Empregado empregado;

	@Column(name = "Data_Acessoria")
	private Date dataAcessoria;

	@Column(name = "Descricao_Acessoria")
	private String descricaoAcessoria;

//	private Projeto projeto;

	//private Departamento departamento;

	// Função construtora da classe

	public Acessoria() {
		this.empregado = new Empregado();
		this.cliente = new Cliente();
		
	}

	public Acessoria(Date dataAcessoria, String descricaoAcessoria) {

		setDataAcessoria(dataAcessoria);

		setDescricaoAcessoria(descricaoAcessoria);
	}

	// Métodos de acesso

	// Operações da classe

	/**
	 * @return the codigoAcessoria
	 */
	public Integer getCodigoAcessoria() {
		return codigoAcessoria;
	}
	
	//public Departamento getDepartamento() {
	//	return departamento;
	//}
	/**
	 * @param codigoAcessoria
	 *            the codigoAcessoria to set
	 */
	public void setCodigoAcessoria(Integer codigoAcessoria) {

		if (codigoAcessoria != null && codigoAcessoria.intValue() > 0) {

			this.codigoAcessoria = codigoAcessoria;

		} else {

			this.codigoAcessoria = null;
		}
	}

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
	
//	public void setProjeto(Projeto projeto) {
//		this.projeto = projeto;
//	}
//	
	//public void setDepartamento(Departamento departamento) {
	//	this.departamento = departamento;
	//}
	/**
	 * @return the empregado
	 */
	public Empregado getEmpregado() {
		return empregado;
	}

	/**
	 * @param empregado
	 *            the empregado to set
	 */
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	/**
	 * @return the dataAcessoria
	 */
	public Date getDataAcessoria() {
		return dataAcessoria;
	}

	/**
	 * @param dataAcessoria
	 *            the dataAcessoria to set
	 */
	public void setDataAcessoria(Date dataAcessoria) {
		this.dataAcessoria = dataAcessoria;
	}

	/**
	 * @return the descricaoAcessoria
	 */
	public String getDescricaoAcessoria() {
		return descricaoAcessoria;
	}

	/**
	 * @param descricaoAcessoria
	 *            the descricaoAcessoria to set
	 */
	public void setDescricaoAcessoria(String descricaoAcessoria) {

		if (descricaoAcessoria != null) {

			this.descricaoAcessoria = descricaoAcessoria.toUpperCase();

		} else {

			this.descricaoAcessoria = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String saida = null;

		saida = "\n Código Acessoria: " + codigoAcessoria;

		saida += "\n Código do Empregado: " + empregado.getCodigoEmpregado();

		saida += "\n Código do Cliente: " + cliente.getCodigoCliente();

		saida += "\n Data da Acessoria: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(dataAcessoria);

		saida += "\n Descrição da Acessoria: " + descricaoAcessoria;

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
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((codigoAcessoria == null) ? 0 : codigoAcessoria.hashCode());
		result = prime * result
				+ ((dataAcessoria == null) ? 0 : dataAcessoria.hashCode());
		result = prime
				* result
				+ ((descricaoAcessoria == null) ? 0 : descricaoAcessoria
						.hashCode());
		result = prime * result
				+ ((empregado == null) ? 0 : empregado.hashCode());
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
		if (!(obj instanceof Acessoria)) {
			return false;
		}
		Acessoria other = (Acessoria) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (codigoAcessoria == null) {
			if (other.codigoAcessoria != null) {
				return false;
			}
		} else if (!codigoAcessoria.equals(other.codigoAcessoria)) {
			return false;
		}
		if (dataAcessoria == null) {
			if (other.dataAcessoria != null) {
				return false;
			}
		} else if (!dataAcessoria.equals(other.dataAcessoria)) {
			return false;
		}
		if (descricaoAcessoria == null) {
			if (other.descricaoAcessoria != null) {
				return false;
			}
		} else if (!descricaoAcessoria.equals(other.descricaoAcessoria)) {
			return false;
		}
		if (empregado == null) {
			if (other.empregado != null) {
				return false;
			}
		} else if (!empregado.equals(other.empregado)) {
			return false;
		}
		return true;
	}

}
