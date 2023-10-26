# Use the official Node.js image with the specified version as the base image
FROM node:18.17.1

# Install the Angular CLI globally
RUN npm install -g @angular/cli

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the rest of the application source code to the container
COPY . .

# Build the AngularJS application
RUN npm run build

# Expose port 4200 for the application (the port where ng serve will run)
EXPOSE 4200

# Create an entrypoint script to start ng serve
RUN echo '#!/bin/sh\nng serve --host 0.0.0.0 --port 4200' > /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Start the application using the entrypoint script
ENTRYPOINT ["/entrypoint.sh"]
