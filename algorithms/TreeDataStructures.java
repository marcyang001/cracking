package pointers;

 /* A binary tree node has data, pointer to 
    left child and a pointer to right child */
	 class node 
	 {
	     int data;
	     node left, right;
	
	     public node(int data) 
	     {
	         this.data = data;
	     }
	 }

public class TreeDataStructures {

 
	    /* Function to get the maximum width of a binary tree*/
	   static int getMaxWidth(node node) 
	    {
	        int maxWidth = 0;
	        int width;
	        int h = height(node);
	        int i;
	  
	        /* Get width of each level and compare 
	           the width with maximum width so far */
	        for (i = 1; i <= h; i++) 
	        {
	            width = getWidth(node, i);
	            if (width > maxWidth)
	                maxWidth = width;
	        }
	  
	        return maxWidth;
	    }
	  
	    /* Get width of a given level */
	    static int getWidth(node node, int level) 
	    {
	        if (node == null)
	            return 0;
	  
	        if (level == 1)
	            return 1;
	        else if (level > 1)
	            return getWidth(node.left, level - 1)
	                    + getWidth(node.right, level - 1);
	        return 0;
	    }
	 
	 
	 public static int postOrder(node root, int counter, int maxHeight) {
		 
		 if (root == null) {
			 
			 maxHeight = Math.max(counter, maxHeight);
			 return maxHeight;
		 }
		 
		 return Math.max(postOrder(root.left, counter + 1, maxHeight), postOrder(root.right, counter + 1, maxHeight));
		 
		 
	 }
	 
	
	 
	 public static int height(node root) {
		 
		 
		 return postOrder(root, 0, 0);
	 }
	 
	 public static void main(String[] args) 
	    {
	        node root = new node(1);
	        root.left = new node(2);
	        root.right = new node(3);
	        root.left.left = new node(4);
	        root.left.right = new node(5);
	        root.right.right = new node(8);
	        root.right.right.left = new node(6);
	        root.right.right.right = new node(7);
	 
	                /*   Constructed Binary tree is:
	                1
	              /   \
	            2      3
	          /  \      \
	         4    5      8
	                   /   \
	                  6     7    */
	         
	        BinaryTree tree = new BinaryTree();
	        
	        tree.MorrisTraversal(root);
	        
	    }
	 
}

class BinaryTree 
{
    node root;
  
    /* Function to traverse binary tree without recursion and 
       without stack */
    void MorrisTraversal(node root) {
        node current, pre;
          
        if (root == null)
            return;
          
        current = root;
        while (current != null) 
        {
            if (current.left == null) 
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current) 
                    pre = pre.right;
                 
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) 
                {
                    pre.right = current;
                    current = current.left;
                } 
  
                 /* Revert the changes made in if part to restore the 
                    original tree i.e.,fix the right child of predecssor*/
                 else
                 {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */
                  
            } /* End of if condition current->left == NULL*/
              
        } /* End of while */
         
    }
    
    void AlternateInorder(node root) {
    		
    }
    
}
