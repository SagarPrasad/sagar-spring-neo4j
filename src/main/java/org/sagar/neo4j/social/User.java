/**
 * 
 */
package org.sagar.neo4j.social;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.template.Neo4jOperations;

/**
 * @author Sagar
 *
 */
@NodeEntity
@TypeAlias("User")
public class User extends AbstractEntity {

	protected User() {
	}

	public User(String userId, String userName) {
		this.setUserId(userId);
		this.setUserName(userName);
	}

	@Indexed(unique = true)
	private
	String userId;

	private String userName;
	
	// Change code
	@RelatedToVia(type = "ADD")
	private Set<Add> addOffers;

	@RelatedToVia(type = "REDEEM")
	private Set<Redeem> rdmOffers;
	
	@RelatedTo(type = "FRIENDS", direction = Direction.BOTH)
	@Fetch
	private Set<User> friends;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the addOffers
	 */
	public Set<Add> getAddOffers() {
		return addOffers;
	}

	/**
	 * @param addOffers the addOffers to set
	 */
	public void setAddOffers(Set<Add> addOffers) {
		this.addOffers = addOffers;
	}

	/**
	 * @return the rdmOffers
	 */
	public Set<Redeem> getRdmOffers() {
		return rdmOffers;
	}

	/**
	 * @param rdmOffers the rdmOffers to set
	 */
	public void setRdmOffers(Set<Redeem> rdmOffers) {
		this.rdmOffers = rdmOffers;
	}

	/**
	 * @return the friends
	 */
	public Set<User> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public Add addOffers(Neo4jOperations template, Offer offer, long date) {
		final Add add = template.createRelationshipBetween(this, offer,
				Add.class, "ADD", false);
		return template.save(add);
	}
	
	public Redeem redeemOffers(Neo4jOperations template, Offer offer, long date) {
		final Redeem redeem = template.createRelationshipBetween(this, offer,
				Redeem.class, "REDEEM", false);
		return template.save(redeem);
	}
	
	public User addFriends(User friend){
		if(null == this.getFriends()) {
			this.setFriends(new HashSet<User>());
		}
		this.friends.add(friend);
		return this;
	}
	
}
