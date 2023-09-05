package br.com.reais.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DESPESA")
public class Expense implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="QUANTIDADE")
	private int quantity;
	@Column(name="VL_UNIDADE")
	private Double unitValue;
	@Column(name="ANO")
	private int  year;
	@Column(name="MES")
	private int month;
	@Column(name="DATA")
	private LocalDate date;
	@Column(name="OBSERVACAO")
	private String observacao;
	@Column(name="FL_FIXO")
	private char fixe;
	
	public Expense() {
		
	}

	public Expense(long id, int quantity, Double unitValue, int year, int month, LocalDate date, String observacao,char fixe) {
		this.id = id;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.year = year;
		this.month = month;
		this.date = date;
		this.observacao = observacao;
		this.fixe = fixe;
	}
	
	public long getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public char getFixo() {
		return fixe;
	}

	public void setFixo(char fixe) {
		this.fixe = fixe;
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
		Expense other = (Expense) obj;
		return id == other.id;
	}
}
