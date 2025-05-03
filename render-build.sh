#!/bin/bash
# Install Java 17
sudo apt update
sudo apt install -y openjdk-17-jdk

# Build the project
./gradlew clean build