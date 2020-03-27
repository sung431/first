package com.ese.first.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selsectMemberList(Map<String, Object> map) throws Exception;

	void insertMember(Map<String, Object> map) throws Exception;

}
