Disclamer : Taken the base code from Hubway cycle example

This example consists of 
Neo4j using Spring Data Neo4j
=============================

Some sample queries
--------------------

MATCH (a)-[:`FRIENDS`]-(b) WHERE a.userId='U4' RETURN a,b --> getting friends
MATCH (a)-[:`ADD`]->(b) Where a.userId='U1' RETURN a,b --> All add offers
MATCH (a)-[:`FRIENDS`]-(b)-[:`REDEEM`|:`ADD` ]->(c)<-[:`REDEEM`]-(a) WHERE a.userId='U1' RETURN a,b,c --> getting Redeem offers of all friends
MATCH (a)-[:`FRIENDS`]-(b)-[:`REDEEM`|:`ADD` ]->(c)<-[:`REDEEM`|:`ADD`]-(a) WHERE a.userId='U1' RETURN a,b,c - getting all the adds and redeem of the friends offer on User offer

Still adding lable thru code is not available and will be released in later versions.



