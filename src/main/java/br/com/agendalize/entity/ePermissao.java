package br.com.agendalize.entity;

public enum ePermissao {
	
	ADMIN((long) 3),
	EMPRESA((long) 4);
 
	public final long valor;
    ePermissao(long valorOpcao){
        valor = valorOpcao;
    }
    public long getValor(){
        return valor;
    }
}
