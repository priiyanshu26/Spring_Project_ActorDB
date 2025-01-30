package com.jsp.springboot.actordb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.utility.ResponseStructure;


public interface ActorService {

	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor); 
	
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors();
	
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId, Actor updatedActor);
	
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(String actorName);
	
	public List<Actor> findByAge(int age);
	
	public List<Actor> findByIndustry(String industry);
	
	public List<Actor> findByAgeBetween(int age1, int age2);
	
	
}
