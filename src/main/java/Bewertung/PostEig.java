package Bewertung;

public class PostEig {
public int post_id;
public int nr_of_likes;
public int nr_of_dislikes;

public PostEig(int post_id) {
	super();
	this.post_id = post_id;
}

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public int getNr_of_likes() {
	return nr_of_likes;
}

public void setNr_of_likes(int nr_of_likes) {
	this.nr_of_likes = nr_of_likes;
}

public int getNr_of_dislikes() {
	return nr_of_dislikes;
}

public void setNr_of_dislikes(int nr_of_dislikes) {
	this.nr_of_dislikes = nr_of_dislikes;
}


}