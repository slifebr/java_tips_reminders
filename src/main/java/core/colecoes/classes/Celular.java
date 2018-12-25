package core.colecoes.classes;

public class Celular  implements Comparable<Celular> {
	//
	private String nome;
	private String IMEI;

	public Celular(String nome, String iMEI) {
		super();
		this.nome = nome;
		IMEI = iMEI;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	// =================================================================================================
	// regras para gerar o equals
	// =================================================================================================
	// (1) Reflexivo: x.equal(x) tem que ser true para tudo que for diferente de
	// null.
	// (2) Simetrico: x e y diferentes de null, se x.equals(y) == true logo
	// y.equals(x) tem que ser true.
	// (3) Transiente: x, y, z diferentes de null, se x.equals(y) == true, logo
	// y.equals(x) == true logo y.equals(z) tem que ser true.
	// (4) Consistente: x.equals(y) deve sempre retornar o mesmo valor
	// para x diferente de null x.equals(null) tem que retornar false.
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		Celular outroCelular = (Celular) obj;
		return IMEI != null && IMEI.equals(outroCelular.getIMEI());
	}


	// =================================================================================================
	// regras para gerar o hashCode
	// =================================================================================================
	// se x.equals(y) == true entao x.hashCode() == y.hashCode().
	// se x.hashCode() == y.hashCode() nao necessariamente o equals devera ser true
	// se x.equals(y) == false entao nao e necessario o hashCode.
	// se x.hashCode() != y.hashCode() entao x.equals(y) devera ser falso.

	@Override
	public int hashCode() {
		return IMEI != null ? IMEI.hashCode() : 1;
		
		/* gerado pelo eclipse
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IMEI == null) ? 0 : IMEI.hashCode());
		return result;
		*/
			
	}

	@Override
	public String toString() {
		return "Celular [nome=" + nome + ", IMEI=" + IMEI + "]";
	}

	@Override
	public int compareTo(Celular o) {
		
		return this.IMEI.compareTo(o.getIMEI());
	}

}
