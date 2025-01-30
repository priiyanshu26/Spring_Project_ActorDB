package com.jsp.springboot.actordb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponseStructure;

@RestController
//@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@PostMapping("/actors")
	public ResponseEntity<ResponseStructure<Actor>> addactor(@RequestBody Actor actor){
		return actorService.addActor(actor);
		
	}
	
	@GetMapping("/actors")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors(){
		return actorService.findAllActors();
		
	}
	
	@GetMapping("/actors/ID")
	public ResponseEntity<ResponseStructure<Actor>> findByActorId( int actorId) {
		return actorService.findByActorId(actorId);
	}
	
	@DeleteMapping("/actors")
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId) {
		return actorService.deleteByActorId(actorId);
	}
	
	
	//@PutMapping("/actors")
	@RequestMapping(value = "/actors" , method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId,@RequestBody Actor updatedActor) {
		return actorService.updateByActorId(actorId, updatedActor);
	}
	
	@GetMapping("actors/name")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName( String actorName){
		return actorService.findByActorName(actorName);
	}
	
	@GetMapping("actors/age")
	public List<Actor> findByAge(int age){
		return actorService.findByAge(age);
	}
	
	@GetMapping("actors/industry")
	public List<Actor> findByIndustry(String industry){
		return actorService.findByIndustry(industry);
	}
	
	
	@GetMapping("actors/between")
	public List<Actor> findByAgeBetween(int age1, int age2){
		return actorService.findByAgeBetween(age1, age2);
	}
}
