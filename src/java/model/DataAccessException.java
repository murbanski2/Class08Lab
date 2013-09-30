package model;

/**
 * A modification of the jlomardo custom exception class. 
 * 
 * @author Mark Urbanski
 */
public class DataAccessException extends Exception {
    public DataAccessException(String msg) {
        super("DataAccessException: " + msg);
    }
    
    public DataAccessException(String msg, Throwable cause) {
        super("DataAccessException: " + msg, cause);
    }
}
