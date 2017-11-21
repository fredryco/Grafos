import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	static class Estacao{
		private Integer estacao1;
		private Integer estacaoLigada;
		private String cor;
		
		public Estacao(Integer estacao1, String cor, Integer estacaoLigada) {
			super();
			this.estacao1 = estacao1;
			this.cor = cor;
			this.estacaoLigada = estacaoLigada;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}
		
		public Integer getEstacao1() {
			return estacao1;
		}
		public void setEstacao1(Integer estacao1) {
			this.estacao1 = estacao1;
		}

		public Integer getEstacaoLigada() {
			return estacaoLigada;
		}

		public void setEstacaoLigada(Integer estacaoLigada) {
			this.estacaoLigada = estacaoLigada;
		}
			
	}
		
	
	private static Boolean estacaoConectada(List<Estacao> estacoes, Integer estacao){
		for (int i = 0; i < estacao; i++) {
			if(estacoes.get(i).getCor() == "BRANCO") {
				return false;
			}
		}
		return true;
	}
	
	public static void buscaEmProfundidade(List<Estacao> estacoes, Integer totalEstacao, Integer estacaoVerificar) {
		estacoes.get(estacaoVerificar).setCor("CINZA");
		for(int i = 0; i < totalEstacao; i++) {
			if(estacoes.get(i).getCor().equals("BRANCO")
					&& estacoes.get(estacaoVerificar).getEstacaoLigada().equals(estacoes.get(i).getEstacao1())){
				buscaEmProfundidade(estacoes, totalEstacao, i);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
			Integer E, L, C1 = 0, C2 =0, j = 1;
			Scanner sc = new Scanner(System.in);
			List<Estacao> listaEstacoes = new ArrayList<Estacao>();
			do {
				
				E = sc.nextInt();
				L = sc.nextInt();
				if((E == 0) && (L == 0)) {
					return;
				}
				for(int i = 1; i <= L; i++){
						C1 = sc.nextInt();
						C2 = sc.nextInt();
						listaEstacoes.add(new Estacao(C1, "BRANCO", C2));
				}
				buscaEmProfundidade(listaEstacoes, L, 0);
				if(estacaoConectada(listaEstacoes, L)){
					System.out.println("Teste "+j);
					System.out.println("normal");
					System.out.println("");
				}else {
					System.out.println("Teste "+j);
					System.out.println("falha");
					System.out.println("");
				}
				listaEstacoes = new ArrayList<Estacao>();
				j++;
			}while(!E.equals(0) && !L.equals(0));
			sc.close();
			System.exit(0);
	}
	
	
}
