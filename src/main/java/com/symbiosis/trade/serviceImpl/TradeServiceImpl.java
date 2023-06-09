package com.symbiosis.trade.serviceImpl;
import java.time.LocalDate;
import java.util.List;

import com.symbiosis.trade.Entity.Trade;
import com.symbiosis.trade.repository.TradeRepository;
import com.symbiosis.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	

	public int checkv=0;
	public int checkm=0;
	public TradeServiceImpl(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@Override
	public List<Trade> getAllTrade() {
		// TODO Auto-generated method stub
		List<Trade> list= tradeRepository.findAll();
		for(Trade l:list) {
			updateExpired(l);
		}
		return list;
	}

	@Override
	public Trade saveTrade(Trade t) {
		// TODO Auto-generated method 
		checkv=0;   //variable to throw alert message on webpage when lower version is recieved
		checkm=0;	//variable to throw alert message on webpage when Maturity date is less then today's date
		LocalDate date = LocalDate.now();
		String date2=t.getMatuarityDate();
		LocalDate maturityDate = LocalDate.parse(date2);
		int cv=date.compareTo(maturityDate);
		Trade t2=getTradeById(t.getTradeId());
		
		if(cv>0) {
			checkm=1;
			return null;
		}
		else if(t2!=null && t.getVersion()<t2.getVersion()) {
			checkv=1;
			return null;
		}

		else {
			updateExpired(t);
			return tradeRepository.save(t);
		}
		
	
	}
	
	@Override
	public Trade getTradeById(String s) {
		// TODO Auto-generated method stub
		
		
			return tradeRepository.findById(s).orElse(null);
		
	}

	@Override
	public Trade updateTrade(Trade t) {
		// TODO Auto-generated method stub
		return tradeRepository.save(t);
	}

	@Override
	public void deleteTradeById(String id) {
		// TODO Auto-generated method stub
		tradeRepository.deleteById(id);
		
	}

	@Override
	public void updateExpired(Trade t) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		String date2=t.getMatuarityDate();
		LocalDate maturityDate = LocalDate.parse(date2);
		int cv=date.compareTo(maturityDate);
		if(cv>0) {
			t.setExpired('Y');
		}
		else {
			t.setExpired('N');
		}
		
		
	}
	


	
	

	
	

	

}
