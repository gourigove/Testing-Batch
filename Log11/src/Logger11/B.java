package Logger11;


import org.apache.log4j.Logger;





public class B {
	
	static Logger log=Logger.getLogger(B.class.getName());
	public static void main(String[] args) {
		System.out.println("hello");
		log.debug("debug");
		log.error("error");
		log.warn("warn");
		log.info("info");
		
	}

}
