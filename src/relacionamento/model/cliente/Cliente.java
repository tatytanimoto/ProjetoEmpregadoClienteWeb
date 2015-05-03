/**
 * 
 */
package relacionamento.model.cliente;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import relacionamento.model.acessoria.Acessoria;
import relacionamento.model.endereco.Endereco;

/**
 * Classe para representar um Cliente
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6917639163569288827L;

	// Variáveis de instância

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQUENCE_CLIENTE")
	@Column(name = "Codigo_Cliente")
	private Integer codigoCliente;

	// Chave estrangeira - refere-se a tabela Endereco
	@OneToOne
	@PrimaryKeyJoinColumn(name = "Codigo_Cliente")
	private Endereco endereco;

	// Mapeamento bidirecional - ambas as classes podem ser utilizadas.
	// Tanto Acessoria utiliza Cliente com Cliente utiliza Acessoria.
	@OneToMany(mappedBy = "cliente")
	private List<Acessoria> acessorias;

	@Column(name = "Nome_Cliente")
	private String nomeCliente;

	@Column(name = "Telefone")
	private String telefone;

	// Função construtora

	public Cliente() {

	}

	public Cliente(String nomeCliente, String telefone) {

		setNomeCliente(nomeCliente);

		setTelefone(telefone);
	}

	// Métodos de acesso

	/**
	 * @return the codigoCliente
	 */
	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente
	 *            the codigoCliente to set
	 */
	public void setCodigoCliente(Integer codigoCliente) {

		if (codigoCliente != null && codigoCliente.intValue() > 0) {

			this.codigoCliente = codigoCliente;

		} else {

			this.codigoCliente = null;
		}
	}

	/**
	 * @return the acessorias
	 */
	public List<Acessoria> getAcessorias() {
		return acessorias;
	}

	/**
	 * @param acessorias
	 *            the acessorias to set
	 */
	public void setAcessorias(List<Acessoria> acessorias) {
		this.acessorias = acessorias;
	}

	/**
	 * @return the endereco
	 */
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

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente
	 *            the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String saida = null;

		saida = "\n Código Cliente: " + codigoCliente;

		saida += "\n Nome do Cliente: " + nomeCliente;

		saida += "\n Telefone: " + telefone;

		return saida;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Cliente clone() {

		Cliente clienteClone = null;

		try {

			clienteClone = (Cliente) super.clone();

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clienteClone;
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
				+ ((acessorias == null) ? 0 : acessorias.hashCode());
		result = prime * result
				+ ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (acessorias == null) {
			if (other.acessorias != null) {
				return false;
			}
		} else if (!acessorias.equals(other.acessorias)) {
			return false;
		}
		if (codigoCliente == null) {
			if (other.codigoCliente != null) {
				return false;
			}
		} else if (!codigoCliente.equals(other.codigoCliente)) {
			return false;
		}
		if (endereco == null) {
			if (other.endereco != null) {
				return false;
			}
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		if (nomeCliente == null) {
			if (other.nomeCliente != null) {
				return false;
			}
		} else if (!nomeCliente.equals(other.nomeCliente)) {
			return false;
		}
		if (telefone == null) {
			if (other.telefone != null) {
				return false;
			}
		} else if (!telefone.equals(other.telefone)) {
			return false;
		}
		return true;
	}

}
