package br.com.agendalize.entity;

public enum eSemana {
	
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sábado"),
	DOMINGO("Domingo");
 
	public final String valor;
    eSemana(String valorOpcao){
        valor = valorOpcao;
    }
    public String getValor(){
        return valor;
    }

}
