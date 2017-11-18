import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarzan {

	static class Cipo{
		private Integer cipo1;
		private Integer cipo2;
		private String cor;
		
		public Cipo(Integer cipo1, Integer cipo2, String cor) {
			super();
			this.cipo1 = cipo1;
			this.cipo2 = cipo2;
			this.cor = cor;
		}
		public Integer getCipo1() {
			return cipo1;
		}
		public void setCipo1(Integer cipo1) {
			this.cipo1 = cipo1;
		}
		public Integer getCipo2() {
			return cipo2;
		}
		public void setCipo2(Integer cipo2) {
			this.cipo2 = cipo2;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
			
	}
	
	
	private static Boolean verificaQuantidadeN(Integer N) {
		if(N >= 2 && N <= 1000) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private static Boolean verificaD(Integer D) {
		if(D >= 1 && D <= 5000) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private static Boolean verificaCoordenadas(Integer D) {
		if(D >= 0 && D <= 5000) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public static void buscaEmProfundidade(List<Cipo> listaCipo, Integer totalCipo, Integer cipoVerificar, Integer distancia) {
		listaCipo.get(cipoVerificar).setCor("CINZA");
		for(int i = 0; i < totalCipo; i++) {
			if(verificaDistancia(distancia, listaCipo.get(i), listaCipo.get(cipoVerificar))
					&& listaCipo.get(i).getCor().equals("BRANCO")){
				buscaEmProfundidade(listaCipo, totalCipo, i, distancia);
			}
			
		}
		listaCipo.get(cipoVerificar).setCor("PRETO");
	}
	
	private static Boolean verificaDistancia(Integer distancia, Cipo cipo2, Cipo cipo) {
		Integer distanciaCipo1 = cipo.getCipo1()-cipo2.getCipo1();
		Integer distanciaCipo2 = cipo.getCipo2()-cipo2.getCipo2();
		Double valor = Math.pow(distanciaCipo1,2) +Math.pow(distanciaCipo2,2);
		
		if(valor <= Math.pow(distancia,2)) {
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	public static void main(String[] args) {
		List<Cipo> listaCipos = new ArrayList<Cipo>();
		Integer N, D, X = 0, Y = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = sc.nextInt();
		if(verificaQuantidadeN(N) &&  verificaD(D))  {
			for(int i = 0; i < N; i++) {
				X = sc.nextInt();
				Y = sc.nextInt();
				if(verificaCoordenadas(X) && verificaCoordenadas(Y)) {
					Cipo cipo = new Cipo(X, Y, "BRANCO");
					if(!listaCipos.contains(cipo)) {
						listaCipos.add(cipo);
					}	
				}
			}
		}
		sc.close();
		buscaEmProfundidade(listaCipos, listaCipos.size(), 0, D);
		if(cipoConectada(listaCipos)){
			System.out.println("S");
		}else {
			System.out.println("N");
		}	
	}
	
	private static Boolean cipoConectada(List<Cipo> listaCipos){
		for (int i = 0; i < listaCipos.size(); i++) {
			if(listaCipos.get(i).getCor().equals("BRANCO")) {
				return false;
			}
		}
		return true;
	}
	
}
