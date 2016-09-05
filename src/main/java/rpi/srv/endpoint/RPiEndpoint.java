package rpi.srv.endpoint;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPiEndpoint {
	
	private static final String RPI_TOPIC = "rpi_topic";
    
	static{
		KafkaUtils.load();
	}
	
	@RequestMapping(value = "/rpisrv/receive_tx", method = RequestMethod.POST)
    public String receive(@RequestBody Transaction tx) {
		//
        System.out.println("received TX " + tx);
        //
        KafkaUtils.sendMessage(RPI_TOPIC, tx);
        //
        return "ok";
    }
	
    
}