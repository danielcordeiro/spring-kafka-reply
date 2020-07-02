package com.dgc.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerContext {

	@Autowired
	private EmpresaRepository empresaRepository;

	public String[] getTopics() {
		Long id = empresaRepository.findAll().iterator().next().getIdEmpresa();
		StringBuilder buffer = new StringBuilder();
		buffer.append(id.toString()).append(",");
		buffer.append("request1");
		return Arrays.asList(buffer.toString().split(",")).stream().toArray(String[]::new);
	}

}