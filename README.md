# game-arena
BSADD Game Arena

A gaming platform where bots fight with each other

# Target
We would like to host the next BOT Contest on our own platform.


# Reading Materials

## Docker Essentials

1. [Learn Docker in 12 Minutes](Learn Docker in 12 Minutes](https://www.youtub)e.com/watch?v=YFl2mCHdv24)
2. [Docker crash course](https://www.youtube.com/watch?list=PL4cUxeGkcC9hxjeEtdHFNYMtCpjNBm3h7)
3. [Awesome Docker](https://github.com/veggiemonk/awesome-docker): Useful list of resources for learning and working with Docker

# Quickly see the application running together

1. Install docker and make sure it's running
2. run following command to trigger docker compose to start the application
```shell
make docker-compose
```

# Development

## BackendAPI Development
1. Install Maven
2. Install jdk17
3. Install docker (needed for test containers)
4. Run following maven command to see if the build system is working on your machine. It'll compile the code and run the tests using testcontainers.
```shell
mvn package
```
5. Start exploring the codes in `src/main/java`


## Frontend application development
1. to be written