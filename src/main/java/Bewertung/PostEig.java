package Bewertung;

public class PostEig {
public int post_id;
public int likesNumber;
public int nr_of_dislikes;

public PostEig(int post_id) {
	super();
	this.post_id = post_id;
}

public PostEig(int id, int likes, int dislikes) {
	this.post_id = id;
	this.likesNumber = likes;
	this.nr_of_dislikes = dislikes;
}

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public int getNr_of_likes() {
	return likesNumber;
}

public void setNr_of_likes(int nr_of_likes) {
	this.likesNumber = nr_of_likes;
}

public int getNr_of_dislikes() {
	return nr_of_dislikes;
}

public void setNr_of_dislikes(int nr_of_dislikes) {
	this.nr_of_dislikes = nr_of_dislikes;
}

public void incrementLikes() {
	this.likesNumber = this.likesNumber+1;
	
}
public void incrementDisLikes() {
	this.nr_of_dislikes = this.nr_of_dislikes+1;
	
}


}
