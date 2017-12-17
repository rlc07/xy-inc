/**
 * 
 */
package com.ronaldo.xyinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ronaldo.xyinc.model.Poi;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
public interface PoiRepository extends JpaRepository<Poi, Long> {

	/**
	 * @param coordinate_x
	 * @param coordinate_y
	 * @param d_max
	 * @return
	 */
	@Query("SELECT p FROM Poi p WHERE (ABS(p.coordinate_x - :coordinate_x) + ABS(p.coordinate_y - :coordinate_y))"
			+ " <= :d_max ")
	List<Poi> findPoiDistance(@Param("coordinate_x") int coordinate_x, @Param("coordinate_y") int coordinate_y,
			@Param("d_max") int d_max);

}
