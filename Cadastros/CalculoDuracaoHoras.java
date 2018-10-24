package Cadastros;

public class CalculoDuracaoHoras {
	private final Viagem viagem;
	private int duracaoHoras;
	
	public CalculoDuracaoHoras(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int getDuracaoHoras() {
		viagemInexistente();
		if (horaFinalMaiorInicial()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (minutoFinalMenorInicial())  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaFinalMenosInicial() > 2) //
					duracaoHoras = horaFinalMenosInicial();
				else if (horaFinalMenosInicial() == 2 &&   //certamente menos de duas horas  
						 minutoFinalMenorInicial())    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;					
			}
		horarioTerminoNaoRegistrado();
		return duracaoHoras;
	}

	private int horaFinalMenosInicial() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}

	private boolean minutoFinalMenorInicial() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	private boolean horaFinalMaiorInicial() {
		return viagem.getHoraTermino() > viagem.getHoraInicio();
	}

	private void horarioTerminoNaoRegistrado() {
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			duracaoHoras = -1; 
	}

	private void viagemInexistente() {
		if (horaFinalIgualInicial())
			duracaoHoras = 0;
	}

	private boolean horaFinalIgualInicial() {
		return viagem.getHoraTermino() == viagem.getHoraInicio();
	}

}
