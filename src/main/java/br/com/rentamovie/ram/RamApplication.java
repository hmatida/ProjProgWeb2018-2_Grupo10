package br.com.rentamovie.ram;

import br.com.rentamovie.ram.model.entities.Genre;
import br.com.rentamovie.ram.model.entities.Movie;
import br.com.rentamovie.ram.model.repositories.GenreRepo;
import br.com.rentamovie.ram.model.repositories.MovieRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RamApplication {

    public static void main(String[] args) {
        SpringApplication.run(RamApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MovieRepo movieRepo, GenreRepo genreRepo) {
        return args -> {
            popula(movieRepo, genreRepo);
        };
    }

    public void popula(MovieRepo movieRepo, GenreRepo genreRepo) {
        if (genreRepo.count() == 0) {
            Genre genre = new Genre();
            genre.setName("Ação");
            Genre genre2 = new Genre();
            genreRepo.save(genre);
            genre2.setName("Animação");
            genreRepo.save(genre2);
            Genre genre3 = new Genre();
            genre3.setName("Aventura");
            genreRepo.save(genre3);
            Genre genre4 = new Genre();
            genre4.setName("Comédia");
            genreRepo.save(genre4);
            Genre genre5 = new Genre();
            genre5.setName("Drama");
            genreRepo.save(genre5);
            Genre genre6 = new Genre();
            genre6.setName("Ficção científica");
            genreRepo.save(genre6);
            Genre genre7 = new Genre();
            genre7.setName("Romance");
            genreRepo.save(genre7);
            Genre genre8 = new Genre();
            genre8.setName("Suspense");
            genreRepo.save(genre8);
            Genre genre9 = new Genre();
            genre9.setName("Dança");
            genreRepo.save(genre9);
        }

        if (movieRepo.count() == 0) {
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
                    + "organização é revelada como SPECTRE");
            movie.setRating(4);
            movie.setRentPrice((float) 6.50);
            movie.setTrailler("9mseplf-llU");
            movie.setYear(2015);
            movieRepo.save(movie);
            
            Movie movie2 = new Movie();
            //O poderoso chefinho
            movie2.setName("O poderoso chefinho");
            movie2.setActors("Narração de Tobey Maguire");
            movie2.setGenre(genreRepo.findGenreByName("Animação"));
            movie2.setDirector("Tom McGrath");
            movie2.setImageUrl("/images/film_babyboss.jpg");
            movie2.setIsNew(true);
            movie2.setProspect("Tim, um menino de sete anos de idade, está com "
                    + "ciúmes de seu irmãozinho, um bebê falante de terno. "
                    + "Quando ele vai em uma missão para recuperar o carinho "
                    + "de seus pais, ele descobre uma trama em segredo pelo "
                    + "presidente da PuppyCo que gira em torno de seu irmão e "
                    + "ameaça desestabilizar o equilíbrio de amor no mundo. "
                    + "Ambos os irmãos devem unir-se para salvar seus pais, "
                    + "restaurar a ordem no mundo e provar que o amor é "
                    + "realmente uma força infinita.");
            movie2.setRating(3);
            movie2.setRentPrice((float) 6.00);
            movie2.setTrailler("r8kE7rSzfQs");
            movie2.setYear(2017);
            movieRepo.save(movie2);

            //Charlie
            Movie movie3 = new Movie();
            movie3.setName("A Morte e Vida de Charlie");
            movie3.setActors("Zac Efron, Charlie Tahan, Kim Basinger, Ray Liotta,"
                    + " Amanda Crew, Chris Massoglia");
            movie3.setGenre(genreRepo.findGenreByName("Romance"));
            movie3.setDirector("Burr Steers");
            movie3.setImageUrl("/images/film_charlie.jpg");
            movie3.setIsNew(false);
            movie3.setProspect("Charlie St. Cloud (Zac Efron) ganha uma bolsa de "
                    + "estudos na universidade de Stanford. Logo depois de sua "
                    + "formatura, Charlie faz uma promessa ao seu irmão mais "
                    + "novo, Sam (Charlie Tahan): treinar Beisebol com ele "
                    + "todos os dias durante 1 hora aos canhões do por do sol "
                    + "até Charlie ir para a faculdade.");
            movie3.setRating(1);
            movie3.setRentPrice((float) 3.70);
            movie3.setTrailler("KyplZ7b7UfY");
            movie3.setYear(2010);
            movieRepo.save(movie3);

            //O poderoso chefão
            Movie movie4 = new Movie();
            movie4.setName("O poderoso chefão");
            movie4.setActors("Marlon Brando, Al Pacino, James Caan, Richard "
                    + "Castellano, Robert Duvall, Sterling Hayden, John Marley"
                    + ", Richard Conte, Diane Keaton");
            movie4.setGenre(genreRepo.findGenreByName("Drama"));
            movie4.setDirector("Francis Ford Coppola");
            movie4.setImageUrl("/images/film_chefao.jpg");
            movie4.setIsNew(false);
            movie4.setProspect("No verão de 1945, Don Vito Corleone ouve pedidos"
                    + " de favores durante o casamento da sua filha Connie, "
                    + "enquanto o seu consigliere e filho adotivo, Tom Hagen, "
                    + "apenas escuta.");
            movie4.setRating(5);
            movie4.setRentPrice((float) 3.00);
            movie4.setTrailler("sY1S34973zA");
            movie4.setYear(1972);
            movieRepo.save(movie4);

            //Mission impossible
            Movie movie5 = new Movie();
            movie5.setName("Missão Impossível: Nação Secreta ");
            movie5.setActors("Tom Cruise, Rebecca Ferguson, Simon Pegg, Jeremy "
                    + "Renner, Ving Rhames, Sean Harris, Alec Baldwin");
            movie5.setGenre(genreRepo.findGenreByName("Ação"));
            movie5.setDirector("Christopher McQuarrie");
            movie5.setImageUrl("/images/film_mi.jpg");
            movie5.setIsNew(true);
            movie5.setProspect("Após evitar que armas de gás fossem vendidas a "
                    + "terroristas chechenos, o agente do IMF - Impossible "
                    + "Missions Force (ou Força Missão Impossível) Ethan Hunt"
                    + " é capturado por um grupo terrorista de agentes espiões"
                    + " de vários países que foram dados como mortos, chamado "
                    + "Sindicato.");
            movie5.setRating(4);
            movie5.setRentPrice((float) 4.30);
            movie5.setTrailler("qBD17wwrQ");
            movie5.setYear(2015);
            movieRepo.save(movie5);

            //Rogue one
            Movie movie6 = new Movie();
            movie6.setName("Rogue One: Uma História Star Wars");
            movie6.setActors("Felicity Jones, Diego Luna, Ben Mendelsohn, Guy Herny,"
                    + "Donnie Yen, Mads Mikkelsen");
            movie6.setGenre(genreRepo.findGenreByName("Aventura"));
            movie6.setDirector("Gareth Edwards");
            movie6.setImageUrl("/images/film_rogueone.jpg");
            movie6.setIsNew(true);
            movie6.setProspect("A história se inicia 13 anos antes da explosão "
                    + "da primeira Estrela da Morte. Seis anos haviam se "
                    + "passado após a extinção da Ordem dos Cavaleiros Jedis, o"
                    + " desaparecimento do jovem Jedi Anakin Skywalker.");
            movie6.setRating(4);
            movie6.setRentPrice((float) 3.89);
            movie6.setTrailler("frdj1zb9sMY");
            movie6.setYear(2016);
            movieRepo.save(movie6);

            //Ragnarock
            Movie movie7 = new Movie();
            movie7.setName("Thor: Ragnarok");
            movie7.setActors("Chris Hemsworth, Tom Hiddleston, Cate Blanchett,"
                    + " Idris Elba, Tessa Thompson");
            movie7.setGenre(genreRepo.findGenreByName("Aventura"));
            movie7.setDirector("Taika Waititi");
            movie7.setImageUrl("/images/film_thor.jpg");
            movie7.setIsNew(true);
            movie7.setProspect("Dois anos depois da Batalha de Sokovia, "
                    + "Thor procura sem sucesso as Joias do Infinito, "
                    + "e agora é preso pelo demônio de fogo Surtur.");
            movie7.setRating(3);
            movie7.setRentPrice((float) 4.00);
            movie7.setTrailler("v7MGUNV8MxU");
            movie7.setYear(2017);
            movieRepo.save(movie7);

        }
    }
}
