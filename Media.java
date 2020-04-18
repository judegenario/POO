/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/
	
import java.util.Calendar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Media{//classe media

	private final String name;
	private final Util.ageRatingsEnum agerating;
	private final ArrayList<Util.genresEnum> genres;
	private final int id;
	private int length=-1, year=2019, nViews=0, nUserRatings=0;
	private float _userRating=0;
	private static int cont=0;
	private Logger logger;

	public int sum=0;

	//construtor da classe media
	public Media(String name, Util.ageRatingsEnum agerating, ArrayList<Util.genresEnum> genres){
		logger = Logger.getLogger(Media.class.getName());
		this.name = name;
    	this.agerating = agerating;
    	this.id = ++cont; //primeiro soma dps atribui

		{
            if(genres == null || genres.size() <= 0)
            {
                logger.log(Level.WARNING, "Não foi passado um gênero!");
                this.genres = null;
            }
			
            else
            {
                this.genres = new ArrayList<>();
                //Se for maior que o tamanho máximo, mensagem de erro
                if(genres.size() > Util.MAXGENRES)
                    logger.log(Level.WARNING, "Mais de 3 gêneros foram passados!");

                //Copiar até o máximo ou o tamanho atual
                //Precisa fazer assim para criar uma cópia "deep" (ou seja, copiar valores e não endereços)
                for (int i = 0; (i < Util.MAXGENRES) && (i < genres.size()); ++i)
                    this.genres.add(genres.get(i));
            }
        }
  	}

  	public void addUserRating (float _userRating) {//funcao para as avaliações
    	nUserRatings++;	//incrementa o num de avaliacoes
    	sum += _userRating;//vai somando
    	this._userRating = sum/nUserRatings;//recebe a media
  	}

  	public void incrementViews (int nViews) {
		nViews++;	//incrementa o número de visualizações
  	}

  	public String getName() {
    	return name;
  	}
 
  	public Util.ageRatingsEnum getAgerating() {
    	return agerating;
  	}

	public ArrayList<Util.genresEnum> getGenres()
    {
		//utiliza o méétodo de cóópia de array descrito no Util
        ArrayList<Util.genresEnum> copy = (ArrayList<Util.genresEnum>) Util.CopyArray(this.genres);
        return copy;
    }

  	public int ID() {
    	return id;
  	}

  	public int getLength() {
    	if (length == -1)
    	System.out.println("Não foi atribuída uma duração para este filme!");
    	return length;
  	}

  	public void setLength(int length) {
    	this.length = length;
  	}

  	public int getYear() {
    	return year;
  	}

  	public void setYear(int year) {
    	if (year < 1878)
    	System.out.println("Não existiam filmes antes de 1878!");
    	else if (year > Calendar.getInstance().get(Calendar.YEAR));
    	this.year = year;
  	}

  	public int getnViews() {
    	return nViews;
  	}

  	public int getnUserRatings() {
    	return nUserRatings;
  	}
  
  	public float get_userRating() {
    	return _userRating;
  	}

}