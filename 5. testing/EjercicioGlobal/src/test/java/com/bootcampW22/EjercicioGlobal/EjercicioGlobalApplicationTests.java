package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EjercicioGlobalApplicationTests {

	IVehicleService service;

	public EjercicioGlobalApplicationTests(VehicleServiceImpl service){
		this.service = service;
	}



	@Test
	void findAllOkTest() {
		int sizeExpected = 50;

		//ACT
		List<VehicleDto> result = service.searchAllVehicles();

		//ASSERT
		Assertions.assertEquals(sizeExpected,result.size());
	}

	@Test
	void findAllEmptyListTest() {
	}

}
