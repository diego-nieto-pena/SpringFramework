#!/bin/bash

mvn clean compile assembly:single

java -jar target/360TPlayers-0.0.1-SNAPSHOT-jar-with-dependencies.jar