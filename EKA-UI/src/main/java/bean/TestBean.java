
package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Nitin
 *
 */
@ManagedBean (name="testBean")
@ViewScoped
public class TestBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);
	
	private int i = 0 ; 
	private String name  =" DFDFD" ;
	
	public TestBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		logger.info("name"+name);
		this.name = name;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	public void show(){
		logger.info("i = "+i);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("name: "+name));
	}
	
}
