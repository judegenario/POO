/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/
import java.util.ArrayList;

public class Movie extends Video{	//herança da classe Video
	public Movie(String NAME, Director DIRECTOR, ArrayList<Actor> ACTOR, Util.ageRatingsEnum AGERATING, ArrayList<Util.genresEnum> GENRES){
		super(NAME, DIRECTOR, ACTOR, AGERATING, GENRES);
	}
}