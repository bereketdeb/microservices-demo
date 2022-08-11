#!/bin/bash
# check-kafka-topics-created.sh

#add-apt-repository universe
apt-get update
#apt-get update
sudo apt install software-properties-common
apt-get update
sudo add-apt-repository universe
yes | apt-get install kafkacat

kafkacatResult=$(kafkacat -L -b kafka-broker-1:9092)


echo "kafkacat result:" $kafkacatResult

while [[ ! $kafkacatResult == *"twitter-topic"* ]]; do
  >&2 echo "Kafka topic has not been created yet!"
  sleep 2
  kafkacatResult=$(kafkacat -L -b kafka-broker-1:9092)
done

./cnb/lifecycle/launcher