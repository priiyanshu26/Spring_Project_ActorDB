package com.jsp.springboot.actordb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actordb.Repositary.ActorRepositary;
import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponseStructure;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepositary actorRepositary;
	
	
	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) {
		
		Actor actor2 = actorRepositary.save(actor);
		ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor object is created");
		responseStructure.setActor(actor2);
		
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors() {
		
		List<Actor> actors =  actorRepositary.findAll();

		if (actors.isEmpty()) {
			return null;
		} else {
			ResponseStructure<List<Actor>> responseStructure = new ResponseStructure<List<Actor>>();
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
			responseStructure.setMessage("All Actors are displayed !!");
			responseStructure.setActor(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure, HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId) {
		Optional<Actor> optional=actorRepositary.findById(actorId);
		if(optional.isEmpty()) {
			//throw new ActorNotFoundByIdException("Actor not found");
			return null;
		}
		else {
			Actor actor=optional.get();
			ResponseStructure<Actor> responseStructure = new ResponseStructure<Actor>();
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Actor is Finded");
			responseStructure.setActor(actor);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure, HttpStatus.FOUND);
		}
	
	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId) {
		
		Optional<Actor> optional = actorRepositary.findById(actorId);
		if (optional.isPresent()) {
			Actor existingActor = optional.get();
			actorRepositary.delete(existingActor); 
			Actor actor2 = existingActor;

			ResponseStructure<Actor> responseStructure = new ResponseStructure<Actor>();
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Actor is Deleted from the Table");
			responseStructure.setActor(actor2);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure, HttpStatus.FOUND);

		} else {
			return null;
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId, Actor updatedActor) {
		
		Optional<Actor> optional = actorRepositary.findById(actorId);

		if (optional.isPresent()) {
			Actor existingActor = optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			//Actor actor2 = actorRepositary.save(updatedActor);

			ResponseStructure<Actor> responseStructure = new ResponseStructure<Actor>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Object Updated Successfully!!");
			responseStructure.setActor( updatedActor);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure, HttpStatus.OK);

		} else {
			return null;
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(String actorName) {
		
		List<Actor> actors = actorRepositary.findActorByName(actorName);

		if (actors.isEmpty()) {
			return null;
		} else {
			
			ResponseStructure<List<Actor>> responseStructure = new ResponseStructure<List<Actor>>();
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
			responseStructure.setMessage("All Actors are !!");
			responseStructure.setActor(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure, HttpStatus.FOUND);
		}
	}


	@Override
	public List<Actor> findByAge(int age) {
		
		List<Actor> actors = actorRepositary.findByAge(age);

		if (actors.isEmpty()) {
			return null;
		} else {
			return actors;
		}
	}


	@Override
	public List<Actor> findByIndustry(String industry) {
		
		List<Actor> actors = actorRepositary.findByIndustry(industry);

		if (actors.isEmpty()) {
			return null;
		} else {
			return actors;
		}
	}


	@Override
	public List<Actor> findByAgeBetween(int age1, int age2) {
		List<Actor> actors = actorRepositary.findByAgeBetween(age1, age2);

		if (actors.isEmpty()) {
			return null;
		} else {
			return actors;
		}
	}
}
	
	
	
	

