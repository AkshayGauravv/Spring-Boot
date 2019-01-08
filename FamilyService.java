package com.springboot.virtualnugetts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.springboot.virtualnugetts.exception.ResponseNotFoundException;
import com.springboot.virtualnugetts.family.Family;
import com.springboot.virtualnugetts.repository.FamilyRepository;

@Service
public class FamilyService {

	@Autowired
	FamilyRepository repository;

	@Autowired
	RabbitTemplate rabbitTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Family> getAllFamily() {

		List<Family> family = repository.findAll();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = ow.writeValueAsString(family);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error("Json Exception");
		}
		rabbitTemplate.convertAndSend("familyExchange", "familyRoute", json);
		logger.info("Getting whole VirtulNuggets");
		return family;
	}

	public Family addFamily(Family family) throws ResponseNotFoundException {
		logger.info("Adding whole VirtulNuggets");
		Family fam = repository.findByparents(family.getParents());
		if (fam != null && fam.getParents().equals(family.getParents())) {
			logger.error("Parents already exisit of this name" + family.getParents());
			throw new ResponseNotFoundException("Parents already exisit of this name " + family.getParents());
		} else {
			return repository.save(family);
		}

	}

}
