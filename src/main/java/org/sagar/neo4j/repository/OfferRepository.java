package org.sagar.neo4j.repository;

import org.sagar.neo4j.social.Offer;
import org.sagar.neo4j.social.helper.OfferService;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository  extends GraphRepository<Offer>, OfferService {
	Offer findByOfferId(String offerId);
}
