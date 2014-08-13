/**
 * 
 */
package com.util.encrypt;


/**
 * @author ranjans
 *
 */
public class EncriptionUtilFactory {
	
	//private static final String Base64="Base64";
	/*
	private static final String DES="DES";
	private static final String TripleDES="TripleDES";
	private static final String BlowFish="BlowFish";
	*/
	public static enum Type{Base64,DES,TripleDES,BlowFish}
	// -- private static final Enum<String> Type{"Base64"};
	
	private static EncriptionUtilFactory factory=new EncriptionUtilFactory();
	
	private EncriptionUtilFactory(){
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new CloneNotSupportedException("Clone not support");
	}
	
	public static EncriptionUtilFactory getInstance(){
		return factory;
	}
	
	public EncryptImpl encryptFactory(Type type){		
		  
		EncryptImpl enc=null;
		switch (type) {
		case Base64:
			enc= new Base64();		
			break;
		default:
			
			break;
		}		
		return enc;
	}

}
