package javaProject1Package;

import java.util.Comparator;

//import javaProject1Package.TessApp;

import java.util.LinkedList;
import java.util.Queue;

public class JavaProject1 {

	static int iCount=1;
	
	public class Node {
		
		int iNodeID;
		
		Node leftNode;
		Node rightNode;
		
		int qLen;
		
		Queue<Integer> qList = new LinkedList<Integer>();
		
		Node(int iNodeNumber, int qNewLen) {
			
			this.iNodeID = iNodeNumber;
			this.qLen = qNewLen;
			
			rightNode = null;
			leftNode = null;
			
			System.out.println();
			System.out.println();
			System.out.print(iNodeNumber);
			System.out.print(" ");
			System.out.print(qNewLen);
			System.out.print(" ");

			//You need to initialize the Queue here
			Queue<Integer> qTemp = new LinkedList<Integer>();
			
			for (int i=iCount;i<iCount+qNewLen;i++)
			{
				//int tempNumber = iNodeNumber*10 + i;
				//qTemp.add(tempNumber);
				
				qTemp.add(i);
				
				System.out.print(i);
				System.out.print(" ");
				
				//How do we pick alternatively?
				//Pick flag will be the easiest
			}
			
			iCount = iCount + qNewLen;
			
		}
		
	}
	
	
	
	public JavaProject1() {
		// TODO Auto-generated constructor stub
	}

	public class BinaryTree {
		
		Node rootNode;
		
		BinaryTree() 
		{
			
		}
		
		private boolean add(Node current, int id, int qLen) {
			
			//In this case the nodes are simply added in order from left to right
				//					7
				//			5				6
			//			1		2		3		4					
			
			// No rootNode as yet
			if (rootNode==null)
			{
				//The Binary tree has not been created as yet
				Node tempNode = new Node(id,qLen);
				rootNode = tempNode;
				
				return true;
			}
			//	The values(ID are simply added from left to right)
			//	If the left is null then create a new node and add the node to the left
			
			// First fill left Node
			if (current.leftNode==null)
			{	
				current.leftNode = new Node(id, qLen);
				return true;
			} 
			//else {	
				// If the left node is full then add to right node
				//add(current.leftNode,id,qLen);
			//}
			
			//	Then fill right node
			if (current.rightNode==null)
			{
				current.rightNode = new Node(id, qLen);
				return true;
			} 
			
			//	else {
			//		add(current.rightNode,id,qLen);	
			//	}
			//	Both the left and right nodes of the current node 
			//	are already full return null
			
			//	If we reached here both left and right nodes are not null
			
			//Does the leftNode have any space?
			if ((current.leftNode.leftNode==null) || (current.leftNode.rightNode==null)) {
				boolean bRet = add(current.leftNode, id, qLen);
				return bRet;
			}
			
			//Does the rightNode have any space?
			if ((current.rightNode.leftNode==null) || (current.rightNode.rightNode==null)) {
				boolean bRet = add(current.rightNode, id, qLen);
				return bRet;
			}
			
			
			return true;	
		}
			
		private void printTree (Node rootNode)
		{	
			if (rootNode==null)
			{
				return;
			}
			else
			{
				//RootNode is not null. Print out the ID
				if (rootNode!=null) 			System.out.print(rootNode.iNodeID);
				if (rootNode.leftNode!=null) 	System.out.print(rootNode.leftNode.iNodeID);
				if (rootNode.rightNode!=null) 	System.out.println(rootNode.rightNode.iNodeID);
				System.out.println("-");
				
				//System.out.println(rootNode.iNodeID);
						
				if (rootNode.leftNode!=null)
				{
					printTree(rootNode.leftNode);
				}
				
				if (rootNode.rightNode!=null)
				{
					printTree(rootNode.rightNode);
					return;
				}
			
			}
			
			return;
		}
		
		
	}
	
	class IntComparator implements Comparator<Integer> {
		
