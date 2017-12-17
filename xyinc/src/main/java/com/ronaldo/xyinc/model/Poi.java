/**
 * 
 */
package com.ronaldo.xyinc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
@Entity
@Table(name = "poi")
@SQLDelete(sql="UPDATE poi SET delete_date = CURRENT_DATE() WHERE poi_id=?")
@Where(clause ="delete_date IS NULL")
public class Poi extends ApplicationModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long poi_id;
	
	@NotNull(message = "Informe um nome")
	private String name;
	
	private int coordinate_x;
	
	private int coordinate_y;
	
	@Transient
	private int d_max;

	
	public int getD_max() {
		return d_max;
	}

	public void setD_max(int d_max) {
		this.d_max = d_max;
	}

	public Long getPoi_id() {
		return poi_id;
	}

	public void setPoi_id(Long poi_id) {
		this.poi_id = poi_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoordinate_x() {
		return coordinate_x;
	}

	public void setCoordinate_x(int coordinate_x) {
		this.coordinate_x = coordinate_x;
	}

	public int getCoordinate_y() {
		return coordinate_y;
	}

	public void setCoordinate_y(int coordinate_y) {
		this.coordinate_y = coordinate_y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poi_id == null) ? 0 : poi_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (poi_id == null) {
			if (other.poi_id != null)
				return false;
		} else if (!poi_id.equals(other.poi_id))
			return false;
		return true;
	}
	
	

}
