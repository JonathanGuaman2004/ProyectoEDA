package UserInterface.CustomerControl;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private char sortedArray[];
	// -------------------------------------------------------------
	public Graph() // constructor
	{
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++) // set adjacency
			for(int k=0; k<MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
		sortedArray = new char[MAX_VERTS]; // sorted vert labels
	} // end constructor
	// -------------------------------------------------------------
	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	// -------------------------------------------------------------
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
	}
	// -------------------------------------------------------------
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	// -------------------------------------------------------------
	public void topo() // topological sort
	{
		int orig_nVerts = nVerts; // remember how many verts
		while(nVerts > 0) // while vertices remain,
		{
			// get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if(currentVertex == -1) // must be a cycle
			{
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			// insert vertex label in sorted array (start at end)
			sortedArray[nVerts-1] = vertexList[currentVertex].label;
			deleteVertex(currentVertex); // delete vertex
		} // end while
		// vertices all gone; display sortedArray
		System.out.print("Topologically sorted order: ");
		for(int j=0; j<orig_nVerts; j++)
			System.out.print( sortedArray[j] );
		System.out.println("");
	} // end topo
	// -------------------------------------------------------------
	public int noSuccessors() // returns vert with no successors
	{ // (or -1 if no such verts)
		boolean isEdge; // edge from row to column in adjMat
		for(int row=0; row<nVerts; row++) // for each vertex,
		{
			isEdge = false; // check edges
			for(int col=0; col<nVerts; col++)
			{
				if( adjMat[row][col] > 0 ) // if edge to
				{ // another,
					isEdge = true;
					break; // this vertex
				} // has a successor
			} // try another
			if( !isEdge ) // if no edges,
				return row; // has no successors
		}
		return -1; // no such vertex
	} // end noSuccessors()
	// -------------------------------------------------------------
	public void deleteVertex(int delVert)
	{
		if(delVert != nVerts-1) // if not last vertex,
		{ // delete from vertexList
			for(int j=delVert; j<nVerts-1; j++)
				vertexList[j] = vertexList[j+1];
			// delete row from adjMat
			for(int row=delVert; row<nVerts-1; row++)
				moveRowUp(row, nVerts);
			// delete col from adjMat
			for(int col=delVert; col<nVerts-1; col++)
				moveColLeft(col, nVerts-1);
		}
		nVerts--; // one less vertex
	} // end deleteVertex
	// -------------------------------------------------------------
	private void moveRowUp(int row, int length)
	{
		for(int col=0; col<length; col++)
			adjMat[row][col] = adjMat[row+1][col];
	}
	// -------------------------------------------------------------
	private void moveColLeft(int col, int length)
	{
		for(int row=0; row<length; row++)
			adjMat[row][col] = adjMat[row][col+1];
	}
	// -------------------------------------------------------------
} // end class Graph

