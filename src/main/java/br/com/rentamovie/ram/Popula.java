package br.com.rentamovie.ram;


import br.com.rentamovie.ram.model.entities.Genre;
import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.repositories.GenreRepo;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernanematida
 */
public class Popula {
    
    @Autowired
    private MovieRepo movieRepo;
    
    @Autowired
    private GenreRepo genreRepo;
    
    public void addGenre(){
        if (genreRepo.count() == 0){
            Genre genre = new Genre();
            genre.setName("Ação");
            genreRepo.save(genre);
            genre.setName("Animação");
            genreRepo.save(genre);
            genre.setName("Aventura");
            genreRepo.save(genre);
            genre.setName("Comédia");
            genreRepo.save(genre);
            genre.setName("Drama");
            genreRepo.save(genre);
            genre.setName("Ficção científica");
            genreRepo.save(genre);
            genre.setName("Romance");
            genreRepo.save(genre);
            genre.setName("Suspense");
            genreRepo.save(genre);
            genre.setName("Dança");
        }
    }
    
    public void addFilms(){
        if (movieRepo.count() == 0){
            Movie movie = new Movie();
            
            //007 contra Spectre
            movie.setName("007 contra Spectre");
            movie.setActors("Daniel Craig, Léa Seydoux, Christoph Waltz, Ben Whishaw, Naomie Harris");
            movie.setGenre(genreRepo.findGenreByName("Ação"));
            movie.setDirector("Sam Mendes");
            movie.setImageUrl("/images/film_007.jpg");
            movie.setIsNew(true);
            movie.setProspect("Após impedir um atentado terrorista na Cidade do"
                    + " México, James Bond (Daniel Craig) é afastado do serviço"
                    + " por M (Ralph Fiennes) e desobedece ordens para descobrir"
                    + " mais sobre um assassino que encontrou no México."
                    + " Enquanto M enfrenta forças políticas para manter o "
                    + "serviço secreto vivo, Bond descobre que o matador era "
                    + "empregado de uma organização criminosa,mais tarde essa "
                    + "organização é revelada como SPECTRE,a qual Bond já tinha"
                    + " enfrentado nos filmes antigos,que tinha entre seus membros"
                    + " todos os vilões dos primeiros filmes de 007.Mais tarde"
                    + " é revelado que Le Chiffre,Dominic Greene e Raoul Silva"
                    + " também fazem parte dessa organização. Neste filme os "
                    + "eventos de Casino Royale (2006), 007 - Quantum of "
                    + "Solace e Skyfall são alinhavados e encaixados num "
                    + "quebra-cabeças que por trás estava o tempo todo a "
                    + "SPECTRE arquitetando os planos e sendo derrotados "
                    + "por James Bond");
            movie.setRating(4);
            movie.setRentPrice((float) 6.50);
            movie.setTrailler("https://www.youtube.com/watch?v=ashLaclKCik");
            movie.setYear(2015);
            movieRepo.save(movie);
            
            //O poderoso chefinho
            movie.setName("O poderoso chefinho");
            movie.setActors("Narração de Tobey Maguire");
            movie.setGenre(genreRepo.findGenreByName("Animação"));
            movie.setDirector("Tom McGrath");
            movie.setImageUrl("/images/film_babyboss.jpg");
            movie.setIsNew(true);
            movie.setProspect("Tim, um menino de sete anos de idade, está com "
                    + "ciúmes de seu irmãozinho, um bebê falante de terno. "
                    + "Quando ele vai em uma missão para recuperar o carinho "
                    + "de seus pais, ele descobre uma trama em segredo pelo "
                    + "presidente da PuppyCo que gira em torno de seu irmão e "
                    + "ameaça desestabilizar o equilíbrio de amor no mundo. "
                    + "Ambos os irmãos devem unir-se para salvar seus pais, "
                    + "restaurar a ordem no mundo e provar que o amor é "
                    + "realmente uma força infinita.");
            movie.setRating(3);
            movie.setRentPrice((float) 6.00);
            movie.setTrailler("https://www.youtube.com/watch?v=r8kE7rSzfQs");
            movie.setYear(2017);
            movieRepo.save(movie);
            
            //Charlie
            movie.setName("A Morte e Vida de Charlie");
            movie.setActors("Zac Efron, Charlie Tahan, Kim Basinger, Ray Liotta,"
                    + " Amanda Crew, Chris Massoglia");
            movie.setGenre(genreRepo.findGenreByName("Romance"));
            movie.setDirector("Burr Steers");
            movie.setImageUrl("/images/film_charlie.jpg");
            movie.setIsNew(false);
            movie.setProspect("Charlie St. Cloud (Zac Efron) ganha uma bolsa de "
                    + "estudos na universidade de Stanford. Logo depois de sua "
                    + "formatura, Charlie faz uma promessa ao seu irmão mais "
                    + "novo, Sam (Charlie Tahan): treinar Beisebol com ele "
                    + "todos os dias durante 1 hora aos canhões do por do sol "
                    + "até Charlie ir para a faculdade. Em uma noite, a mãe dos"
                    + " dois, Claire (Kim Basinger) pede para Charlie cuidar de"
                    + " Sam, por que ela iria pegar um turno extra no hospital."
                    + " Sam acaba pegando Charlie saindo escondido e pede uma"
                    + " carona a Charlie para a casa de seu amigo Tommy, mas "
                    + "no meio do percurso um carro bate no carro de Charlie "
                    + "depois um caminhão acerta o lado de Sam. Com sorte, C"
                    + "harlie sobrevive, e tem mais uma segunda chance mas "
                    + "seu irmão não teve a mesma sorte.");
            movie.setRating(2);
            movie.setRentPrice((float) 3.70);
            movie.setTrailler("https://www.youtube.com/watch?v=KyplZ7b7UfY");
            movie.setYear(2010);
            movieRepo.save(movie);
            
            //O poderoso chefão
            movie.setName("O poderoso chefão");
            movie.setActors("Marlon Brando, Al Pacino, James Caan, Richard "
                    + "Castellano, Robert Duvall, Sterling Hayden, John Marley"
                    + ", Richard Conte, Diane Keaton");
            movie.setGenre(genreRepo.findGenreByName("Drama"));
            movie.setDirector("Francis Ford Coppola");
            movie.setImageUrl("/images/film_chefao.jpg");
            movie.setIsNew(false);
            movie.setProspect("No verão de 1945, Don Vito Corleone ouve pedidos"
                    + " de favores durante o casamento da sua filha Connie, "
                    + "enquanto o seu consigliere e filho adotivo, Tom Hagen, "
                    + "apenas escuta. O cantor e afilhado do Don, Johnny "
                    + "Fontane, pede ajuda para estrelar um filme que vai "
                    + "ajudá-lo a reerguer sua carreira. Hagen vai a Califórnia "
                    + "para se encontrar com o chefe do estúdio Jack Woltz com "
                    + "o objetivo de adquirir o papel para Fontane. Depois de "
                    + "recusar-se a escalar Fontane, ele desperta na manhã "
                    + "seguinte com a cabeça decapitada do seu valioso e "
                    + "estimado cavalo Khartum na cama.");
            movie.setRating(5);
            movie.setRentPrice((float) 3.00);
            movie.setTrailler("https://www.youtube.com/watch?v=sY1S34973zA");
            movie.setYear(1972);
            movieRepo.save(movie);
            
            //Mission impossible
            movie.setName("Missão Impossível: Nação Secreta ");
            movie.setActors("Tom Cruise, Rebecca Ferguson, Simon Pegg, Jeremy "
                    + "Renner, Ving Rhames, Sean Harris, Alec Baldwin");
            movie.setGenre(genreRepo.findGenreByName("Ação"));
            movie.setDirector("Christopher McQuarrie");
            movie.setImageUrl("/images/film_mi.jpg");
            movie.setIsNew(true);
            movie.setProspect("Após evitar que armas de gás fossem vendidas a "
                    + "terroristas chechenos, o agente do IMF - Impossible "
                    + "Missions Force (ou Força Missão Impossível) Ethan Hunt"
                    + " é capturado por um grupo terrorista de agentes espiões"
                    + " de vários países que foram dados como mortos, chamado "
                    + "Sindicato, e consegue fugir graças a ajuda de uma mulher"
                    + " misteriosa. Ethan contata o Diretor de Operações de "
                    + "Campo da IMF, Wiliam Brandt, e fica sabendo que a "
                    + "organização secreta foi dissolvida e que todos os "
                    + "agentes devem se apresentar à CIA.");
            movie.setRating(4);
            movie.setRentPrice((float) 4.30);
            movie.setTrailler("https://www.youtube.com/watch?v=F-qBD17wwrQ");
            movie.setYear(2015);
            movieRepo.save(movie);
            
            //Rogue one
            movie.setName("Rogue One: Uma História Star Wars");
            movie.setActors("Felicity Jones, Diego Luna, Ben Mendelsohn, Guy Herny,"+
                "Donnie Yen, Mads Mikkelsen");
            movie.setGenre(genreRepo.findGenreByName("Aventura"));
            movie.setDirector("Gareth Edwards");
            movie.setImageUrl("/images/film_rogueone.jpg");
            movie.setIsNew(true);
            movie.setProspect("A história se inicia 13 anos antes da explosão "
                    + "da primeira Estrela da Morte. Seis anos haviam se "
                    + "passado após a extinção da Ordem dos Cavaleiros Jedis, o"
                    + " desaparecimento do jovem Jedi Anakin Skywalker, o "
                    + "surgimento do cruel Lorde Sith Darth Vader como também "
                    + "o fato do Imperador Palpatine ter transformado a"
                    + " República Galáctica no temível Império Galáctico."
                    + " A galáxia agora se encontrava dominada pela ditadura, "
                    + "escravidão e opressão. O Império Galáctico, inicia então"
                    + " uma busca por pessoas que possam contribuir para a "
                    + "construção de uma super-arma.");
            movie.setRating(4);
            movie.setRentPrice((float) 3.89);
            movie.setTrailler("https://www.youtube.com/watch?v=sC9abcLLQpI");
            movie.setYear(2016);
            movieRepo.save(movie);
            
            //Ragnarock
            movie.setName("Thor: Ragnarok");
            movie.setActors("Chris Hemsworth, Tom Hiddleston, Cate Blanchett,"
                    + " Idris Elba, Tessa Thompson");
            movie.setGenre(genreRepo.findGenreByName("Aventura"));
            movie.setDirector("Taika Waititi");
            movie.setImageUrl("/images/film_thor.jpg");
            movie.setIsNew(true);
            movie.setProspect("Dois anos depois da Batalha de Sokovia, "
                    + "Thor procura sem sucesso as Joias do Infinito, "
                    + "e agora é preso pelo demônio de fogo Surtur. Surtur "
                    + "revela que o pai de Thor, Odin, não está mais em Asgard,"
                    + " e que o reino logo será destruído pelo Ragnarok "
                    + "profetizado, uma vez que Surtur una sua coroa com a "
                    + "Chama Eterna que queima no cofre de Odin. Thor derrota "
                    + "Surtur e reivindica sua coroa, acreditando que ele "
                    + "impediu Ragnarok.");
            movie.setRating(3);
            movie.setRentPrice((float) 4.00);
            movie.setTrailler("https://www.youtube.com/watch?v=v7MGUNV8MxU");
            movie.setYear(2017);
            movieRepo.save(movie);
            
        }
    }
    
}
