import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Questao4 {

	public static Integer contador = 0;
	
	static class Museu{
		private String lacuna;
		private String cor;
			
		public Museu(String lacuna, String cor) {
			super();
			this.lacuna = lacuna;
			this.cor = cor;
		}
		public String getLacuna() {
			return lacuna;
		}
		public void setLacuna(String lacuna) {
			this.lacuna = lacuna;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}		
	}
	
	
	
	private static void verificaEixoY(Integer X, Integer Y, Museu[][] museu, Integer N, Integer M) {
		museu[X][Y].setCor("GRAY");
		while(museu[X][Y].getLacuna().equals(".")) {
			if(Y-1 >= 0 &&
					museu[X][Y-1].getCor().equals("WHITE")
					&& museu[X][Y-1].getLacuna().equals("*")) {
				museu[X][Y-1].setCor("BLACK");
				contador++;
			}
			if(Y-1 >= 0 &&
					museu[X][Y-1].getCor().equals("WHITE")
					&& museu[X][Y-1].getLacuna().equals(".")) {
				verificaEixoY(X, Y-1, museu, N, M);
			}
			if(Y+1 <= N &&
					museu[X][Y+1].getCor().equals("WHITE")
					&& museu[X][Y+1].getLacuna().equals("*")) {
				museu[X][Y-1].setCor("BLACK");
				contador++;
			}
			if(Y+1 <= N &&
					museu[X][Y+1].getCor().equals("WHITE")
					&& museu[X][Y+1].getLacuna().equals(".")) {
				verificaEixoY(X, Y+1, museu, N, M);
			}
			verificaEixoX(X, Y, museu, M, N);
			Y++;
		}
		museu[X][Y].setCor("BLACK");
	}
	
	private static void verificaEixoX(Integer X, Integer Y, Museu[][] museu, Integer M, Integer N) {
		museu[X][Y].setCor("GRAY");
		while(museu[X][Y].getLacuna().equals(".")) {
			if(X-1 >= 0 &&
					museu[X-1][Y].getCor().equals("WHITE")
					&& museu[X-1][Y].getLacuna().equals("*")) {
				museu[X-1][Y].setCor("BLACK");
				contador++;
			}
			if(X-1 >= 0 &&
					museu[X-1][Y].getCor().equals("WHITE")
					&& museu[X-1][Y].getLacuna().equals(".")) {
				verificaEixoX(X-1, Y, museu, M, N);
				verificaEixoY(X-1, Y, museu, N, N);
			}
			if(X+1 <= M &&
					museu[X+1][Y].getCor().equals("WHITE")
					&& museu[X+1][Y].getLacuna().equals("*")) {
				museu[X+1][Y].setCor("BLACK");
				contador++;
			}
			if(X+1 <= M &&
					museu[X+1][Y].getCor().equals("WHITE")
					&& museu[X+1][Y].getLacuna().equals(".")) {
				verificaEixoX(X+1, Y, museu, M, N);
				verificaEixoY(X-1, Y, museu, N, N);
			}
			X++;
		}
		museu[X][Y].setCor("BLACK");
	}
	
	
	
	public static void main(String[] args) {
		
		Integer M, N, K, X = 0, Y = 0;
		List<Integer> qntVisualizacoes = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		Museu[][] museu = new Museu[M][N];
		for(int i = 0; i < M; i++){
			sc = new Scanner(System.in);
			String linha = sc.nextLine();
			for(int j = 0; j < N; j++) {
				Museu mus = new Museu(linha.substring(j, j+1), "WHITE");
				museu[i][j] = mus;
			}
		}
		for(int i = 0; i < K; i++) {
			sc = new Scanner(System.in);
			X = sc.nextInt();
			Y = sc.nextInt();
			verificaEixoY(X-1, Y-1, museu, N, M);
			qntVisualizacoes.add(contador);
			for(int k = 0; k < M; k++){
				for(int u = 0; u < N; u++) {
					museu[k][u].setCor("WHITE");;
				}
			}
			contador = 0;
		}
		sc.close();
		for (Integer vis : qntVisualizacoes) {
			System.out.println(vis);
		}	
		
}
		
	
	
	
}
