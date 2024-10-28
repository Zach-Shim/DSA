## Matrix

**DFS Recursive**
```Python
rows = len(graph)
cols = len(graph[0])

def bfs(r, c):
	stack = list()
	visited = set()
	
	stack.append((r,c))
	visited.add((r,c))
	
	while queue:
		vertex = queue.popleft()
		for all adjacent neighbors of vertex:
			if neighbor not in visited:
				stack.append(neighbor)
				visited.add(neighbor)
				
for row in rows:
	for col in cols:
		if entering condition:
			bfs(row, col, graph)
```

We can make this O(1) space (take out the visited set) only if we are allowed to change the input array.

**DFS Iterative**
```Python
rows = len(graph)
cols = len(graph[0])

visited = set()

def dfs(r, c):
	if outside of matrix bounds:
		return
	
	visited.add((r,c))
	
	for all adjacent neighbors:
		if neighbor not in visited:
			dfs(neighbor)
			
for row in rows:
	for col in cols:
		if entering condition:
			dfs(row, col, graph)
```

**BFS**
```Python
rows = len(graph)
cols = len(graph[0])

def bfs(r, c):
	queue = deque()
	visited = set()
	
	queue.append((r,c))
	visited.add((r,c))
	
	while queue:
		vertex = queue.popleft()
		for all adjacent neighbors of vertex:
			if neighbor not in visited:
				queue.append(neighbor)
				visited.add(neighbor)
				
for row in rows:
	for col in cols:
		if entering condition:
			bfs(row, col, graph)
```

We can make this O(1) space (take out the visited set) only if we are allowed to change the input array.
## **Cycle Detection**
To check if a graph contains a cycle, the most common method is to ==use a Depth First Search (DFS) algorithm==: during the traversal, if you encounter a previously visited vertex that is not the parent of the current vertex (a "back edge"), then a cycle exists in the graph; this is true for both directed and undirected graphs.
## **Union Find**