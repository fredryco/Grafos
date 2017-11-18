import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Museum {
	
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
	
	
	
	private static Integer dfs(Integer X, Integer Y, Integer M, Integer N, Museu[][] museu) {
		museu[X][Y].setCor("CINZA");
		Integer soma = 0;
		for(int i = -1; i <=1; i +=2){
	        if(Y+i >= 0 && Y+i < N){
	            if(museu[Y+i][X].getLacuna().equals('*')) {
	            	soma++;	
	            }	
	            else if(museu[Y+i][X].getLacuna().equals('.')  && museu[Y+i][X].getCor().equals("BRANCO")) {
	            	soma += dfs(X,Y+i, M, N, museu);
	            }    	
	        }
	        if(X+i >= 0 && X+i < M){
	            if(museu[Y][X+i].getLacuna().equals('*'))
	            	soma++;
	            else if(museu[Y][X+i].getLacuna().equals('.') && museu[Y][X+i].getCor().equals("BRANCO"))
	            	soma += dfs(X+i,Y, M, N, museu);
	        }
	       
		}
		museu[X][Y].setCor("PRETO");
		 return soma;
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
			qntVisualizacoes.add(dfs(X-1, Y-1, M, N, museu));
			for(int k = 0; k < M; k++){
				for(int u = 0; u < N; u++) {
					museu[k][u].setCor("WHITE");;
				}
			}
		}
		sc.close();
		for (Integer vis : qntVisualizacoes) {
			System.out.println(vis);
		}	
	
	
	
	}
}
