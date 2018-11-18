# Build
mvn clean package && docker build -t eng2/eng2-estacionamento .

# RUN

docker rm -f eng2-estacionamento || true && docker run -d -p 8080:8080 -p 4848:4848 --name eng2-estacionamento eng2/eng2-estacionamento 