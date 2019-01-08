package com.springboot.virtualnugetts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.springboot.virtualnugetts.family.VirtualNuggets;
import com.springboot.virtualnugetts.repository.VirtualNuggetsRepository;

@Service
@CacheConfig(cacheNames = "virtualNuggets")
public class VirtualNuggetsService {

	@Autowired
	VirtualNuggetsRepository repo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable
	public List<VirtualNuggets> getAllVc() {

		List<VirtualNuggets> list = repo.findAll();
		logger.info("Getting all VirtulNuggets");
		return list;

	}

	public void createVc(VirtualNuggets nuggets) {
		logger.info("Adding Nugetts to the Table");
		repo.save(nuggets);
	}

	public List<VirtualNuggets> getByUserName(String userName) {
		if (userName == null) {
			logger.info("Username can not be Null");
			return null;
		} else {
			logger.info("Getting  VirtulNuggets by UserName");
			return repo.getVcByUserName(userName);
		}
	}

	public VirtualNuggets updateById(VirtualNuggets cnugetts) {
		logger.info("VirtulNuggets Updated Sucessfully");
		return repo.save(cnugetts);
		
	}

	public void deleteById(Integer id) {
		logger.info("Deleting VC  Sucessfully");
		repo.delete(id);
		
	}

}
