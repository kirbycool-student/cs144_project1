import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ComputeSHA {
	public static void main( String[] args ) throws NoSuchAlgorithmException {
		
		if( args.length != 1) {
			System.err.println("Incorrect format. Use 'java ComputeSHA <filepath>'.");
			System.exit(1);
		}
		
		byte[] contents = null;
		
		/*
		Path file = null;
		
		try {
			file = Paths.get( args[0] );
		} catch ( InvalidPathException e ) {
			System.err.println("Invalid Path. Make sure the file path is available.");
			System.exit(1);
		}
		
		//read the file inputs
		try {
			contents = Files.readAllBytes( file );
		} catch( Exception e ) {
			System.err.println( "There was an error reading the file.");
			System.exit(1);
		}
		*/
		File file = new File( args[0] );
		InputStream f = null;
		
		try {
			f = new FileInputStream( file );
		} catch (FileNotFoundException e) {
			System.err.println("Invalid Path. Make sure the file path is available.");
			System.exit(1);
		}
		
		contents = new byte[(int) file.length()];
		
		try {
			f.read(contents);
		} catch (IOException e) {
			System.err.println( "There was an error reading the file.");
			System.exit(1);
		}
		
		
		//compute the hash
		byte[] hash;
		
		MessageDigest md = MessageDigest.getInstance( "SHA-1" );
		hash = md.digest( contents );
		
		//convert the hash to hex
		StringBuilder hexHash = new StringBuilder();
		for( byte b : hash ) {
			hexHash.append( String.format( "%02x", b ) );
		}
		
		System.out.println( hexHash );
	}
}
