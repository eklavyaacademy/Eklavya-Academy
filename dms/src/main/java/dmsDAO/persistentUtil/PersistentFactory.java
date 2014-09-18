package dmsDAO.persistentUtil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PersistentFactory {

	public static final Logger logger = LoggerFactory.getLogger(PersistentFactory.class);
	public static PersistenceManagerFactory pmf = null;  
	
	public static PersistenceManagerFactory getpmf(){
		if ( pmf != null)
			return pmf ; 
		else {
			if (logger.isTraceEnabled() ) 
				logger.info("Creating persistent manager.....");
			
			try {
				pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
				if (pmf == null){
					logger.error("failed to load pmf");
				}
			}catch (Throwable e){
				logger.error("failed to load pmf error ",e);
			}
			return pmf ;
		}
	}
	
	public static PersistenceManager getPersistentManager(){
		return getpmf().getPersistenceManager();
	}
}
