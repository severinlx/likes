package Bewertung;

public class DBOperations {

	
	public static void incrementLike(int postID) {
		
		PostEig postRating = new PostEig(postID);
		
		if(DBget.getIds().contains(postID)) {
		postRating = DBget.get(postID);
	    postRating.incrementLikes();
	    DBpost.update(postRating);
		} else {
			postRating = new PostEig(postID, 1, 0);
			DBpost.post(postRating);
		}
	}
	
	public static void postOrUpdate(PostEig postRating) {
		int postID = postRating.getPost_id();
		if(DBget.getIds().contains(postID)) {
		    DBpost.update(postRating);
			} else {
				DBpost.post(postRating);
			}
	}
	
	public static void incrementDisLike(int postID) {
		PostEig postRating = new PostEig(postID);
		
		if(DBget.getIds().contains(postID)) {
		postRating = DBget.get(postID);
	    postRating.incrementDisLikes();
		} else {
			postRating = new PostEig(postID, 0, 1);
		}
		DBpost.post(postRating);
		
	}
	
	public static int getLikes(int postID) {
		return DBget.get(postID).getNr_of_likes();	
	}
	
	public static int getDisLikes(int postID) {
		return DBget.get(postID).getNr_of_dislikes();
	}
		

	public static void main(String[] args) { 
		//PostEig p = new PostEig(2, 2, 3);
		//incrementLike(2);
		//DBpost.post(p);	
		System.out.println(DBget.get(2));
		//System.out.println(DBget.getIds().get(0));
	}
}
