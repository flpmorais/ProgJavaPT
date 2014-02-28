package ex1;

public class Vector{
	
	private final int x;
	private final int y;

	public Vector(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	
	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}
	
	public double comprimento(){
		//o 2 não é considerado um numero magico porque não é algo 
		//que eu vá alterar. A formula da norma é raiz(x^2, y^2)
		//desde o big bang até ao fim do universo.
		//tudo o que não é inalteravel pelas leis do universo
		//e for posto no codigo à paposseco como este 2 é
		//um número mágico.
		
		//Math.sqrt(a) devolv a raiz de a
		//Math.pow(a,b) devolve a elevado a b
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector produto(final Vector multi){
		return new Vector(x * multi.x, y * multi.y);
	}
	
	public Vector produto(final int escalar){
		return new Vector(x * escalar, y * escalar);
	}

	public Vector soma(final Vector v) {
		return new Vector(this.x + x ,this.y + y);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
