package logging.demo.cxf.inf;

import javax.jws.WebService;

@WebService
public interface IDefaultApi {

	public String sayHi(String toWho);
	
}
