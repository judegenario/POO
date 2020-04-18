/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/

import java.util.ArrayList;

public class Video extends Media{	//herança da classe media
	private final Director DIRECTOR;
	private final ArrayList<Actor> ACTOR;//utilizacao de arraylist
	private final int ID=0;
	private int length=-1;

	//construtor da classe video sem duracao e ano	
	public Video(String NAME, Director DIRECTOR, ArrayList<Actor> ACTOR, Util.ageRatingsEnum AGERATING, ArrayList<Util.genresEnum> GENRES){
		super(NAME, AGERATING, GENRES);
		this.DIRECTOR = DIRECTOR;
		this.ACTOR = new ArrayList<Actor>(ACTOR);

	}

	public Director getDirector() {
    	return DIRECTOR;
  	}

	public ArrayList<Actor> getActor() {
    	return ACTOR;
  	}

	public int getID() {
    	return ID;
  	}

	public int getLength() {
    	if (length == -1)
    	System.out.println("Não foi atribuída uma duração para este filme!");
    	return length;
  	}

  	public void setLenght(int length) {
    	this.length = length;
  	}

}