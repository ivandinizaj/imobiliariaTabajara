package com.imobiliaria.tabajara;

public enum States {
	
	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amap�"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Cear�"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Esp�rito Santo"),
	GO("GO", "Goi�s"),
	MA("MA", "Maranh�o"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Par�"),
	PB("PB", "Para�ba"),
	PR("PR", "Paran�"),
	PQ("PE", "Pernambuco"),
	PT("PI", "Piau�"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rond�nia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "S�o Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");

	private final String uf, name;

	States(String uf, String name) {
		this.uf = uf;
		this.name = name;
	}


	public static String[] search(String s){

		for(States value : States.values() ){
			if(value.getUF().equalsIgnoreCase(s) || value.getName().equalsIgnoreCase(s) ){
				return new String[] {value.getUF(), value.getName() };
			}
		}

		return null;
	}

	public String getUF() {
		return uf;
	}
	
	public String getName(){
		return name;
	}
	
}