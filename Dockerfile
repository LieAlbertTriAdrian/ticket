FROM java:8-jdk
MAINTAINER liealberttriadrian <alberttri23@gmail.com>

# Set mysql server prompt password when installing
RUN echo "mysql-server mysql-server/root_password password pass1234" | debconf-set-selections
RUN echo "mysql-server mysql-server/root_password_again password pass1234" | debconf-set-selections

# Update apt and install mysql-server
RUN apt-get update && apt-get install -y \
	mysql-server

# Start mysql server
RUN service mysql start && service mysql status

# Initiate the project folder
RUN mkdir ticket-service

# Copy the glassfih server that contain domain-ticket-service
COPY GlassFish_Server ticket-service/

COPY PayRequest/dist/PayRequest.war ticket-service/glassfish/domains/domain-ticket-service/autodeploy
# Start the glassfish server
RUN cd ticket-service/bin && ./asadmin start-domain --verbose domain-ticket-service