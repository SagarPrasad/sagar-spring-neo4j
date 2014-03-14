/**
 * 
 */
package org.sagar.neo4j.social;

import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

/**
 * @author A039883
 * 
 */
@NodeEntity
@TypeAlias("Offer")
public class Offer extends AbstractEntity {

	@Indexed(unique = true)
	String offerId;

	String offerTitle;
	
	@RelatedToVia(type = "ADD", direction = Direction.INCOMING)
	private
	Set<Add> add;
	
	@RelatedToVia(type = "REDEEM", direction = Direction.INCOMING)
	private
	Set<Redeem> redeem;
	
	protected Offer(){
	}
	
	public Offer(String offerId, String offerTitle) {
		this.offerId = offerId;
		this.offerTitle = offerTitle;
	}

	public String getOfferId() {
		return offerId;
	}

	public String getOfferTitle() {
		return offerTitle;
	}

	public Set<Add> getAdd() {
		return add;
	}

	public void setAdd(Set<Add> add) {
		this.add = add;
	}

	public Set<Redeem> getRedeem() {
		return redeem;
	}

	public void setRedeem(Set<Redeem> redeem) {
		this.redeem = redeem;
	}

}
