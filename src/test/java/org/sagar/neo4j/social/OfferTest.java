/**
 * 
 */
package org.sagar.neo4j.social;

import junit.framework.Assert;

import org.junit.Test;
import org.sagar.neo4j.AbstractIntegrationTest;
import org.sagar.neo4j.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author A039883
 *
 */
public class OfferTest  extends AbstractIntegrationTest {

	@Autowired 
	public OfferRepository offerRepository;
	
	@Test
	public void testOffer() {
		offerRepository.save(new Offer("1","Offer One"));
		offerRepository.save(new Offer("2","Offer Two"));
		Assert.assertEquals(offerRepository.findByOfferId("1").getOfferTitle(), "Offer One");
	}
}
