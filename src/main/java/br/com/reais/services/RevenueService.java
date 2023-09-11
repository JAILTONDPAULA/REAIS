package br.com.reais.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.OriginIncome;
import br.com.reais.entities.Revenue;
import br.com.reais.enums.MultiOption;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.OriginIncomeRepository;
import br.com.reais.repositories.RevenueRepository;

@Service
public class RevenueService {
	@Autowired
	private RevenueRepository conn;
	@Autowired
	private OriginIncomeRepository oconn;
	
	public Revenue findById(Long id) {
		Optional<Revenue> revenue = conn.findById(id);
		return revenue.orElseThrow(()->new NotFound("ERROR:R001BE<br>Receita não encontrada"));
	}	
	
	public List<Revenue> findAll(){
		List<Revenue> list = conn.findAllByOrderByYearDescMonthDescRegistrationDateDesc();
		
		if(list == null) {
			new NotFound("ERROR:R006BE<br>Receitas não encontrada");
		}
		
		return list;
	}
	
	public Revenue save(String origem,Double valor,LocalDate data,Integer ano,Integer mes,String monthly,String observation) {
		
		MultiOption m = MultiOption.toEnum(monthly.charAt(0));
		
		OriginIncome oi = oconn.findByDescription(origem);
		if(oi == null) {
			oi = new OriginIncome(null,origem);
		}
		Revenue re = new Revenue(null,ano,mes,valor,observation,data,m);
		re.setOrigin(oi);
		return conn.save(re);
	}
	
	public Revenue update(String id,String origem,Double valor,LocalDate data,Integer ano,Integer mes,String monthly,String observation) {
		MultiOption m = MultiOption.toEnum(monthly.charAt(0));
		
		OriginIncome oi = oconn.findByDescription(origem);
		if(oi == null) {
			oi = new OriginIncome(null,origem);
		}

		Revenue rev = this.findById(Long.parseLong(id));
		rev.setMonth(mes);
		rev.setYear(ano);
		rev.setObservation(observation);
		rev.setRegistrationDate(data);
		rev.setValue(valor);
		rev.setMonthly(m);
		rev.setOrigin(oi);
		
		return conn.save(rev);
	}
	
	public void delete(Long id) {
		Revenue rev = this.findById(id);
		conn.delete(rev);
	}
}
