package entidades;



	import java.util.Scanner;

	public class Tiempo implements Comparable<Tiempo>{
		
		private int horas;
		private int minutos;
		private int segundos;
		private int centesimasSegundo;
		
		
		public Tiempo() {}


		public Tiempo(int horas, int minutos, int segundos, int centesimasSegundo) {
			this.horas = horas;
			this.minutos = minutos;
			this.segundos = segundos;
			this.centesimasSegundo = centesimasSegundo;
		}


		public int getHoras() {
			return horas;
		}


		public void setHoras(int horas) {
			this.horas = horas;
		}


		public int getMinutos() {
			return minutos;
		}


		public void setMinutos(int minutos) {
			this.minutos = minutos;
		}


		public int getSegundos() {
			return segundos;
		}


		public void setSegundos(int segundos) {
			this.segundos = segundos;
		}


		public int getCentesimasSegundo() {
			return centesimasSegundo;
		}


		public void setCentesimasSegundo(int centesimasSegundo) {
			this.centesimasSegundo = centesimasSegundo;
		}


		@Override
		public String toString() {
			return "<" + horas + ">:<" + minutos + ">:" + segundos + ">,<"+ centesimasSegundo + ">";
		}
		
		public static Tiempo nuevoTiempo() {
			Tiempo tiempo = null;
			Scanner sc = new Scanner(System.in);
			boolean valido = false;
			String horas,minutos,segundos,centesimas;
		do {	
			System.out.println("Entre la cantidad de horas");
			horas = sc.next();
			if(horas.equals("")) horas = "0";
			System.out.println("Entre la cantidad de minutos");
			minutos = sc.next();
			if(minutos.equals("")) minutos = "0";
			System.out.println("Entre la cantidad de segundos");
			segundos = sc.next();
			if(segundos.equals("")) segundos = "0";
			System.out.println("Entre la cantidad de centesimas de segundo");
			centesimas = sc.next();
			if(centesimas.equals("")) centesimas = "0";
			
			if(Integer.parseInt(horas) + Integer.parseInt(minutos) + Integer.parseInt(segundos) + Integer.parseInt(centesimas) > 0) valido = true;
		}
		while(!valido);
			tiempo = new Tiempo(Integer.parseInt(horas), Integer.parseInt(minutos), Integer.parseInt(segundos), Integer.parseInt(centesimas));
			return tiempo;
		}


		


		@Override
		public int compareTo(Tiempo o) {
			// TODO Auto-generated method stub
			int resultado;
			resultado = this.getHoras() - o.getHoras();
			if(resultado == 0) {
				resultado = this.getMinutos() - o.getMinutos();
				if (resultado == 0) {
					resultado = this.getSegundos() - o.getSegundos();
					if (resultado == 0) {
						resultado = this.getCentesimasSegundo() - o.getCentesimasSegundo();
					}
				}
			}
			return resultado;
		} 
		
		
	}


