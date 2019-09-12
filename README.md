# JEA6-Cinema

Fontys semester 6 JEA microservices example.

The architecture does not really make sense for the given scenario/usecase but then again it is mostly an exercise to experiment with small containerized services, chained and branching services and netflix hystrix failover systems.

![architecture][architecture]

## Requirements

- Angular CLI
- Maven
- Docker (including compose & swarm if on linux)
    - docker-machine should have atleast 2GB RAM
- 'docker' domain name resolves to your docker VM
    - for example configure your Windows\System32\drivers\etc\hosts file with the following line:   
    ```docker         192.168.99.100```  
    or  
    ```docker         localhost```  
    Not doing this will cause CORS-errors in the frontend.

## Building the project

Run the `build-apps.bat` file. It will:

1. Use maven to build the java projects 
2. Install NPM in the angular project
3. Use angular CLI to build the frontend

Afterwards, run the build-containers.bat file. It will use docker to build and tag the containers we are going to run.

## Running the project as a docker stack

1. start a new docker swarm with ```docker swarm init```  
if prompted for an IP address to advertise (e.g. using docker toolbox) run ```docker swarm init --advertise-addr 192.168.99.100``` instead.
2. Your docker node will automatically be added to the swarm as a *manager*-node
3. Deploy a stack on your new swarm with ```docker stack deploy -c docker-cloud.yml cinema```  
'docker-cloud.yml' is the configuration file. 'cinema' will be the name of the stack.
4. Verify your 'cinema' stack is running with ```docker stack ls```
5. A stack a collection of 'services'. Verify services have been started with ```docker service ls```

## Updating your stack
Perhaps you want to modify the code. You will need to rebuild the project or the specific applications and containers after your changes or else they will not propagate to the stack.

~or~ perhaps you just want to change the configuration of the stack in `docker-cloud.yml` to play around with replicas and limits and how they affect the stack.

> Tip: use `docker stats` to keep track of resource-usage in your docker VM. Do not use more  of memory than that total available RAM in the docker-machine. Strange things will happen as docker will start killing containers and bringing them back up again continuously. (hence the memory limits in the docker-cloud file)

In both cases you will have to run  ```docker stack deploy -c docker-cloud.yml cinema``` again. Only then will the stack be updated.

## Stopping your stack

1. Stop your deployed stack with  ```docker stack rm cinema```
2. Destroy the docker swarm with ```docker swarm leave --force```

## What does this give me?

A simple stupid app:
![main screen][mainscreen]

![booking screen][bookingscreen]

[mainscreen]: Images/homepage.png "Main screen"
[bookingscreen]: Images/booking.png "Booking screen"
[architecture]: Images/architecture.png "App architecture"

