package Cadastros;

public class CalculoDuracaoMinutos {
	private final Viagem viagem;
	private int duracaoMinutos;
	
	public CalculoDuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int getDuracaoMinutos() {
		calculoDuracaoMinutos();
		return duracaoMinutos;
	}

	private void calculoDuracaoMinutos() {
		if (minutoFinalMaiorInicial()) 
			duracaoMinutos = minutosFinalMenosInicial();
		else {
			duracaoMinutos = 60 + minutosFinalMenosInicial();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
	}

	private int minutosFinalMenosInicial() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}

	private boolean minutoFinalMaiorInicial() {
		return viagem.getMinutosTermino() > viagem.getMinutoInicio();
	}
	
}
