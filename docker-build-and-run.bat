call mvn clean install

call docker rm -f ms-credentials-manager

call docker image rm darren/ms-credentials-manager

call docker build . -t darren/ms-credentials-manager

call docker run -d --name ms-credentials-manager -p 8092:8080 darren/ms-credentials-manager
