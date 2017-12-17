/**
 * 
 */
package com.ronaldo.xyinc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ronaldo.xyinc.model.Poi;
import com.ronaldo.xyinc.repository.PoiRepository;
import com.ronaldo.xyinc.service.exception.CoordinateInvalidException;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
@Service
public class PoiService {

	@Autowired
	private PoiRepository repository;
	
	/*
	 * LISTA TODOS POI
	 */
	public List<Poi> findAll(){
		return repository.findAll();
	}
	
	/*
	 * SALVA POI
	 */
	@Transactional(rollbackOn = Exception.class)
	public void save(Poi poiVM){
		poiVM.setPoi_id(null);
		validateCoordinate(poiVM.getCoordinate_x(), poiVM.getCoordinate_y());
		repository.save(poiVM);
	}
	
	/*
	 * ATUALIZA POI
	 */
	@Transactional(rollbackOn = Exception.class)
	public Poi update(Poi poiVM, Long id){
		validateCoordinate(poiVM.getCoordinate_x(), poiVM.getCoordinate_y());
		Poi poi = findByPoiId(id);
		BeanUtils.copyProperties(poiVM, poi, "poi_id");
		return repository.save(poiVM);
	}
	
	/*
	 * ENCONTRA POI POR ID
	 */
	public Poi findById(Long id){
		Poi poi = findByPoiId(id);
		return poi;
	}
	
	/*
	 * DELETA POI
	 */
	@Transactional(rollbackOn = Exception.class)
	public void delete(Long id){
		Poi poi = findByPoiId(id);
		repository.delete(poi);
	}
	
	/*
	 * LISTA POI POR DISTANCIA
	 */
	public List<Poi> findPoiDistance(Poi poiVM){
		return repository.findPoiDistance(poiVM.getCoordinate_x(), poiVM.getCoordinate_y(),
				poiVM.getD_max());
	}
	
	
	

	/****** METODOS PRIVADOS *************/
	
	/**
	 * @param id
	 * @return
	 */
	private Poi findByPoiId(Long id) {
		Poi poi = repository.findOne(id);
		
		if(poi == null || poi.getDelete_date() != null) {
			throw new EmptyResultDataAccessException(1);
		}
		return poi;
	}
	
	private void validateCoordinate(int x, int y) {
				
		if(x <= 0 || y <= 0) {
			throw new CoordinateInvalidException(null);
		}		
	}
}
