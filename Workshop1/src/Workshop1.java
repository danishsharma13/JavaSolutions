// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: January 25, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 1

public class Workshop1 {

	public static void main(String[] args) {
		
		// Initial variables for the program
		int perLineOutput = 1, output = 1, numberOfLines = 8, startingSpaces = numberOfLines - 2;
		
		// To print 8 lines
	    for(int i = 0; i < numberOfLines; i++) { 
	    	
	    	// Loop for adding spaces at the beginning of the output
	    	for(int y = 0; y <= startingSpaces; y++) {
	    		System.out.format("%4s", " ");
	    	}
	    	
	    	// Each loop start with output = 1
	    	output = 1; 
	    	
	    	// To print content in each line
	        for(int x = 0; x < perLineOutput; x++) { 
	            
	            System.out.format("%4d", output);
	            
	            // If x is less than the number of line, keep multiplying output by 2
	            if(x < i) {
	                output *= 2;
	            } 
	            // If x is less than the number of line, keep dividing output by 2
	            else {
	                output /= 2;
	            }
	            
	        }
	        
	        System.out.println();
	        perLineOutput += 2; // Length of each line
	        startingSpaces -= 1; // Reduce the iteration of the space loop above
	    }

	}

}
