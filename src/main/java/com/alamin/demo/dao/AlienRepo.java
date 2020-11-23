package com.alamin.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alamin.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer> {
	
	
	/**
	 * Running Complex Query
	 * 
 List<Alien> findByaName(String aName);
 List<Alien> findByaIdGreaterThan(int aId);
 @Query("from Alien where aName=?1 order by aId")
 List<Alien> findByaNameSorted(String aName);
 */

	
}
