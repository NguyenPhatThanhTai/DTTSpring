package net.dtt.spring.dao;

import java.util.List;

import net.dtt.spring.entity.Test;

public interface TestDao {
	public List<Test> listTestData() ;
	 
	public void createTestData(String id,String name, String Note);  
}
