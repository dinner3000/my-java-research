package logging.demo.cxf.service;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import logging.demo.cxf.inf.IDefaultApi;

@WebService(endpointInterface = "logging.demo.cxf.inf.IDefaultApi", serviceName="DefaultApi")
public class DefaultApi implements IDefaultApi{
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	private static int count = 0;
	@Override
	public String sayHi(String toWho) {
		count++;
		log.info("Accessing DefaultApi/sayHi {}", count);
		return "Hello " + toWho + " !";
	}

}
