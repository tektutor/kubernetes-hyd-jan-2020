You need to compile the maven project and create the jar file as shown below

mvn clean package


Then you can copy the jar from target folder to the current folder where
Dockerfile is kept.

Assuming you are in HelloMicroService folder

cp target/hello-ms-1.0.0.jar .

You can now build the docker image

docker build -t tektutor/hellomysql:1.0 .

In order to push the docker image to docker hub, you need to tag it

docker tag tektutor/hellomysql:1.0 tektutorjegan/hellomysql:1.0

You need to have a docker free account to push your image, as this
would prompt for docker login credentials
docker login 

Once you have successfully logged in, then you may push the image to docker hub

docker push tektutorjegan/hellomysql:3.0

Now its time to deploy the mysql database
You need to be in the HelloMicroService folder to locate the kubernetes
manifes file.

kubectl create -f mysql-deployment.yml
kubectl create -f mysql-service.yml

You need to create the 'tektutor' database and 'message' table in 'tektutor'
database manually by getting inside the mysql pod.

kubectl exec -it mysql-deployment-5b64589fb7-l2cbb bash

You may launch mysql as shown below

mysql -u root -p

The password is tektutor

You need to create the 'tektutor' database as shown below

sql> CREATE DATABASE tektutor;
sql> USE tektutor;
sql> CREATE TABLE message( id Integer NOT NULL, message VARCHAR(25), PRIMARY KEY(id) );
sql> INSERT INTO message(id,message) VALUES (1, 'Hello World');
sql> exit

You may also exit from the Pod terminal 

# exit

You can now create the hello deployment

kubectl create deployment hello --image=tektutorjegan/hellomysql:3.0
kubectl expose deployment hello --type=NodePort --port=8080

kubectl get pods
kubectl get svc

In order to find the IP address of master node, you can issue this command

kubectl get nodes -o wide

Assuming the master node IP is 10.192.0.2 and the NodePort for hello service
is 32602.

You may test it if things are working fine

curl http://10.192.0.2:32602/hello

The output expected is 

{ message: 'Hello World' }


















