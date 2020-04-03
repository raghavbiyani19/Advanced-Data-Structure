package ads4.randomizedquicksort;

class QuickSort 
{
    int totalPartitions=0;
    
	int partition(int arr[], int low, int high) 
	{
                totalPartitions++;
		int pivot = arr[low]; 
		int i = (low+1);
		for (int j = low+1; j <=high; j++) 
		{
			if (arr[j] <= pivot) 
			{
                            int temp = arr[i]; 
                            arr[i] = arr[j]; 
                            arr[j] = temp;
                            i++;  
			} 
		} 
		arr[low] = arr[i-1]; 
		arr[i-1] = pivot; 
		return i-1; 
	} 

	void sort(int arr[], int low, int high) 
	{
		if (low < high) 
		{
                    int pi = partition(arr, low, high); 
//                    System.out.println("PARTITIONS: "+totalPartitions);
                    sort(arr, low, pi-1); 
                    sort(arr, pi+1, high); 
		}
	}
        
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i){
                    System.out.print(arr[i]+" ");
                } 
		System.out.println(); 
	}
}
