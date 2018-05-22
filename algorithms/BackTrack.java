
import java.util.*;


public class BackTrack {

	/* 
	input: a maze

	-------------
	  0	 1 	2   |
	|  	---------	   
	| 3  4  5	|
 	|	|   -----  
    | 6 | 7  8		
	-------------- 
	
	output: a path from start to end

	*/

	private int count = 0;
	private HashMap<String, String> map = new HashMap<>(); 

	public static boolean Solve_MazeHelper(List<Integer>[] maze, Integer start, Integer finish, Set<Integer> visited, LinkedList<Integer> path) {



		if (start == finish) {
			// path.add(start);
			return true;
		}

		visited.add(start);
		

		for (Integer cur : maze[start])
		{
			
			if (!visited.contains(cur)) {
				
				if (Solve_MazeHelper(maze, cur, finish, visited, path)) {
					path.addFirst(cur);
					
					return true;
				}
			}
		}

		return false;
	}

	public static List<Integer> Solve_Maze(List<Integer>[] maze, Integer start, Integer finish) {
		Set<Integer> visited = new HashSet<Integer>();
		LinkedList<Integer> path = new LinkedList<Integer>();

		if (Solve_MazeHelper(maze, start, finish, visited, path)) {
			path.addFirst(start);
		}

		return path;
	}


	public static void testMaze() {

		ArrayList<Integer>[] maze = new ArrayList[9];
		for (int i = 0; i < 9; i++) {
			maze[i] = new ArrayList<Integer>();
		}

		maze[0].add(1);
		maze[0].add(3);

		maze[1].add(0);
		maze[1].add(2);

		maze[2].add(1);

		maze[3].add(0);
		maze[3].add(4);	
		maze[3].add(6);	

		
		maze[4].add(3);				
		maze[4].add(5);
		maze[4].add(7);

		maze[5].add(4);

		maze[6].add(3);		

		maze[7].add(4);
		maze[7].add(8);

		maze[8].add(7);

		
		List<Integer> path = Solve_Maze(maze, 0, 8); 
		

		for (Integer p : path) {
			System.out.print(p + " ");
		}
		System.out.println();

	}

	/*
		Print a list of possible combinations gives an array of values and 
		a constant value that define the number of values in a combo 

		nums : a list of values 
		data : a combo 
		start: current index of nums
		finish: the last element of nums 
		index: current index of data
		r: a number of values in a combo
	*/



	public static void combination1Way(int[] nums, int[] data, int start, int end, int index, int r, ArrayList<String> result) {

		if (index == r) {
			String temp = "";
			for (int i : data) {
				// System.out.print(i + " ");
				temp += i + " ";
			}

			result.add(temp);

			// System.out.println();
			return;
		}

		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{

			data[index] = nums[i];

			// removing duplicates
			if (i + 1 < end) {
        		while (nums[i] == nums[i+1]) {
        			
					i++; 
        		}	
        	}

			combination1Way(nums, data, i+1, end, index +1, r, result);        	
		}
	}

	public static void combination2Way(int arr[], int n, int r, int index, int data[], int i) {

		// Current cobination is ready, print it
		if (index == r)
		{
			for (int j=0; j<r; j++)
				System.out.print(data[j] + " ");
			System.out.println();
			return;
		}

		// When no more elements are there to put in data[]
    	if (i >= n)
        	return;

        // current is included, put next at next location
        data[index] = arr[i];
        
        // removing duplicates
		if (i + 1 < n) {
       		while (arr[i] == arr[i+1]) {
        			
				i++; 
       		}	
        }

        combination2Way(arr, n, r, index+1, data, i+1);


        // current is is excluded, replace it with next (Note that
    	// i+1 is passed, but index is not changed)
        combination2Way(arr, n, r, index, data, i+1);
	}


	public static void testCombination() {

		int nums[] = {1, 2, 3, 4 , 5};
		int r = 3; 
		int[] data = new int[r];
		ArrayList<String> result = new ArrayList<>();

		combination1Way(nums, data, 0, nums.length-1, 0, r, result);

		for (String combo : result)
			System.out.println(combo);

		// combination2Way(nums, nums.length, r, 0, data, 0);
	}

	public static void permute(int start, int[] input ) {
        
        if (start == input.length) {
            //System.out.println(input);
            for(int x: input){
            	System.out.print(x + " ");
        	}

	        System.out.println("");
	        return;
    	}

	    for (int i = start; i < input.length; i++) {
	        // swapping
	        int temp = input[i];
	        input[i] = input[start];
	        input[start] = temp;
	       // swap(input[i], input[start]);

	        permute(start + 1, input);
	       // swap(input[i],input[start]);

	        int temp2 = input[i];
	        input[i] = input[start];
	        input[start] = temp2;
	    }
	}

	public static void testPermutation() {
		int[] a={1,2,3};
		permute(0, a); 
		
	}


	public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1};
        int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            if(num - i > 6) continue;
            List<Integer> list1 = generateDigit(nums1, i); // hour
            List<Integer> list2 = generateDigit(nums2, num - i); // minitues
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }
    
    private static List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }
    
    private static void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }


    public static void testBinaryWatch() {

    	List<String> result = readBinaryWatch(5);

    	for (String time : result) {
    		System.out.print(time + ", ");
    	}
    	System.out.println(result.size());

    }

    private void initDictionary() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H",
                           "I", "J", "K", "L", "M", "N", "O", "P", 
                            "Q", "R", "S", "T", "U",
                           "V", "W", "X", "Y", "Z"};
        
        for (int i = 1; i<= 26; i++) {
            String num = i+"";
            map.put(num, letters[i-1]);
        }
        
    }
    
    public int numDecodings(String s) {
     	// store all the code 1 to 26 into hashmap    
        initDictionary();
        helperNumDecodings(s, s.length());
        return this.count;
    }
    
    private boolean helperNumDecodings(String s, int n) {
        
        for (int i = 1; i <= n; i++) {
            
            boolean b = map.containsKey(s.substring(0, i)); 
            if (b && i == n) {
                count++;
                return true;
            }
            else if (b) {
                
                b = helperNumDecodings(s.substring(i, n), n-i);
                if (b && i == n) {
                    count++;
                    return true;
                }
            }
        }
        
        
        return false;  
    }

    public static void testNumDecodings() {
    	BackTrack bt = new BackTrack();
    	int a = bt.numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948");
    	System.out.println(a);
    }


	public static void main(String[] args) {
		// testMaze();
		// testCombination();
		// testPermutation();
		// testBinaryWatch();
		testNumDecodings();
	}





}