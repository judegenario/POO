import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;

/*-------------------------------testando a biblioteca de media-----------------------------------------*/
public class Main
{
    public static void main(String[] args) throws ParseException, FileNotFoundException
    {
        ArrayList<Person>	personList = new ArrayList<>();	//instanciando lista de pessoas
        ArrayList<Media> mediaList = new ArrayList<>();	//instanciando lista de filmes e series

        readPerson(personList);	//método para ler as pessoas de um arquivo
        readMedia(mediaList, personList);	//método para ler as medias de um arquivo
		printActors(personList);//método para printar os atores
		//printSeries(mediaList, personList);//método para printar apenas as Séries

    }

	/*--------------------método para ler as pessoas (ator e diretor) de um arquivo---------------------------*/
    private static void readPerson(ArrayList<Person> personList) throws FileNotFoundException, ParseException
    {
    	BufferedInputStream in = new BufferedInputStream(new FileInputStream("person.in"));
        System.setIn(in);

        //Criando instância do Scanner para ler Arquivo em Java
        Scanner scnr = new Scanner(System.in);

        //lê cada linha com a classe Scanner
        Person auxPer;
		int age=0;
        String auxName, auxCountry, auxBirth;//variáveis auxiliares
		int op;//inteiro para identificar se é ator ou diretor
        do {
			op = Integer.parseInt(scnr.nextLine());//ler a operação desejada
            auxName = scnr.nextLine();
            auxCountry = scnr.nextLine();
            auxBirth = scnr.nextLine();
            if(op == 1){
              auxPer = new Director(auxName, auxCountry, auxBirth, age);
            }
            else{
              auxPer = new Actor(auxName, auxCountry, auxBirth, age);
            }
            personList.add(auxPer);	//coloca todas as leituras no mesmo arrayList (PersonList)
          } while(scnr.hasNextLine());

        for (Person per: personList)	//loop para printar as informações na tela
        {
            System.out.println("Actor name: "+per.getName());
            System.out.println("Actor country: "+per.getCountry());
            System.out.println("Actor birthdate: "+per.getBirthdate());
			System.out.println("Age: "+per.getAge());
            System.out.println("");
        }
    }

	/*--------------------método para ler a media de um arquivo---------------------------*/
	private static void readMedia(ArrayList<Media> mediaList, ArrayList<Person> personList) throws FileNotFoundException, ParseException
    {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("media.in"));
        System.setIn(in);

        //Criando instância do Scanner para ler Arquivo em Java
        Scanner scnr = new Scanner(System.in);

        //lê cada linha com a classe Scanner

        Media auxMed;
		String auxName,  auxNameEp;
		Util.ageRatingsEnum auxClasInd;
		int auxNumActors=0, auxInd=0, auxNumGen=0, auxNumEp=0, auxNumTemp=0;
		int op;//inteiro para identificar se é filme ou série
		Director auxDirector = null;
		//auxDirector = (Director) personList.get(Integer.parseInt(scnr.nextLine()));
		ArrayList <Util.genresEnum> auxGen = new ArrayList<>();
		ArrayList <Actor> auxIndActors = new ArrayList<>();
		//auxSeries = new Series(auxName, auxClasInd, auxGen);

