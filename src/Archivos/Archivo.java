 package Archivos;

import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
	
	private FileWriter  nivel1;
	private FileWriter  nivel2;

	public Archivo() {//
		try {
			nivel1 = new FileWriter("NIVEL1");
			nivel1.write("+++++++++++++++++++++++++++");
			nivel1.append("+*----*-------*-------*---+");
			nivel1.append("+*+-+-+*+-+-+-+-+-+-+-+-+-+");
			nivel1.append("+*-*---*----------*-----*-+");
			nivel1.append("+*+*+-+*+-+-+-+-+-+-+-+-+-+");
			nivel1.append("+--------*******--------*-+");
			nivel1.append("+*+*+-+-+-+-+*+*+-+-+-+-+-+");
			nivel1.append("+***----------**----------+");
			nivel1.append("+-+-+-+-+-+-+*+-+-+-+-+-+-+");
			nivel1.append("+--***-------**------**---+");
			nivel1.append("+-+-+-+-+-+-+-+*+-+-+-+-+-+");
			nivel1.append("+------------***----------+");
			nivel1.append("+-+-+-+-+-+-+*+-+-+-+-+-+-+");
			nivel1.append("+------------******-------+");
			nivel1.append("+++++++++++++++++++++++++++");
			nivel1.close();
			
			/*nivel1 = new FileWriter("NIVEL1");//5x6
			nivel1.write("++++++");
			nivel1.append("+----+");
			nivel1.append("+----+");
			nivel1.append("+*---+");
			nivel1.append("++++++");
			nivel1.close();*/
			
			
			nivel2 = new FileWriter("NIVEL2");
			nivel2.write("+++++++++++++++++++++++++++");
			nivel2.append("+--*--*--***-****------*--+");
			nivel2.append("+-+-+-+*+*+*+-+-+-+*+*+-+-+");
			nivel2.append("+--*--*---*---******---**-+");
			nivel2.append("+*+*+-+-+-+-+-+-+-+*+-+-+-+");
			nivel2.append("+*---*---**--***---*--****+");
			nivel2.append("+*+*+-+-+-+*+*+*+-+-+*+-+-+");
			nivel2.append("+***----*--*--**-----**---+");
			nivel2.append("+*+-+-+-+-+*+*+-+-+-+-+-+-+");
			nivel2.append("+--*---*****-**-----****--+");
			nivel2.append("+-+*+*+-+-+-+-+*+-+-+-+-+-+");
			nivel2.append("+-**-----*---***------*---+");
			nivel2.append("+-+-+-+-+*+-+*+-+-+-+-+-+-+");
			nivel2.append("+*--*----*---******---*--*+");
			nivel2.append("+++++++++++++++++++++++++++");
			nivel2.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getNombreNivel(int nivel) {
		String toReturn;
		if(nivel==1) 
			toReturn="NIVEL1";//"NIVEL1"
		else 
			toReturn ="NIVEL2";
		return toReturn;
	}
	
	
}
