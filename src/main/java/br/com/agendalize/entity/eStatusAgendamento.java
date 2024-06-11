package br.com.agendalize.entity;

public enum eStatusAgendamento {
	
	ANDAMENTO((long) 1),
	CONCLUIDO((long) 2),
	CANCELADO((long) 3);
 
	public final long valor;
    eStatusAgendamento(long valorOpcao){
        valor = valorOpcao;
    }
    public long getValor(){
        return valor;
    }

}
