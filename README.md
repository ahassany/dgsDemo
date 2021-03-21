# Demo Application for using Netflix's DGS framework with Spring Data Neo4j

This application provides a simple demo to query the Movies DB using GraphQL while mapping Neo4j's objects to GraphQL
objects.


## Requirements
1. Neo4j installation and Movies DB: see https://neo4j.com/developer/example-project/
2. Configure main/resources/application.yml to point correctly to Neo4j DB



## Running
1. Run app: `./gradlew bootRun`
2. Query via `http://localhost:8080/graphiql`
3. Example query:
    ```
    {
      movies (titleFilter: "The Matrix") {
        title
        tagline
          directors {
            name
            born
          }
        actors {
          actor {
            name
            born
          }
          roles
        }
      }
    }
    ```
