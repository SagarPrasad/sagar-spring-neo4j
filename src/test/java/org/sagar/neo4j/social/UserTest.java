/**
 * 
 */
package org.sagar.neo4j.social;

import junit.framework.Assert;

import org.junit.Test;
import org.sagar.neo4j.AbstractIntegrationTest;
import org.sagar.neo4j.repository.OfferRepository;
import org.sagar.neo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author A039883
 *
 */
public class UserTest  extends AbstractIntegrationTest {

	@Autowired 
	public UserRepository userRepository;
	
	@Autowired 
	public OfferRepository offerRepository;
	
	@Test
	public void testUser() {
		userRepository.save(new User("U1","User One"));
		Assert.assertEquals(userRepository.findByUserId("U1").getUserName(), "User One");
	}
	
	@Test
	public void testUserOfferRelation(){
		userRepository.save(new User("U1","User 1"));
		userRepository.save(new User("U2","User 2"));
		userRepository.save(new User("U3","User 3"));
		userRepository.save(new User("U4","User 4"));
		userRepository.save(new User("U5","User 5"));
		userRepository.save(new User("U6","User 6"));
		userRepository.save(new User("U7","User 7"));
		
	
		offerRepository.save(new Offer("O1","Offer 1"));
		offerRepository.save(new Offer("O2","Offer 2"));
		offerRepository.save(new Offer("O3","Offer 3"));
		offerRepository.save(new Offer("O4","Offer 4"));
		offerRepository.save(new Offer("O5","Offer 5"));
		offerRepository.save(new Offer("O6","Offer 6"));
		offerRepository.save(new Offer("O7","Offer 7"));
		offerRepository.save(new Offer("O8","Offer 8"));
		
		userRepository.addFriends("U1", "U3");
		userRepository.addFriends("U1", "U4");
		userRepository.addFriends("U1", "U5");
		
		userRepository.addFriends("U2", "U3");
		userRepository.addFriends("U2", "U7");
		
		userRepository.addFriends("U4", "U1");
		userRepository.addFriends("U4", "U3");
		userRepository.addFriends("U4", "U5");
		
		userRepository.addFriends("U6", "U7");
		userRepository.addFriends("U6", "U5");
		
		
		userRepository.addOffers("U1", "O1", 1L);
		userRepository.addOffers("U1", "O2", 1L);
		userRepository.addOffers("U1", "O5", 1L);
		userRepository.addOffers("U1", "O7", 1L);
		
		userRepository.addOffers("U2", "O1", 1L);
		userRepository.addOffers("U2", "O2", 1L);
		userRepository.addOffers("U2", "O4", 1L);
		
		
		userRepository.addOffers("U3", "O5", 1L);
		userRepository.addOffers("U3", "O6", 1L);
		
		userRepository.addOffers("U4", "O4", 1L);
		userRepository.addOffers("U4", "O6", 1L);
		
		
		userRepository.redeemOffers("U1", "O3", 1L);
		userRepository.redeemOffers("U1", "O4", 1L);
		userRepository.redeemOffers("U1", "O5", 1L);
		
		userRepository.redeemOffers("U2", "O1", 1L);
		userRepository.redeemOffers("U2", "O5", 1L);
		
		userRepository.redeemOffers("U3", "O3", 1L);
		userRepository.redeemOffers("U3", "O4", 1L);
		userRepository.redeemOffers("U3", "O5", 1L);
		
		userRepository.redeemOffers("U4", "O1", 1L);
		userRepository.redeemOffers("U4", "O3", 1L);
		userRepository.redeemOffers("U4", "O4", 1L);
		userRepository.redeemOffers("U4", "O7", 1L);
		
		
		printAddOffers(userRepository.findByUserId("U1"));
		printRedeemOffers(userRepository.findByUserId("U1"));
		printFriends(userRepository.findByUserId("U1"));
		
		printOffersDetails(offerRepository.findByOfferId("O1"));
		printOffersDetails(offerRepository.findByOfferId("O3"));
	}
	
	@Test
	public void testCreateUser() {
		for(long i=0; i < 50000; i++){
			System.out.println("-" + i);
			userRepository.save(new User("U"+i,"User "+i));
		}
	}
	
	private void printAddOffers(User user) {
		System.out.println("User (Add Offer) --" + user.getUserName());
		for(Add addoffer : user.getAddOffers()) {
			System.out.println("-- Add Offer --" + addoffer.getOffer().getOfferTitle() + ":" + addoffer.getUser().getUserName());
		}
	}

	private void printRedeemOffers(User user) {
		System.out.println("User (Redeem Offer) --" + user.getUserName());
		for(Redeem redemOffer : user.getRdmOffers()) {
			System.out.println("-- Redeem Offers --" + redemOffer.getOffer().getOfferTitle()+ ":" + redemOffer.getUser().getUserName());
		}
	}

	private void printFriends(User user) {
		System.out.println("User (Friends) --" + user.getUserName());
		for(User friends : user.getFriends()) {
			System.out.println("-- Friends --" + friends.getUserName());
		}
	}
	
	private void printOffersDetails(Offer offer) {
		System.out.println("Offer (Details) --" + offer.getOfferTitle());
		for(Add add : offer.getAdd()) {
			System.out.println("-- Add User --" + add.getUser().getUserName());
		}
		
		for(Redeem redeem : offer.getRedeem()) {
			System.out.println("-- Redeem User --" + redeem.getUser().getUserName());
		}
	}
}
