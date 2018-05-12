package soldado;

public interface Estado {
	public void recibirDisparo(Soldado s);
	public void recibirCuracion(Soldado s);
	public String toString();
}
