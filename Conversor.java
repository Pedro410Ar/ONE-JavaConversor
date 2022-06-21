import javax.swing.JOptionPane;

public class Conversor {
public static void main(String[] args) {
	Mensajes mensajes = new Mensajes();
		
	Object valorConvertir;
	int opcion;
	float cantidadFloat;
		
// Menu de tipo de conversion: moneda, temperatura o genero
	Object conversionElegida = JOptionPane.showInputDialog (
		   null,
		   "Tipo de conversión",
		   "Menú",
		   JOptionPane.QUESTION_MESSAGE,
		   null, 
		   new Object[] { "Moneda", "Temperatura","Genero" }, 
		   "Moneda" 
		   );

                    //System.out.println("El usuario ha elegido "+conversionElegida);
		
                            if (conversionElegida == null) {
			mensajes.mensajeTerminado();
		}
		
                            String conversionString = conversionElegida.toString();
				
		
                            // Seleccion con Menu de Genero 
                            if (conversionString == "Genero"){
                                               mensajes.mensajeGenero();
                                           // System.out.println("Programa Terminado");
		   mensajes.mensajeTerminado();
                                       } 
                                       
                                       
                             // Seleccion con Menu de Moneda 
                            if (conversionString == "Moneda") {
                                            valorConvertir = JOptionPane.showInputDialog(
                                                null,
                                                "Elige la moneda a la que deseas convertir tu dinero",
                                               "Monedas",
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,  
                                                new Object[ ] { "De Pesos (Arg) a Dolar(US)", 
                                                                         "De Pesos(Arg) a Euro(UE)", 
                                                                         "De Dolar(US) a Pesos(Arg)",
                                                                         "De Euros(UE) a Pesos(Arg)",  }, 
                                                "De Pesos(Arg) a Dolar(US)"
                                                    );
			
                                            opcion = 1;

			//System.out.println("El usuario ha elegido "+valorConvertir);
					
		} else {
			valorConvertir = JOptionPane.showInputDialog(
					   null,
					   "Elige la moneda a la que deseas convertir tu dinero",
					   "Monedas",
					   JOptionPane.QUESTION_MESSAGE,
					   null,  
					   new Object[] { "De Celsius(°C) a Fahrenheit(°F)", 
                                                                                                                          "De Fahrenheit(°F) a Celsius(°C)", }, 
					   "De Celsius(°C) a Fahrenheit(°F)"
			);
			opcion = 2;
			System.out.println("El usuario ha elegido "+valorConvertir);	
		}
		
		if (valorConvertir == null) {			
			mensajes.mensajeTerminado();
		}
		
		String valorString = valorConvertir.toString();
			
		
                        // Menu que pregunta cantidad de dinero a convertir
		if (opcion == 1) {
		String cantidadDinero = JOptionPane.showInputDialog(
                                                null,
                                              "Ingrese la cantidad de dinero que quiere convertir",
                                               JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
		
                                       if (cantidadDinero == null) {
                                                mensajes.mensajeTerminado();
			}
		                    cantidadFloat = Float.valueOf(cantidadDinero);
		} 
                                            else {
			String cantidadDinero = JOptionPane.showInputDialog(
			   null,
                                                           "Ingrese los grados",
			   JOptionPane.QUESTION_MESSAGE);  
			
                                        if (cantidadDinero == null) {
				mensajes.mensajeTerminado();
			}
			cantidadFloat = Float.valueOf(cantidadDinero);
		}	        
		
                                        //System.out.println("El usuario decea convertir "+cantidadFloat);
				
				
                    // Switch con las divisas convertibles
		String unidadOrigen;
		String unidadFinal;
                                      String unidadGenero;
		float unidad;
		float conversion;
		float dolar = 20.00f;
		float euro = 21.25f;
                                      float factorConversion = 1.8f;
				
		switch (valorString) {
		
                     // Casos de divisas
		case "De Pesos(Arg) a Dolar(US)":
			unidadOrigen = "Pesos";
			unidadFinal = "Dolares";
			mensajes.mensajeMoneda(cantidadFloat, unidadOrigen, unidadFinal, dolar);
			break;
			
		case "De Pesos(Arg) a Euro(UE)":
			unidadOrigen = "Pesos";
			unidadFinal = "Euros";
			mensajes.mensajeMoneda(cantidadFloat, unidadOrigen, unidadFinal, euro);
			break;
			
		case "De Dolar(US) a Pesos(Arg)":
			unidadOrigen = "Dolares";
			unidadFinal = "Pesos";
			mensajes.mensajeMoneda(cantidadFloat, unidadOrigen, unidadFinal, dolar);
			break;
			
		case "De Euros(UE) a Pesos(Arg)":
			unidadOrigen = "Euros";
			unidadFinal = "Pesos";
			mensajes.mensajeMoneda(cantidadFloat, unidadOrigen, unidadFinal, euro);
			break;
		
		// Casos para Temperatura
		case "De Celsius(°C) a Fahrenheit(°F)":
			unidadOrigen = "°C";
			unidadFinal = "°F";
			conversion = factorConversion * cantidadFloat + 32;
			// Ventana que muestra el resultado de la conversion
			mensajes.mensajeTemperatura(cantidadFloat, unidadOrigen, unidadFinal, conversion);
			break;
			
		case "De Fahrenheit(°F) a Celsius(°C)":
			unidadOrigen = "°F";
			unidadFinal = "°C";
			conversion = (cantidadFloat-32)/factorConversion;
			mensajes.mensajeTemperatura(cantidadFloat, unidadOrigen, unidadFinal, conversion);
			break;
                        
                            // Casos de conversion genero
                                       case "De Hombre a Mujer":
			unidadOrigen = "Hombre";
			unidadFinal = "Mujer";
			
			mensajes.mensajeGenero();
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "No has introducido una opción válida");
			break;
		}
		
		
		// Ventana de confirmacion de continuar con la aplicacion o cerrarla.
		int confirmado = JOptionPane.showConfirmDialog(
				   null,
				   "¿Deseas continuar?");

		if (JOptionPane.OK_OPTION == confirmado) {
			System.out.println("Continuamos");
			Conversor.main(args);
		}else {
		   System.out.println("Programa Terminado");
		   mensajes.mensajeTerminado();
		}
	}
}