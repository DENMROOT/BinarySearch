
public class BinarySearch {

	public static void main(String[] args) {
		char[] array =  {'a','b','c','d','e','f','l','m','n','o','p','r','s','t'};
//		char[] array1 = {'a','b','c','d','e','f','l','m','n','o','p','r','s','t','x'};
		char[] array2 = {};
		char key='m';
		int res=-1;
		int res1=-1;
		int res2=-1;
		int res3=-1;
	
		res=FindRecurse(array,key,0,array.length-1);
		res2=FindRecurse(array2,key,0,array2.length-1);
		System.out.println("Recursive 1 array" +" "+res);
		System.out.println("Recursive 2 array (empty)"+" "+res2);
		
		res2=FindInvariant(array,key,0,array.length-1);
		res3=FindInvariant(array2,key,0,array2.length-1);
		System.out.println("Invariant 1 array" +" "+res2);
		System.out.println("Invariant 1 array (empty)"+" "+res3);
		
		
	}
	
	public static int FindRecurse (char[] arr, char key, int startp,int endp){

	int center= (endp+startp)/2;
	
	if (startp>endp) return -1; 
	else if (key<arr[startp]||key>arr[endp]) return -1;   //checking if the element exist in array
	else if (key<arr[center])	return FindRecurse(arr,key,startp,center-1);
	else if (key>arr[center])	return FindRecurse(arr,key,center+1,endp);
	
	return center;
	} 

	public static int FindInvariant (char[] arr, char key, int startp,int endp){
		
	boolean found = false;
	int center=-1;
	
	while ((startp <= endp) && (found!=true)) {
	  center = (startp+endp)/2; 
	  if (arr[center] == key) found = true;
	  else if (startp==endp&&arr[center] != key) return -1;   // checking last element if array and is reached and element not found
	  else if (arr[center] < key)  startp= center+1;
	  else endp = center-1;
	}
	
	return center;
	} 

}
