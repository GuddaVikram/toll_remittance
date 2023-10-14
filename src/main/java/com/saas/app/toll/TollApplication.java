package com.saas.app.toll;

import com.saas.app.toll.orders.dao.TollOrderDAO;
import com.saas.app.toll.orders.entity.TollOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
@SpringBootApplication
public class TollApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TollOrderDAO tollOrderDAO){
		return runner ->{
//			createTollOrder(tollOrderDAO);
//			TollOrder tollOrder = tollOrderDAO.findById(3);
//			System.out.println(tollOrder.getUserId());
//
//			List<TollOrder> list = tollOrderDAO.listOrdersByUserId(1);
//			for(TollOrder tollOrder1: list){
//				System.out.println(tollOrder1.getOrderType());
//			}
//
//			tollOrderDAO.updateOrderStatus("paid",3);

		};
	}

//	private void createTollOrder(TollOrderDAO tollOrderDAO) {
//		TollOrder tollOrder = new TollOrder(1, "REGULAR","created",false, new BigDecimal(0.0));
//		tollOrderDAO.save(tollOrder);
//	}


}
