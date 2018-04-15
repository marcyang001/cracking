package pointers;

public class Solution {

	/*
	 * Implement a Trie data structure that stores all the contact information
	 */
	public static class Node {
		private static int NUMBER_OF_CHARACTERS = 26;
		Node[] children = new Node[NUMBER_OF_CHARACTERS];
		int size = 0; // keep the current count in each node
		
		
		private static int getCharIndex(char c) {
			return c - 'a';
		}
		
		private Node getNode(char c)
		{
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node; 
		}
		
		public void add(String s) {
			add(s, 0);
		}
		
		private void add(String s, int index) {
			size++;
			
			if (index == s.length()) return;
			
			char current = s.charAt(index);
			
			Node child = getNode(current);
			if (child == null) {
				child = new Node(); 
				
				setNode(current, child);
				
			}
			child.add(s, index+1);
		}
		
		
		// how many words are stored in the trie
		public int findCount(String s, int index) {
			if (s.length() == index) {
				return size;
			}
			
			Node child = getNode(s.charAt(index));
			if (child == null) {
				return 0;
			}
			return child.findCount(s, index+1);
		}
		
	}
	
}
