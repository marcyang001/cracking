package pointers;

import java.util.LinkedList;
import java.util.Queue;

/* Definition for binary tree with next pointer. */
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class Solution1 {
	
	/*
	 * connect the children node together 
	 * 	
	 */
		    /*   
		    1   => null
		  /   \
		2  ==> 3 => null
       /  \   /  \
	 4 ==> 5 6 => 8 => null
		
		*/
	
    public void connect(TreeLinkNode root) {
    		
        if (root == null)
            return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            
            int count = q.size();
            
            while (count > 0) {
                TreeLinkNode node = q.remove();
                
               
                node.next = q.peek();
                    
                if (node.left != null) {
                		q.add(node.left);
                	}
                    
                	if (node.right != null) {
                		q.add(node.right);   
                	}
                
                	count--;
                	if (count == 0) {
                    node.next = null;
                    
                	}
                
            }

        }
        
    }
    
    /*
     *  
     */
    
    public void connect2(TreeLinkNode root) {
    		
    		
        if(root == null){
            return;
        }
        
        while(root != null){
            TreeLinkNode node = root; 
            while(node != null){
            if(node.left == null){
                break;
            }else{
                node.left.next = node.right;
                node.right.next = node.next == null ? null : node.next.left;
            }
            node = node.next;
            
        }
            root = root.left;
        }
    }
    
    
    
    public static void main(String[] args) {
    		
    		TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(8);
        
        
        Solution1 sol = new Solution1();
        sol.connect(root);

    }
    
    
    
}
