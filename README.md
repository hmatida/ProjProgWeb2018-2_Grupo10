# Rent A Movie

## Grupo: 10

Sistema de locação de filmes.
Projeto avaliativo da disciplina de Programação para Web 2018-2 da UFMS.

## Acadêmicos:

	*Thyago Henrique Araújo oliveira ->Testes
	*Thiago Conte -> Desenvolvimento front-end e formulários.
	*Murilo Marques -> Atualização dos diagramas 
	*Hernane Matida -> Desenvolvimento back-end e integração com o front-end.

## Tecnologias:

	Projeto em Spring Boot com maven para importação de bibliotecas.
	Banco de dados PostgreSQL.
	Botstrap 4 como framework CSS.
	Nome do banco no projeto: rm_bd01
	Modificar o arquivo /src/main/resources/appication.properties alterando os campos abaixo:
		spring.datasource.username=aqui vai o usuário no postgres (geralemente postgres em instalação default)
		spring.datasource.password=senha do postgres colocada no ato da instalação.
		
	O arquivo "/src/main/java/br/com/rentamovie/ram/RamApplication.java" trata-se da classe main que executará a apicação quando compilada.

## Acesso ao sistema após compilação (via browser)

	* Usuário padrão default:

		admin@admin.com

	*Senha:

		123456


## Organização do repositório:

Back-end:
	
		/src/main/java/br/com/rentamovie/ram/ -> Contém os códigos fontes em java para o back-end da aplicação, tais como models (entities, services e repositories) e controllers.
		
Front-end:
	
		/src/main/resources/ -> Arquivos das views e suas estruturas como scripts, estilos e imagens.
		
			/static/ -> Scripts, imagens e folha de estilo personalizada.
			
			/templates/ -> Arquivos em html das views.
			
			application.properties -> Arquivo de configuração para acesso ao banco de dados.
