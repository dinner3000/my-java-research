package logging.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class DefaultController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static int count = 0;
	
	@RequestMapping(value = "/index")
	public @ResponseBody String index(){
		count++;
		log.info("accessing /index - {}", count);
		return "This is /index";
	}
}
