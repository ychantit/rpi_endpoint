package rpi.srv.endpoint;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaUtils {

	public static final String KAFKA_BROCKER_URL = "192.168.56.101:6667";
	private static Properties props; 
	private static Producer<String, String> producer; 
	private static final Random r = new Random();
	
	static{
		 props = new Properties();
		 props.put("bootstrap.servers", KAFKA_BROCKER_URL);
//		 props.put("client.id", "hello");
//		 props.put("acks", "all");
//		 props.put("retries", 0);
//		 props.put("batch.size", 16384);
//		 props.put("linger.ms", 1);
//		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 //
		 producer = new KafkaProducer<String,String>(props);
	}
	
	public static void sendMessage(String topic, Transaction tx){
		 
		 try {
			producer.send(new ProducerRecord<String, String>(topic, Integer.toString(r.nextInt()), tx.toString()), new Callback() {
				
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if(metadata!=null){
						System.out.println("record topic : "+metadata.topic());
						System.out.println("record partition : "+metadata.partition());
						System.out.println("record offset : "+metadata.offset());
					}
					if(exception != null){
						exception.printStackTrace();
					}
				}
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void load(){
		System.out.println("loading KafkaUtils");
	}
	
}
