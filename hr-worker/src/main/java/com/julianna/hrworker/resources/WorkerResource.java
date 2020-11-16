package com.julianna.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianna.hrworker.entities.Worker;
import com.julianna.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment environment;

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {

		logger.info("CONFIG =" + testConfig);
		
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {

		List<Worker> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

		logger.info("PORT = " + environment.getProperty("local.server.port"));
		
		Worker objeto = repository.findById(id).get();
		
		return ResponseEntity.ok().body(objeto);
	}
}
