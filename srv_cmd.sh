curl --data "{\
\"id\":\"jtyf62792khv862\", \"type\":\"TX\" \
\"date\":\"12082016\", \"amount\":\"1000\" \
\"pan\":\"30720863976927693\", \"pan_expdate\":\"0818\" \
\"twitterId\":\"johnDoe\", \"productCat\":\"S3\" \
\"product\":\"Laptop\", \"NbrItems\":\"1\" \
\"merchant\":\"Tesco\", \"location\":\"Whitechapel\" \
}" -v -X POST -H "Content-Type: application/json" http://localhost:8080/rpisrv/receive_tx

# create kafka topic
/usr/hdp/2.4.0.0-169/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic rpi_topic
# check if it's there
/usr/hdp/2.4.0.0-169/kafka/bin/kafka-topics.sh --list --zookeeper localhost:2181
/usr/hdp/2.4.0.0-169/kafka/bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic rpi_topic
# send some message
/usr/hdp/2.4.0.0-169/kafka/bin/kafka-console-producer.sh --broker-list 192.168.56.101:6667 --topic rpi_topic
# consume message
/usr/hdp/2.4.0.0-169/kafka/bin/kafka-console-consumer.sh --zookeeper 192.168.56.101:2181 --from-beginning --topic rpi_topic

