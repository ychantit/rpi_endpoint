curl --data "{\
\"id\":\"jtyf62792khv862\", \"type\":\"TX\", \
\"date\":\"12082016\", \"amount\":\"1000\", \
\"pan\":\"30720863976927693\", \"pan_expdate\":\"0818\", \
\"twitterId\":\"johnDoe\", \"productCat\":\"S3\", \
\"product\":\"Laptop\", \"NbrItems\":\"1\", \
\"merchant\":\"Tesco\", \"location\":\"Whitechapel\n\" \
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

# flume agent
/usr/hdp/2.4.0.0-169/flume/bin/flume-ng agent --conf  --conf-file a1.conf -n a1 --classpath a1_interceptor.jar -Dflume.root.logger=DEBUG,console

### flume agent

# Flume agent config
a1.channels = c1
a1.sources = source1
a1.sinks = k1
 
a1.sources.source1.type = org.apache.flume.source.kafka.KafkaSource
a1.sources.source1.channels = c1
a1.sources.source1.zookeeperConnect = 192.168.56.101:2181
a1.sources.source1.topic = rpi_topic
a1.sources.source1.groupId = flume
a1.sources.source1.kafka.consumer.timeout.ms = 100
 
a1.channels.c1.type = memory
a1.channels.c1.capacity = 100
a1.channels.c1.transactionCapacity = 100
a1.channels.c1.byteCapacityBufferPercentage = 20
a1.channels.c1.byteCapacity = 800000
 
a1.sinks.k1.type = hdfs
a1.sinks.k1.channel = c1
a1.sinks.k1.hdfs.path = /tmp/flume_a1
a1.sinks.k1.hdfs.fileType = DataStream

