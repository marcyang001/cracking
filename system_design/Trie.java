/*
	
	Trie is an efficient information reTRIEval data structure. 
	Using Trie, search complexities can be brought to optimal limit (key length).
	Using Trie, we can search the key in O(M) time.

	Every node of Trie consists of multiple branches.
	Each branch represents a possible character of keys.


	A Trie node field isEndOfWord is used to distinguish the node as end of word node. 


*/

import java.util.*;

public class Trie {

	// Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
    static TrieNode root; 
    // trie node
    static class TrieNode
    {
    	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    	// isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord = false;
        
        TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node

    static void insert(String key) 
    {
    	int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
        	index = key.charAt(level) - 'a';
        	if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
        	}
        	// iterate one level deeper
			pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;

    }


    // Returns true if key presents in trie, else false

    static boolean search(String key)
    {
    	int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}


		return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void searchPrefix(String prefix) {
    	int level;
        int length = prefix.length();
        int index;
        TrieNode preCrawl = root;

        for (level = 0; level < length; level++)
		{
			index = prefix.charAt(level) - 'a';
			if (preCrawl.children[index] == null)
				return;

			preCrawl = preCrawl.children[index];
		}

		if (preCrawl != null) {
			StringBuilder wordString = new StringBuilder(prefix);

			printAllWords(preCrawl, wordString);		
		}


    }

    public static void printAllWords(TrieNode root, StringBuilder word) {

    	
    	if(root == null)
      		return;

      	if(root.isEndOfWord)
   		{
      		System.out.println(word.toString());
   		}
   		
   		for(int i=0; i<ALPHABET_SIZE; i++)
   		{
      		if(root.children[i] != null)
      		{
         		char alpha_letter = (char) (i+'a');
         		word.append(alpha_letter);
         		printAllWords(root.children[i], word);
         		word.deleteCharAt(word.length()-1);
    		}
    	}
    }



    // Driver
	public static void main(String args[])
	{
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"the", "a", "there", "answer", "any",
						"by", "bye", "their", "marc", "marcs"};
	
		String output[] = {"Not present in trie", "Present in trie"};
	
	
		root = new TrieNode();
	
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);
	
		// Search for different keys
		// if(search("the") == true)
		// 	System.out.println("the --- " + output[1]);
		// else System.out.println("the --- " + output[0]);
		
		// if(search("these") == true)
		// 	System.out.println("these --- " + output[1]);
		// else System.out.println("these --- " + output[0]);
		
		// if(search("their") == true)
		// 	System.out.println("their --- " + output[1]);
		// else System.out.println("their --- " + output[0]);
		
		// if(search("thaw") == true)
		// 	System.out.println("thaw --- " + output[1]);
		// else System.out.println("thaw --- " + output[0]);
		
		// if(search("marc") == true)
		// 	System.out.println("marc --- " + output[1]);
		// else System.out.println("marc --- " + output[0]);
		
		// if(search("marcs") == true)
		// 	System.out.println("marcs --- " + output[1]);
		// else System.out.println("marcs --- " + output[0]);
		
		searchPrefix("the");
		//searchPrefix("marc");

		//printAllWords(root,  new StringBuilder());

	}
}