		@Override
		public int compare(Integer v1, Integer v2) {
			
			int lenv1 = String.valueOf(v1).length();
			int lenv2 = String.valueOf(v2).length();
			
			int len = 0;
			
			if (lenv1<lenv2) len=lenv1; else len=lenv2;
			
			
			
			
			return 0;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Random");
		
		//	1
		//	4
		
		//		1	6	7	10
		//	1	0	5	6	 1
		//	6	5	0	1	 6
		//	7	6	1	0	 7
		//	10	1	6	7	 0
		
		
		//	1	7	10	6
		
		// 	Brute force
		//	Put the numbers in an array
		
		
		//	Start with the smallest number
		
		int[] iArr = new int[]{10, 6, 7, 1};
		
		LinkedList<Integer> iLink = new LinkedList<Integer>();
		
		LinkedList<Integer> iLinkNew = new LinkedList<Integer>();
		
		iLink.add(10);
		iLink.add(6);
		iLink.add(7);
		iLink.add(1);
		
		Comparator<Integer> order = Integer::compare;
		
		
		System.out.println(iLink.toString());
		
		//iLink.remove(new Integer(7));
		
		//System.out.println(iLink.toString());
		
		iLink.sort(order);
			
		System.out.println(iLink.toString());
		
		//Extract the smallest number at location 1
		
		iLinkNew.add(iLink.remove());
		
		System.out.println(iLinkNew.toString());
		System.out.println(iLink.toString());
		
		//Find the number in iLink which is the furthest from iLinkNew
		// 1, 7, 6, 10
		
	
		//	Algorithm
		//	InOrder Traversal 
		//	Root -> Left --> Right
		//	
		
		
		
		
		int n = 7;
		int q = 6;
		
		//Create the linked-list of 3 levels
		//Each node contains a queue
		
		//LinkedList<Queue<Integer>> oList = new LinkedList<Queue<Integer>>();
		
		//Create Node 7
		//Queue<Integer> qNode7 = new LinkedList<Integer>();
		//qNode7.add(0);
		
		//oList.add(qNode7);	//Root Node
		
		JavaProject1 jp = new JavaProject1();
		
		BinaryTree bt = jp.new BinaryTree();
	
		//Queue<Integer> qNode7 = new LinkedList<Integer>();
		
		Node rootNode = jp.new Node(7,0);
		
		//bt.add(rootNode, 7, 0);
		
		//bt.printTree(rootNode);
		
		//	Algorithm
		//	Create the Tree as shown
		
		//Node node5 = jp.new Node(5,0);
		
		bt.add(rootNode, 7, 0);
		//bt.printTree(rootNode);
		
		bt.add(rootNode, 5, 7);
		bt.add(rootNode, 6, 4);
		bt.add(rootNode, 1, 9);
		bt.add(rootNode, 2, 5);
		bt.add(rootNode, 3, 1);
		bt.add(rootNode, 4, 3);
		
		System.out.println(" ");
		
		bt.printTree(rootNode);
		
		
		//	Traverse the tree starting with the rootNode
		//	Flag=Left-Node
		//	Check if the left node has any people on it
		//	If yes then move one person to Root-Node (P1 moves to Root-Node)
		//	Flag=Right-Node
		//	Traverse Left-Node
		//	
		
		
		
		
		
		
		
		
		
		
		
		
		
		//TessApp = new TessApp();
		
		//TessApp myTessApp = new TessApp();
		
		//System.out.print(myTessApp.getImgText("/users/pranaysadarangani/test/IMG_7773.jpg"));
		
		int iWhite = 10;
		int iRed = 10;
		int iGreen = 10;
		
		int iNum = 0;
		
		
		while((iWhite>0) && (iRed>0) && (iGreen>0)) {
		
		boolean bPaint = (iWhite-3)>= 0;
		if (bPaint) {
			iNum++;
			iWhite=iWhite-3;
			//System.out.println("W");
		}
		
		bPaint = (iRed-3)>= 0;
		if (bPaint) {
			iNum++;
			iRed=iRed-3;
			//System.out.println("R");
		}
		
		bPaint = (iGreen-3)>= 0;
		if (bPaint) {
			iNum++;
			iGreen = iGreen-3;
			//System.out.println("G");
		}
		
		bPaint = (((iWhite-1)>=0) && ((iRed-1)>=0) && ((iGreen-1)>=0));
		if (bPaint) {
			iNum++;
			iWhite--;
			iRed--;
			iGreen--;
			//System.out.println("RGW");
		}
		
		}
		
		//System.out.println(iNum);
		
		
		
		

	}

}





/*

People are crazy about WWE in ‘xyz’ state. 
There’s a long queue in front of ticket counter. 
Here are the queue considerations.

There can be max 2 incoming queues merging at a junction point
Only one outgoing queue from any junction point
There can be multiple junction points & the queues move uni-directionally
There will be only one final ticket counter point where all the queues lead to
There are multiple entry points exist for the fans to reach the counter
“WWE fans” who are entering in to the ticketing premises to book the tickets don’t have any idea of Optimal Path & time required to reach the ticket counter. So there is a need to design a system that can suggest the fans what is the “Optimal Path” and its “Expected Time for reaching the counter”

The expected time of reaching the counter from a queue depends on the number of people in that queue plus the number of people in the other queues.
Time taken to cross the ticket counter and receive the ticket is 1 time unit
Assume that there is a policeman standing on each junction point whose job is to open the junction gate to send people from in-queue(s) to out-queue. If there are multiple in-queues for a junction, the policeman will send fans from each queue one by one alternatively
For example, if there are 2 in-queues containing 3 fans each, person from queue1 will be sent first followed by person from queue2 followed by next person from queue1 and so on. It’s an alternate pick between the incoming queues
For the given problem, the input will consist of:

No of Junctions: entries/exits where you can get on or off a particular queue.(<=200)
No of Queues: Total number of queues(<=200)
"start_junction" "end_junction" #people(on the queue b/w start & end junction) . Note: this is also the max number of people that can stand in this queue
The travel time for each queue is held proportional to #people in that queue
Given the current snapshot of number of people on each queue, Calculate the minimum time for a person to reach the ticket counter who is just about to enter any queue. Also, output the path that he should take to reach the counter in minimum time in the worst case(at each junction point, the policeman starts choosing people from the in-queue other than the one we are calculating the minimum time for).

Note : If multiple optimal paths are possible, print each of the path in a separate line sorted wrt to the first node

Input
The first line contains the number of junctions 'n'(<200).

The second line contains the number of queues 'e'(<200).

The next 'e' lines contains three values: the start junction, the end junction and the number of people on this queue(This is also the max. number of people that can stand in this queue)

Output
Optimal Time

Path(s)

SAMPLE INPUT 
7
6
1 5 9
2 5 5 
3 6 1
4 6 3 
5 7 7 
6 7 4
SAMPLE OUTPUT 
15
3 -> 6 -> 7
Explanation
enter image description here

enter image description here

enter image description here

enter image description here

enter image description here

enter image description here

Ticket counter point: 7

Entry points: 1, 2, 3, 4

Time required for a person who is just entering the queue from entry point 3:

1 person from queue(3,6) + 2 people from queue(4,6) + 4 people from queue(6,7) + 7 people from queue(5,7) + 1 person from queue(1,5) will go before this person.
So optimal time = 15 & the path is 3 -> 6 -> 7
Note: queue(a, b) means queue-line between a and b junction points


*/