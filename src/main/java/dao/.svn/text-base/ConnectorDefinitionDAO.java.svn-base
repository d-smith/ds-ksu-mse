package dao;

import java.util.List;

import domain.ActivityDefinition;
import domain.ConnectorDefinition;

/**
 * Interface defining data access for Connector Definitions. 
 *
 */
public interface ConnectorDefinitionDAO {
	/**
	 * Get a list of the connector definitions representing the connections in
	 * a process definition graph connected to the specified activity definition.
	 * @param ad Activity definition of interest.
	 * @return List of connector definitions associated with the activity definition of interest.
	 */
	List<ConnectorDefinition> getConnected(ActivityDefinition ad);
	
	/**
	 * Retrieve a connector definition.
	 * @param connectorId Identifier of the connector definition.
	 * @return Connector definition associated with the connectorId if exists, otherwise null.
	 */
	ConnectorDefinition getConnectorDefinition(long connectorId);
	
	/**
	 * Get a list of the connector definitions representing the connections in
	 * a process definition graph connected to the specified activity definition.
	 * @param key Identifier of the activity of interest.
	 * @return  List of connector definitions associated with the activity definition of interest.
	 */
	List<ConnectorDefinition> getConnectedByActivityId(long key);
}
