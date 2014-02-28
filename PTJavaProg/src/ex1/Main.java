package ex1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Vai imprimir as coordenadas de este!");
		System.out.println(PontoCardeal.ESTE);
		

		System.out.println("Vai imprimir os 4 pontos cardeais!");
		for(int i = 0; i < PontoCardeal.values().length; i++){
			System.out.println(PontoCardeal.values()[i]);
		}
		
		exemploSoma();
		exemploEscalar();
		exemploMultiplicacao();
	}

	private static void exemploMultiplicacao() {
		Vector v1 = new Vector(1, 2);
		Vector v2 = new Vector(2, 2);
		Vector v3 = v1.produto(v2);
		System.out.println(v1 + "*" + v2 + " = " + v3);
	}

	private static void exemploEscalar() {
		Vector v1 = new Vector(1, 2);
		int escalar = 2;
		Vector v2 = v1.produto(escalar);
		System.out.println(v1 + "*" + escalar + " = " + v2);
	}

	private static void exemploSoma() {
		Vector v1 = new Vector(1, 2);
		Vector v2 = new Vector(2, 2);
		Vector v3 = v1.soma(v2);
		System.out.println(v1 + "+" + v2 + " = " + v3);
	}
}
