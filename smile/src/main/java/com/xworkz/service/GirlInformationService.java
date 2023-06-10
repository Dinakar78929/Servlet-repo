package com.xworkz.service;

import java.util.List;

import com.xworkz.entity.GirlInformationEntity;
import com.xworkz.repository.GirlInformationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GirlInformationService {

	private GirlInformationRepository repo;

	public GirlInformationService() {
		System.out.println("GirlInformationService");
	}

	public boolean validateAndSave(GirlInformationEntity gentity) {
		boolean save = false;
		if (gentity != null) {
			save = this.repo.onSave(gentity);
			return save;
		}
		return save;
	}

	public GirlInformationEntity findById(int id) {
		System.out.println("Running GirlInformationEntity find by Id");
		GirlInformationEntity greference = this.repo.findbyId(id);
		return greference;
	}

	public List<GirlInformationEntity> findAll() {
		return this.repo.findAll();
	}

	public List<GirlInformationEntity> findByName(String name) {
		return this.repo.findByName(name);
	}

	public boolean updateById(String name, int id) {
		return this.repo.update(name, id);
	}

	public boolean delete(int id) {
		return this.repo.delete(id);
	}

	public List<GirlInformationEntity> findAllLocation(String location) {
		return this.repo.findAllLocation(location);
	}
	
	public boolean deleteByName(String name ) {
		return this.repo.deleteByName(name);
	}
}
