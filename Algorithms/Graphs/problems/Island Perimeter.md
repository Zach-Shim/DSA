## 1. Listen

**Problem Statement:**
You are given `row x col` `grid` representing a map where `grid[i][j] = 1` represents land and `grid[i][j] = 0` represents water.

Grid cells are connected **horizontally/vertically** (not diagonally). The `grid` is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

**Input:**
`row x col` `grid` representing a map 
1. `grid[i][j] = 1` represents land 
    and 
2. `grid[i][j] = 0` represents water

**Goal:**
Grid cells are connected **horizontally/vertically** (not diagonally). The `grid` is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.

One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. 

**Return:**
Return the perimeter of the island (number of cell sides).
## 2. Example

Example 1:

## 3. List Constraints

**Assumptions:**
- Assume grid follows necessary constraints (do not perform error check on constraints) 

**Constraints:**
- row == grid.length
- col == grid.length
- 1 <= row, col <= 100
- `grid[i][j]` can have value 1 or 0

- There is exactly one island in the grid.
- The island doesn't have 'lakes', meaning edges are not water.

**Edge Cases:**
- Only one cell
- 100 cells (no water)
## 4. Brute Force

A cell could have at minimum 0 open sides (completely surrounded)
A cell could have at maximum 3 open sides

The number of sides we are able to count towards the perimeter total depends on how much water a cell is touching. We can count an edge in the grid towards the perimeter (only if the current cell is land!).

Since we need to check all of the adjacent sides of each cell that is a piece of land, one at a time, BFS seems logical to use.

We use BFS to iterate over all of the cells in the grid, starting from the top left.
	If the current cell is water, we do not add any sides to the overall perimeter count.
	If the current cell is land, we add all sides that are adjacent to water or an edge.

Mark cells as visited so we do not revisit past cells
Add all cells to 


This BFS algorithms runs in O(V<sup>2</sup>) time.
## 5. Optimizations


## 6. Walkthrough

1. Initialize queue and perimeter tracker variable
2. Add top left cell to queue
3. mark top left as visited
4. while queue is not empty
	1. pop top cell from queue
	2. check if left, right, top, and bottom cells are water or edge (and not land)
		1. if so, add 1 to perimeter
	3. for every cell adjacent to current cell
		1. mark cell as visited
		2. add to end of queue
## 7. Implement

```Java
public int islandPerimeter(int[][] grid) {
	// track total perimeter
	int perimeter = 0;
	
	// current cell tracker variables
	int[][] adjacentCells = new int {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	
	// initalize queue
	Queue<Pair<Integer>> q = new LinkedList<>();
	
	for(int c = 0; c < grid.length; c++) {
		for(int r = 0; r < grid[0].length; r++) {
			if(grid[c][r] == 1) {
				q.offer(new Pair<Integer>(0, 0));
			}
		}
	}
	
	
	while(!q.isEmpty()) {
		
		Pair<Integer> cell = q.poll();
		int x = cell.getKey(), y = getValue();
		
		for(int[] adj : adjacentCells) {
			
			int adjX = x + adj[0], adjY = y + adj[1];
			
			if(adjX >= grid.length[0] || adjY >= grid.length || 
			   adjX < 0 || adjY < 0 || 
			   grid[adjX][adjY] == 0) {
				++perimeter;
			}
		}
	}
}
```
## 8. Test