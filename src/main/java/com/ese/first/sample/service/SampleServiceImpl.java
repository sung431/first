package com.ese.first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ese.first.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selsectMemberList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectMemberList(map);
	}

	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		sampleDAO.insertMember(map);
	}

}
