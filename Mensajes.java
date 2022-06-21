import javax.swing.JOptionPane;

public class Mensajes  {
	
	String unidadOrigen;
	String unidadFinal;
	String unidad;
	float conversion;
	float dolar = 20.00f;
	float euro = 21.25f;
	
	float factorConversion = 1.8f;
	
                   //String mujer;
                   //String hombre; 
                   //String lgbti;
                   //String electrodomestico; 
                   
        
	public void mensajeTerminado() {
		JOptionPane.showMessageDialog(null, "Programa Terminado");
	}
	
	public void mensajeMoneda(float cantidadFloat, String unidadOrigen, String unidadFinal, float unidad ) {
		if (unidadOrigen == "Pesos") {
			conversion = cantidadFloat / unidad;
		}else {
			conversion = cantidadFloat * unidad;
		}
		JOptionPane.showMessageDialog(null, cantidadFloat + " " + unidadOrigen + " son " + conversion + " " + unidadFinal);
	}
	
	public void mensajeTemperatura(float cantidadFloat, String unidadOrigen, String unidadFinal, float conversion) {
		JOptionPane.showMessageDialog(null, cantidadFloat + " " + unidadOrigen + " son " + conversion + " " + unidadFinal);
	}
        
                    public void mensajeGenero(){
                        JOptionPane.showMessageDialog(null, "Una nueva Vida te espera. Felicitaciones!!");
                        
                    }
	
}