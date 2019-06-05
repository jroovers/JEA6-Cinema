call mvn clean package -f ./BookingService/pom.xml
call mvn clean package -f ./MovieService/pom.xml
call mvn clean package -f ./TheatreService/pom.xml
cd WebUI
call ng build --prod
cd ..
call docker build -t cinema/bookingservice:latest ./BookingService/
call docker build -t cinema/movieservice:latest ./MovieService/
call docker build -t cinema/theatreservice:latest ./TheatreService/
call docker build -t cinema/frontend:latest ./WebUI/