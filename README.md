# Profile Matcher

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Spring Boot](https://spring.io/projects/spring-boot) v3.1.5
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) v17
- [Cassandra](https://cassandra.apache.org/) v4.0.7
- [Elasticsearch](https://www.elastic.co/downloads/elasticsearch) v7.10.2

## Installation

Follow these steps to set up and run the project:

1. **Spring Boot:**

   Ensure you have Spring Boot v3.1.5 installed. You can download it from [spring.io](https://spring.io/projects/spring-boot).

2. **Java:**

   Install Java Development Kit (JDK) version 17. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.

   ```bash
   java -version

3. **Cassandra:**

   Run the following line to run Cassandra on docker :

    ```bash 
   docker run -p 9042:9042 --rm --name cassandra -d cassandra:4.0.7
    ```
   Run the following line to open an interactive shell  to interact with the Cassandra database using the Cassandra Query Language (CQL):
    ```bash
    docker exec -it cassandra bash -c cqlsh -u cassandra -p cassandra
    ```
   Run the following command to create the KEYSPACE for the project:
    ```bash
    CREATE KEYSPACE IF NOT EXISTS spring_cassandra WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};
    ```

4. **ElasticSearch:**

   Run the following command to ElasticSearch on docker:
    ```bash
    docker run --network=profile_matcher --name=elasticsearch-container -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.2
    ```
## Test the API's

Send requests via Postman collection attached profile_matcher.postman_collection.json.


        