        do {
			auxGen = new ArrayList<>();
			op = Integer.parseInt(scnr.nextLine());//ler a operação desejada
            if(op == 1){	//entra caso seja filme

				auxName = scnr.nextLine();
				auxInd = Integer.parseInt(scnr.nextLine());
				auxClasInd = Util.ageRatingsEnum.valueOf(scnr.nextLine());
				auxNumGen = Integer.parseInt(scnr.nextLine());

				for (int i = 0; i < auxNumGen; i++){//loop para ler os gêneros
					auxGen.add(Util.genresEnum.valueOf(scnr.nextLine()));
                }
				auxNumActors = Integer.parseInt(scnr.nextLine());

				for (int i = 0; i < auxNumActors; i++){//loop para ler os indices do atores
                    auxIndActors.add((Actor) personList.get(Integer.parseInt(scnr.nextLine())));
                }

            	auxMed = new Movie(auxName, auxDirector, auxIndActors, auxClasInd, auxGen);		

            }
            else{	//caso seja séérie
				/*Series auxSeries;
				auxSeries = new Series(auxName, auxDirector, auxIndActors, auxClasInd, auxGen);*/
				auxName = scnr.nextLine();
				auxClasInd = Util.ageRatingsEnum.valueOf(scnr.nextLine());
				auxNumGen = Integer.parseInt(scnr.nextLine());

				for (int i = 0; i < auxNumGen; i++){//loop para ler os gêneros
                    auxGen.add(Util.genresEnum.valueOf(scnr.nextLine()));
                }
				auxNumTemp = Integer.parseInt(scnr.nextLine());

				for (int i = 0; i < auxNumTemp; i++){//loop para ler os gêneros
                    auxNumEp = Integer.parseInt(scnr.nextLine());
					

					for (int j = 0; j < auxNumEp; j++){//loop para ler as info de cada episodio
                    	auxNameEp = scnr.nextLine();
						auxInd = Integer.parseInt(scnr.nextLine());
						auxDirector = ((Director) personList.get(auxInd));//acessando o diretor pelo indice
						auxNumActors = Integer.parseInt(scnr.nextLine());

						for (int k = 0; k < auxNumActors; k++){//loop para ler os indices do atores
                    		auxIndActors.add((Actor) personList.get(Integer.parseInt(scnr.nextLine())));
						}

						//auxSeries.addEpisode(new Episode(j, i, auxName, auxDirector, auxIndActors, auxClasInd, auxGen), i);
                	}

                }

				//mediaList.add(auxSeries);
            	auxMed = new Series(auxName, auxDirector, auxIndActors, auxClasInd, auxGen);
            }

            mediaList.add(auxMed);	//coloca todas as medias em uma arraylist sóó
        } while(scnr.hasNextLine());


/*--------------------------------------------exibindo as informações de media----------------------------------*/
		for (Media med: mediaList){	//loop para printar as informações de media na tela
			System.out.println("Name: "+med.getName());
			System.out.println("Age rating: "+med.getAgerating());
			if(med.getGenres()!=null){
				System.out.println("Genres: ");
				for (int k = 0; k < med.getGenres().size(); k++){//loop para ler os indices do atores
					System.out.println(med.getGenres().get(k).toString());
				}
			}
			else{
				System.out.println("No genres found ");
			}
			System.out.println("");
    	}
        
    }

	//VERIFICAR COMO FAZ ESSAS FUNÇÕES E CHAMA-LAS NA MAIN

	/*------------------------------------------Imprime as Series--------------------------------------*/

	public static void printSeries(ArrayList<Media> mediaList, ArrayList<Person> personList) throws ParseException, FileNotFoundException
    {
		/*personList = new ArrayList<>();	
        mediaList = new ArrayList<>();*/
		for (Media med: mediaList)	//loop para printar as informações na tela
        {
        	if(med instanceof Series) {
        		System.out.println("Name: "+med.getName());
				System.out.println("Number of seasons: "+((Series)med).getNSeasons());
				for (int k = 0; k < (((Series)med).getNSeasons()); k++){//loop para ler os indices do atores
					System.out.println("Número de episódios: "+(((Series)med).getNEpisodesinSeason(k)));	
				}
      		}
        }
		System.out.println("");
    }
	/*------------------------------------------Imprime os atores--------------------------------------*/
	public static void printActors(ArrayList<Person> personList) throws ParseException, FileNotFoundException
    {
		for (Person per: personList)	//loop para printar as informações na tela
        {
        	if(per instanceof Actor) {
        		System.out.println("Name: "+per.getName());
      		}
        }
		System.out.println("");
    }

}