package org.deuce.transaction;

import org.deuce.transform.Exclude;

@Exclude
public class TransactionException extends RuntimeException {

	public TransactionException(){}

	public TransactionException( String msg){
		super(msg);
	}

	public TransactionException( Throwable cause){
		super(cause);
	}

	@Override 
	public Throwable fillInStackTrace(){ return null;} // light exception with no stack trace
}
