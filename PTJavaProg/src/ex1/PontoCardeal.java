package ex1;

import java.util.Random;

/**
 * 
 * Representa um ponto cardeal. O ponto poderá ser:<br>
 * <br>
 * NORTE -> Coordenadas: x = 0, y = 1;<br>
 * ESTE -> Coordenadas: x = 1, y = 0; <br>
 * SUL -> Coordenadas: x = 0, y = -1; <br>
 * OESTE -> Coordenadas: x = -1, y = 0;<br>
 * <br>
 * Seria tentador utilizar directamente o x e o y, mas é mais correcto (e no
 * contexto deste problema é mesmo necessário, mas vamos ficar pelo correcto)
 * ter uma representação da coordenada porque assim vamos poder utilizar, por
 * exemplo, a coordenada do norte (directamente) para fazer operações com outras
 * coordenadas, sem ter de andar a fazer getX e getY. <br>
 * Outra erro comum será criar herança aqui e fazer um
 * <code>PontoCardeal extends Coordenada</code> ou
 * <code>PontoCardeal implements Coordenada</code>. No entanto, isso é errado
 * porque:<br>
 * 1-> Num enumerado não podemos fazer herança directa, ou seja, o extends não
 * funciona (mas o implements funciona, atenção). <br>
 * 2-> Composição sobre herança, ou seja, quando tivermos de escolher entre
 * "classe A é B ou Classe A tem B", devemos escolher "classe A tem B".
 * ****long story para outro dia****<br>
 * <br>
 * Quanto ao facto de eu usar um Vector em vez de uma coordenada, isso está/estará na
 * documentação do vector =)<br>
 * <br>
 * 
 * @author Filipe Morais
 * @version 1.0
 */
public enum PontoCardeal {
	// nota: separa-se os valores do enumerado com uma virgula, mas o último tem
	// de ser um ponto e virgula.
	NORTE(0, 1), ESTE(1, 0), SUL(0, -1), OESTE(-1, 0);

	// O enumerado pode ter variaveis, no entanto, são imutáveis(as coordenadas
	// são definidas através dos valores do enumerado (ver código directamente
	// acima).
	private final Vector vector;

	// Se o enumerado não tiver variáveis (tipo o x e o y), não é preciso
	// construtor. Mas se tiver, tem de existir e tem de ser PRIVADO!!!
	// Isto porque o programador nunca invoca o construtor (i.e. nunca faz
	// PontoCardeal ponto = new PontoCardeal(x,y));
	// Este construtor PRIVADO serve para o compilador fazer uns mambos e
	// criar os objetos sozinho
	private PontoCardeal(final int x,final  int y) {
		this.vector = new Vector(x, y);
	}

	/**
	 * Retorna um ponto cardeal aleatorio, é estática porque nós nunca fazemos
	 * ESTE.getAleatorio(), ou seja, não é suposto usar-mos sobre um objecto que
	 * ja existe. É suposto usar-mos esta função com a classe de forma a criar
	 * um objecto novo, ou seja:<br>
	 * <br>
	 * <code>PontoCardeal novo = PontoCardeal.getAleatorio();</code>
	 * <br>
	 * getAleatorio em uma linha de codigo<br>
	 * <br>
	 * @return Ponto Cardeal aleatorio
	 */
	public static PontoCardeal getAleatorio() {
		//Eu chamei a classe com letra grande(PontoCardeal) e desta forma o
		//getAleatorio foi chamado "de forma estática", ou seja, nao esta associado
		//a nenhum objecto.
		return values()[(new Random()).nextInt(values().length)];
	}

	/**
	 * Retorna um ponto cardeal aleatorio.<br>
	 * <br>
	 * getAleatorio sem ser em uma linha de codigo<br>
	 * <br>
	 * @return ponto cardeal aleatorio
	 */
	public PontoCardeal getAleatorioExplicado() {
		// primeiro vamos buscar todos os valores possiveis de pontos. Um
		// enumerado guarda esses valores todos nos values.
		// basta fazer: "PontoCardeal.values()". 
		// Como estamos "dentro do ponto cardeal",
		// basta fazer "values();
		// O values é um array com:
		// values()[0] = Norte
		// values()[1] = ESTE
		// values()[2] = SUL
		// values()[3] = OESTE
		// Como dá para ver, eles ficam automaticamente neste array pela ordem
		// em que nós os declaramos lá em cima

		PontoCardeal[] valoresDosPontos = values();

		// Agora vamos criar um random
		Random rnd = new Random();

		// E obter um valor aleatório entre 0 e 3 que são os valores das chaves
		// do array(0 para norte, 1 para este, etc).
		// utilizamos o length (tamanho do array values()) para dizer qual o
		// valor máximo do nosso random
		// (neste caso sabemos que devolve 3, caso fossem 10 pontos ele
		// devolvia 10).
		// é sempre mais fácil chamar "values().length" que contar quantos
		// valores estão no enum ^_^
		int numeroDoPontoADevolver = rnd.nextInt(valoresDosPontos.length);

		// Agora so temos de devolver esse ponto. Vamos entao devolver o
		// ponto que está no array values() na posição "numerodoPontoADevolver":
		return values()[numeroDoPontoADevolver];
	}

	/**
	 * Devolve o proximo ponto cardeal. Ou seja, se tiver-mos a Norte, devolve
	 * Este, se tiver-mos a ESTE, devolve SUL, etc. por exemplo:<br>
	 * <code>
	 * PontoCardeal exemplo = PontoCardeal.ESTE; <br>
	 * PontoCardeal proxima = exemplo.getProxima(); <br>
	 * </code> <br>
	 * Sysout(proxima) iria imprimir "Oeste".
	 * 
	 * @return proximo ponto cardeal
	 */
	public PontoCardeal getProxima() {
		// para sabermos qual o valor deste ponto cardeal utilizamos o ordinal()
		// ("this.ordinal()", embora possamos omitir o this).
		// Conseguimos saber se um ponto cardeal é o último de todos se o
		// ordinal() for igual ao último valor do values().
		// Sabendo que é a ultima vamos devolver a primeira, se não for a última
		// devolvemos a proxima (ordinal() + 1).
		// Temos sempre de impedir que o ciclo ultrapasse o último, porque se
		// fizermos ordinal() + 1 e o ponto cardeal for a 3 (Oeste), vai
		// dar 4 que não existe -> ia dar buraco.

		if (this.ordinal() == values().length - 1) {
			return values()[0];
		} else {
			return values()[ordinal() + 1];
		}
	}

	
	/**
	 * Devolve o vector que representa este ponto cardeal.<br>
	 * NORTE -> Coordenadas: x = 0, y = 1;<br>
	 * ESTE -> Coordenadas: x = 1, y = 0; <br>
	 * SUL -> Coordenadas: x = 0, y = -1; <br>
	 * OESTE -> Coordenadas: x = -1, y = 0;<br>
	 * <br>
	 * @return Vector representativo deste ponto cardeal
	 */
	public Vector getVector() {
		return vector;
	}

	public String toString() {
		return vector.toString();
	}

}
