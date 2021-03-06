public class MS {
	private int [] input;
	public MS(int [] input) {
		this.input = input;
	}
	private int [] merge(int left [], int right[]){ // sort items in two arrays in a single array (merge two arrays in a sorted array)
		int [] ret = new int [right.length + left.length];
		int j = 0;
		int right_index = 0;
		int left_index = 0;
		while (j < ret.length){
			if (right_index < right.length && left_index < left.length){
				if (right[right_index] < left[left_index]){
					ret[j] = right[right_index];
					right_index++;
				}else {
					ret[j] = left[left_index];
					left_index++;
				}
			}else if (right_index < right.length){
				ret[j] = right[right_index];
				right_index++;
			}else {
				ret[j] = left[left_index];
				left_index++;
			}
			j++;
		}
		return ret;
	}
	
	public  int [] sort(){
		if (this.input == null)
			return null;
		return merge_sort(this.input, this.input.length);
	}
	
	private int [] merge_sort(int [] input, int p){
		if (input.length == 1){ // return if the array has only one item
			return input;
		}
		
		return merge( // merge left part and right part
			//left part
			merge_sort(copyofrange(input, 0, p/2), p/2),
			//right part
			merge_sort(copyofrange(input, p/2, input.length), input.length - p/2)
		);
	}
	private int [] copyofrange(int [] input, int i, int j){ // copy a range of an array into a new array
		int range [] = new int [j-i]; 
		for (int k = i; k < j; k++) {
			range [k-i] = input[k];
		}
		return range;
	}
}
