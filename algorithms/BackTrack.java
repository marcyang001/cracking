
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



	public static void combination(int[] nums, int[] data, int start, int end, int index, int r) {

		if (index == r) {
			for (int i : data) {
				System.out.print(i + " ");
			}
			System.out.println();
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

			combination(nums, data, i+1, end, index +1, r);
        	

        	
		}

	}


	public static void testCombination() {

		int nums[] = {1, 1, 2, 3, 4 , 5};
		int r = 3; 
		int[] data = new int[r];

		combination(nums, data, 0, nums.length-1, 0, r);
	}



	public static void main(String[] args) {
		// testMaze();
		testCombination();
	}





}