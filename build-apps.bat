call mvn clean package -f ./BookingService/pom.xml
call mvn clean package -f ./MovieService/pom.xml
call mvn clean package -f ./TheatreService/pom.xml
cd WebUI
call ng build --prod