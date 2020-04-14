package org.demo.randomquestions;

public class ClimbingTheLeaderboard {

	public static void main(String[] args) {
		
		int[] scores = {100,100,100,100,25,10,10};
		int[] alice = {5,25,50,120};
		int[] output = climbingLeaderboard(scores, alice);
		
		for(int i =0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}
	
	 static int[] climbingLeaderboard(int[] scores, int[] alice) {

	        int[] output = new int[alice.length];
	        
	        for(int i = 0 ; i < alice.length; i++){
	        	int current = 0;
		        int previous = 0;
	            int rank = 1;
	           int score = alice[i];
	           for(int j = 0 ; j < scores.length; j++){
	               current = scores[j];
	           if(current <= score){
	               break;
	           }    
	           if((current != previous)){
	               rank++;
	           }
	                previous = scores[j];
	           }
	        output[i] = rank;
	        }

	    return output;
	    }

}
