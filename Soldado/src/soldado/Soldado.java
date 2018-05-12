package soldado;

public class Soldado {

	private Estado status;
	private int balazos;
	private int sangre;

	public Soldado() {
		this.status = new EstadoSaludable();
		this.balazos = 0;
		this.sangre = 5000;
	}

	public String recibioDisparo() {
		this.status = this.status.recibirDisparo();
		return "El soldado recibio un disparo";
	}

	public String recibioCuracion() {
		this.status = this.status.recibirCuracion();
		return "El soldado recibio una curacion";
	}

	public String toString() {
		return "Soldado [status = " + this.status + ", balazos = " + this.balazos + ", sangre = " + this.sangre + "]";
	}

	public class EstadoSaludable implements Estado {

		public Estado recibirDisparo() {
			System.out.println("Soldado:- AAAH");
			balazos++;
			sangre = Math.max(0, sangre - 100);
			return new EstadoHerido();
		}

		public Estado recibirCuracion() {
			System.out.println("Soldado:- Gracias, pero estoy saludable");
			return new EstadoSaludable();
		}

		public String toString() {
			return "Estoy Saludable";
		}
	}

	public class EstadoHerido implements Estado {

		public Estado recibirDisparo() {
			System.out.println("Soldado:- AAAAAAHHH");
			balazos++;
			sangre = 0;
			return new EstadoMuerto();
		}

		public Estado recibirCuracion() {
			System.out.println("Soldado:- Gracias");
			balazos--;
			return new EstadoSaludable();
		}

		public String toString() {
			return "Estoy Herido";
		}
	}

	public class EstadoMuerto implements Estado {

		public Estado recibirDisparo() {
			balazos++;
			return new EstadoMuerto();
		}

		public Estado recibirCuracion() {
			System.out.println("Soldado:- He revivido!");
			sangre = 5000;
			balazos = 0;
			return new EstadoSaludable();
		}

		public String toString() {
			return "Estoy Muerto";
		}
	}
}
