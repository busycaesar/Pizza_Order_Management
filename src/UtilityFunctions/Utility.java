package UtilityFunctions;

public class Utility {

	public static String[] mergeArrays(String[] _array1, String[] _array2) {
		int _array1Lenght = _array1.length,
			_array2Lenght = _array2.length;
		String[] mergedArray = new String[_array1Lenght +_array2Lenght];
		
		System.arraycopy(_array1, 0, mergedArray, 0, _array1Lenght);
		System.arraycopy(_array2, 0, mergedArray, _array1Lenght, _array2Lenght);
		
		return mergedArray;
	}
	
}
