/**
 * 
 */
package relacionamento.model.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import relacionamento.model.cliente.Cliente;

/**
 * Classe para representar um endereço de um cliente.
 * 
 * @author Baracho
 * 
 * @since 07/02/2012
 * 
 * @version 1.0
 * 
 */

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3432857192266556711L;

	@Id
	@GeneratedValue(generator = "fk_endereco_cod_cliente")
	@GenericGenerator(name = "fk_endereco_cod_cliente", strategy = "foreign", parameters = @Parameter(name = "property", value = "cliente"))
	@Column(name = "Codigo_Cliente")
	private Integer endereco;

	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;

	@Column(name = "RUA")
	private String rua;

	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	// Função construtora

	public Endereco() {

	}

	public Endereco(String rua, int numero, String bairro, String CEP,
			String cidade, String estado) {

		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(CEP);
		setCidade(cidade);
		setEstado(estado);

	}

	// Métodos de acesso

	/**
	 * @return
	 */
	public Integer getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 */
	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return
	 */
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {

		if (rua != null && !rua.equals("")) {

			this.rua = rua.toUpperCase();

		} else {

			this.rua = null;
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {

		if (bairro != null) {

			this.bairro = bairro.toUpperCase();

		} else {

			this.bairro = null;
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {

		if (cidade != null && !cidade.equals("")) {

			this.cidade = cidade.toUpperCase();

		} else {

			this.cidade = null;
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String uf) {

		if (uf != null && !uf.equals("")) {

			this.estado = uf.toUpperCase();

		} else {

			this.estado = null;
		}
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {

		if (complemento != null && !complemento.equals("")) {

			this.complemento = complemento.toUpperCase();

		} else {

			this.complemento = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String output = null;
		
		output = "\n Codigo Cliente: " + getEndereco().toString();

		output += "\n Rua: " + getRua();

		output += "\n Número: " + getNumero();

		output += "\n Bairro: " + getBairro();

		output += "\n Cidade: " + getCidade();

		output += "\n Estado: " + getEstado();

		output += "\n CEP: " + getCep();

		output += "\n Complemento: " + getComplemento();

		return output;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Endereco clone() {

		Endereco enderecoClone = null;

		try {

			enderecoClone = (Endereco) super.clone();

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enderecoClone.cliente = (Cliente) this.cliente.clone();

		return enderecoClone;
	}

}
