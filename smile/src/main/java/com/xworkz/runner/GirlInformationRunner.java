package com.xworkz.runner;

import java.util.List;

import com.xworkz.entity.GirlInformationEntity;
import com.xworkz.repository.GirlInformationRepository;
import com.xworkz.service.GirlInformationService;

public class GirlInformationRunner {

	public static void main(String[] args) {
		GirlInformationEntity girl = new GirlInformationEntity();
		girl.setId(5);
		girl.setAge(25);
		girl.setName("Alia");
		girl.setLocation("shimoga");
		girl.setWeight(60);
		girl.setHeight(5);
		girl.setEducation("LLB");
		System.out.println("entity :" + girl);

		GirlInformationRepository grepo = new GirlInformationRepository();

		GirlInformationService service = new GirlInformationService(grepo);
		// service.validateAndSave(girl);
//
//		//service.findById(2);
//		List<GirlInformationEntity> list = service.findAll();
//		//System.out.println(list.toString());
//		
//		for (GirlInformationEntity e : list) {
//			System.out.println("Row:" + e);
//		}

		/*
		 * List<GirlInformationEntity> findNameList =service.findByName("Alia"); for
		 * (GirlInformationEntity e : findNameList) {
		 * System.out.println("find by name row:" + e); }
		 * 
		 * service.updateById("Deepika", 1);
		 * 
		 * service.delete(1);
		 */

//		List<GirlInformationEntity> findNativeList =service.findAllLocation("shimoga");
//		for (GirlInformationEntity location : findNativeList) {
//			System.out.println("find by location row:" + location);
//		}

		System.out.println("Deleted" + " " + service.deleteByName("Alia"));

	}

}
