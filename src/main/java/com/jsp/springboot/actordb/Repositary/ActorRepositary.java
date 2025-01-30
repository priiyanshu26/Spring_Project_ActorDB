package com.jsp.springboot.actordb.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot.actordb.entity.Actor;

public interface ActorRepositary extends JpaRepository<Actor, Integer> {

	    //save(Actor a)
		// findById(int actorId)
		// findAll()
		// delete(Actor a)
		// deleteById(int actorId)
	
	 @Query("SELECT a FROM Actor a WHERE a.actorName = ?1")
	   public List<Actor> findActorByName(String actorName); 
	 
	 public List<Actor> findByAge(int age);
	 
	 public List<Actor> findByIndustry(String industry);
	 
	 public List<Actor> findByAgeBetween(int age1, int age2);
}
