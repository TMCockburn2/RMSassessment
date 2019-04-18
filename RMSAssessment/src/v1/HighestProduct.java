package v1;

public class HighestProduct {
	
	//testing purposes
	
	/**
	public static void main(String[]args){
		int arr[][] = {{1, 2, 3, 4, 5}, 
                {6, 7, 8, 9, 1}, 
                {2, 3, 4, 5, 6}, 
                {7, 8, 9, 1, 0}};
		long prod = findProduct(arr,4);
		System.out.println(prod);
		
	}
	**/
	//grid = matrix, length = number of rows/columns we are comparing
	public static long findProduct(int[][]grid, int length){
		//number would have to be greater than how many adjacent numbers we are comparing
		long highestProduct = 0;
		long localProduct;
		//count for how many different combinations 
		int count = 0;
		
		for (int n = 0; n < length; n++){
			for (int m = 0; m < length; m++){
				//if it is a valid set of 3 numbers
				if ((n - 2) >= 0){
				//add to count of total combinations	
				count++;	
				//checking vertical products
		        localProduct = grid[n - 2][m] * grid[n - 1][m] * grid[n][m];
		  
		        	if (highestProduct < localProduct){ 
		        		highestProduct = localProduct; 
		        	} 
				}
				//not using else ifs as we went it to check all the values
				//if valid set of 3 numbers
				if ((m - 2) >= 0)  {
				//add to count of total combinations
				count++;
				//check horizontal products
		        localProduct = grid[n][m - 2] * grid[n][m - 1] * grid[n][m]; 
		        	if (highestProduct < localProduct){ 
		        		highestProduct = localProduct; 
		        	}
				}
				
				//if valid set of 3 numbers (diagonal, should only need to check 1 way because backwards and forwards are the same
				//as per clarifications
				if ((n - 2) >= 0 && (m - 2) >= 0)  
		        {
				//add to total count
				count++;
				//check diagonal
		        localProduct = grid[n - 2][m - 2] * grid[n - 1][m - 1] * grid[n][m];
		        	if (highestProduct < localProduct){ 
		        		highestProduct = localProduct; 
		        	}
		        }
			}
			
		}
		System.out.println("total combinations: " + count);
		return highestProduct;
	}

}
