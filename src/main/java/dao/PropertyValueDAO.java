package dao;

import java.util.List;

import domain.FieldData;

/**
 * Data access for property values.
 *
 */
public interface PropertyValueDAO {
	/**
	 * Retrieve a list of process instance ids that contain the given values of 
	 * the fields supplied as an argument to this method.
	 * @param fields Fields specifying property value match constraints.
	 * @return List of process instance ids that have matching properties.
	 */
	List<Long> findInstancesByPropertyValues(List<FieldData> fields); 
}
