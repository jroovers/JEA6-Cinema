# JEA6-Cinema README

> Fontys semester 6 JEA microservices example.

---

## Table of Contents

- [JEA6-Cinema README](#jea6-cinema-readme)
  - [Table of Contents](#table-of-contents)
  - [Architecture](#architecture)
  - [Getting it to run locally](#getting-it-to-run-locally)
    - [Requirements](#requirements)
    - [Building the project](#building-the-project)
    - [Running the project as a docker stack](#running-the-project-as-a-docker-stack)
    - [Accessing the apps](#accessing-the-apps)
    - [Updating your stack](#updating-your-stack)
    - [Stopping your stack](#stopping-your-stack)
  - [Screenshots](#screenshots)

## Architecture

The architecture does not really make sense for the given scenario/use-case but then again it is mostly an exercise to experiment with containerized micro-services, chaining, branching and netflix Hystrix fail-over systems.

![architecture][architecture]

## Getting it to run locally

### Requirements

- Angular CLI
- Maven
- Docker (including compose & swarm if on linux)

And then some additional configuration:

- Docker-machine should have at least 2GB RAM
- domain name 'docker' resolves to your docker VM  
  for example configure your Windows\System32\drivers\etc\hosts file with the following line:  
    ```docker         192.168.99.100```  
    ~or~  
    ```docker         localhost```  
  Not doing this will cause CORS-errors in the frontend.

### Building the project

Run the `build-apps.bat` file. It will:

1. Use maven to build the java projects 
2. Install NPM in the angular project
3. Use angular CLI to build the frontend

**Afterwards**, run the ```build-containers.bat``` file. It will use docker to build and tag the containers in your local container registry.  We are going to run these containers simultaneously in a '*docker swarm*'.

### Running the project as a docker stack

1. Start a new docker swarm with ```docker swarm init```  
if prompted for an IP address to advertise (e.g. using docker toolbox) run ```docker swarm init --advertise-addr 192.168.99.100``` instead.
2. Your docker-machine will automatically be added to the swarm as a *manager*-node
3. Deploy a stack on your new swarm with ```docker stack deploy -c docker-cloud.yml cinema```  
'docker-cloud.yml' is the configuration file. 'cinema' will be the name of the stack.
4. Verify your 'cinema' stack is running with ```docker stack ls```
5. A stack is composed of a collection of 'services'. Verify services have been started with ```docker service ls```
6. Ultimately, services are implemented by containers. Using the good old `docker ps` will also list any containers that have been started.

### Accessing the apps

With default configuration and following the basic setup as described in [Requirements](#requirements) you can access the front-end UI with <http://docker/>. Additionally all the services provide and expose a basic html page (containing a basic hello-world message and a link to their respective REST API). These are a bit out of the way but can be accessed through the following urls:

- <http://docker:8081/BookingService-1.0/>
- <http://docker:8082/MovieService-1.0/>
- <http://docker:8083/TheatreService-1.0/>

### Updating your stack

Perhaps you want to modify the code. You will need to rebuild the project or the specific applications and containers after your changes or else they will not propagate to the stack.

~or~ perhaps you just want to change the configuration of the stack in `docker-cloud.yml` to play around with replicas and docker-composefile settings and how they affect the stack.

> Tip: use `docker stats` to keep track of resource-usage in your docker VM. Do not use more  of memory than that total available RAM in the docker-machine. Strange things will happen as docker will start killing containers and bringing them back up again continuously. (hence the memory limits in the docker-cloud file)

In both cases you will have to run  ```docker stack deploy -c docker-cloud.yml cinema``` again. Only then will the stack be updated.

### Stopping your stack

1. Stop your deployed stack with  ```docker stack rm cinema```
2. Destroy the docker swarm with ```docker swarm leave --force```

## Screenshots

A simple stupid app:
![main screen][mainscreen]

![booking screen][bookingscreen]

[mainscreen]: Images/homepage.png "Main screen"
[bookingscreen]: Images/booking.png "Booking screen"
[architecture]: Images/architecture.png "App architecture"
