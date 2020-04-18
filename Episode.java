/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/

import java.util.ArrayList;

public class Episode extends Video{		//herança da classe Video

	private final int number;
	private final int seasonNumber;

	public Episode(int number, int seasonNumber, String NAME, Director DIRECTOR, ArrayList<Actor> ACTOR, Util.ageRatingsEnum AGERATING, ArrayList<Util.genresEnum> GENRES){
		super(NAME, DIRECTOR, ACTOR, AGERATING, GENRES);//chama o construtor da classe pai
		this.number = number;
		this.seasonNumber = seasonNumber;

	}

	public int getNumber() {	//getter para acessar o numero do episódio
    	return number;
  	}

	public int getseasonNumber() {	//getter para acessar  a temporada
    	return seasonNumber;
  	}
}