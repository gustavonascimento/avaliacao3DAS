package Cadastros;

public class CalculoDuracaoMinutos {
	private final Viagem viagem;
	private int duracaoMinutos;
	
	public CalculoDuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int getDuracaoMinutos() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
	
}
