package br.com.reais.entities;

import java.io.Serializable;
import java.util.Objects;

public class Revenue implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long    id;
	private String  descricao;
	private Double  valor;
	private Integer ano;
	private Integer mes;
	private String  dataRegistro;
	
	public Revenue() {
		
	}

	public Revenue(Long id, String descricao, Double valor, Integer ano, Integer mes, String dataRegistro) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.ano = ano;
		this.mes = mes;
		this.dataRegistro = dataRegistro;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revenue other = (Revenue) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Revenue [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", ano=" + ano + ", mes=" + mes
				+ ", dataRegistro=" + dataRegistro + "]";
	}
}
