/**
 * 
 */
package org.sagar.neo4j.social;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * @author A039883
 *
 */
@RelationshipEntity(type="ADD")
public class Add extends AbstractEntity{
	public User getUser() {
		return user;
	}
	public Offer getOffer() {
		return offer;
	}
	public long getDate() {
		return date;
	}
	
	public Add(){
	}
	
	public Add(User user, Offer offer){
		this.user = user;
		this.offer = offer;
	}
	
	@Fetch @StartNode User user;
	@Fetch @EndNode Offer offer;
	long date;
}
