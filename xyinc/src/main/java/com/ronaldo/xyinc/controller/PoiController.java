/**
 * 
 */
package com.ronaldo.xyinc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldo.xyinc.model.Poi;
import com.ronaldo.xyinc.service.PoiService;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
@RestController
@RequestMapping("/api/poi")
public class PoiController {

	@Autowired
	private PoiService service;
	
	@GetMapping
	public ResponseEntity<List<Poi>> findAll(){
		List<Poi> poi = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(poi);
	}
	
	@GetMapping("/distance")
	public ResponseEntity<List<Poi>> findPoiDistance(Poi poiVM){
		List<Poi> poi = service.findPoiDistance(poiVM);
		return ResponseEntity.status(HttpStatus.OK).body(poi);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Poi poiVM){
		service.save(poiVM);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Poi> findById(@PathVariable("id") Long id){
		Poi poi = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(poi);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Poi> update(@Valid @PathVariable("id") Long id, @RequestBody Poi poiVM){
		Poi poi = service.update(poiVM, id);
		return ResponseEntity.status(HttpStatus.OK).body(poi);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
