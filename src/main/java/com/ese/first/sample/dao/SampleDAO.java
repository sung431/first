package com.ese.first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ese.first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		return (List<Map<String,Object>>)selectList("sample.selectMemberList", map);
	}

	public void insertMember(Map<String, Object> map) {
		insert("sample.insertMember", map);
	}
	
}
