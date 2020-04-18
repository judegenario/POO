/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/

import java.util.ArrayList;


public class Series extends Media{
	private final ArrayList<ArrayList<Episode>> episodes = null;

	public Series(String NAME, Director DIRECTOR, ArrayList<Actor> ACTOR, Util.ageRatingsEnum AGERATING, ArrayList<Util.genresEnum> GENRES){
		super(NAME, AGERATING, GENRES);
	}


  	public void incrementViews (int episode, int season, int nViews) {
		episodes.get(season).get(episode).incrementViews(nViews);	//acessa o episódio da respectiva temporada e incrementa o numero de visualizações
  	}

	public void addUserRating (float _userRating, int season, int episode) {
		episodes.get(season).get(episode).addUserRating(_userRating);	//acessa o episódio da respectiva temporada e incrementa o num de avaliações	
  	}

	public void addEpisode (Episode episode, int season) {
		if(episodes.size() < season)
			episodes.add(new ArrayList<Episode>());

		episodes.get(season).add(episode);
  	}

	public int getNSeasons(){
		return episodes.size();
	}

	public int getNEpisodesinSeason(int season){
		return episodes.get(season).size();
	}

}