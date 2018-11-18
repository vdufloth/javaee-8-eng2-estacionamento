FROM airhacks/glassfish
COPY ./target/eng2-estacionamento.war ${DEPLOYMENT_DIR}
