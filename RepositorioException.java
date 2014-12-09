/*
 * Created on 07/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.swing.JOptionPane;
/**
 * @author lab17m
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RepositorioException extends Exception{
  	  private Exception exception;

  	  public RepositorioException() {
  	    super("Exceção encapsulada");
  	    this.exception = exception;
  	  }

  	  public String getMessage() {
  	    return exception.getMessage();
  	  }

  	  public void printStackTrace() {
  	  	JOptionPane.showMessageDialog(null,"O ERRO NAO DEIXA PASSAR");
  	    exception.printStackTrace();
  	  }
}


