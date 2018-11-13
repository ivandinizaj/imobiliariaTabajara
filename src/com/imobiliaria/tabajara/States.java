package com.imobiliaria.tabajara;

public enum States {
	
	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amapá"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PQ("PE", "Pernambuco"),
	PT("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
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