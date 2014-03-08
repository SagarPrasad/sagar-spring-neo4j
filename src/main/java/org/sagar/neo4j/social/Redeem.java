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
@RelationshipEntity(type="REDEEM")
public class Redeem extends AbstractEntity{
	public Redeem(User user, Offer offer) {
		this.user = user;
		this.offer = offer;
	}
	
	public Redeem() {
	}
	
	public User getUser() {
		return user;
	}
	public Offer getOffer() {
		return offer;
	}
	public long getDate() {
		return date;
	}
	
	@Fetch @StartNode User user;
	@Fetch @EndNode Offer offer;
	long date;
}
