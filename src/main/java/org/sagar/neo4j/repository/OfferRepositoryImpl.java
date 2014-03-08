/**
 * 
 */
package org.sagar.neo4j.repository;

import org.sagar.neo4j.social.helper.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

/**
 * @author spras3
 *
 */
public class OfferRepositoryImpl implements OfferService {
	
	@Autowired
    private Neo4jOperations template;

	/*public int getAllAddCountByOfferId(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAllRedeemCountByOfferId(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAllAddUserByOfferId(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAllRedeemByOfferId(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	/*public Offer getOfferByOfferId(String offerId) {
		 return template.lookup(Offer.class,"offerId", offerId).to(Offer.class).singleOrNull();
	}*/

}
