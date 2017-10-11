package br.com.tt.cliente;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@Column(nullable = false)
	@NotBlank(message = "Nome é informação obrigatória")
	private String nome;
	@Column(length = 14)
	@NotBlank(message = "Cnpj é informação obrigatória")
	@Pattern(regexp = "\\d{14}", message = "Cnpj necessita ter 14 digitos")
	private String cnpj;
	@Temporal(DATE)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date data;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String cnpj, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
