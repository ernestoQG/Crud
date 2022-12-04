import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Participante> participants = new ArrayList();
        
        try {
        	participants = BD.CargarDatos();
        }
        catch(Exception ex) {
        	System.out.println("No hay datos");
        }

    	String op = "";
        while(true) {
        	try {
            	Opciones();
            	op = scan.next();
        		if(RevisarOption(op)==true) {
        		switch(op) {

    				case "1":
    					System.out.println("#################################################");
    					System.out.println("Por favor introduzca los datos del nuevo participante \nDe tal manera q sea");
    					System.out.println("Nombre");
    					System.out.println("Apellidos");
    					System.out.println("CI");
    					System.out.println("Edad");
    					String nombre = scan.next();
    					String apellido = scan.next();
    					String CI = scan.next();
    					String edadtemp = scan.next();
    		        	int edad = Integer.valueOf(edadtemp);
    		        	
    		        	participants.add(new Participante(nombre,apellido,CI,edad));
    		        break;
    		        
        			case "2":
        				System.out.println("#################################################");
        				System.out.println("Por favor introduzca el numero del participante que quiere quitar");
        				MostrarListado(participants);
        				String posquitetemp = scan.next();
        				int posquite = Integer.valueOf(posquitetemp);
        				participants.remove(posquite-1);
        			break;
        			
        			case "3":
        				MostrarListado(participants);
        			break;

        			case "4":
        				BD.GuardarDatos(participants);
        				System.out.println("#################################################");
        				System.out.println("La base datos se a guardado");
        			break;

        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Ha introducido un valor incorrecto");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	//Opciones a mostrar
	public static void Opciones() {
		System.out.println("#################################################");
		System.out.println("Por favor escriba el numero de la opcion deseada:");
		System.out.println("1-Inscribir nuevo participante.");
		System.out.println("2-Eliminar un participante.");
		System.out.println("3-Mostrar listado.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar aplicacion.");
	}


	public static void MostrarListado(ArrayList<Participante> participants) {
		System.out.println("#################################################");
		System.out.println("Listado de participante al evento");
        for(int i =0;i<participants.size();i++) {
        	System.out.println((i+1)+"-"+participants.get(i).nombre+" "+participants.get(i).apellido+
        			" "+participants.get(i).CI+" "+participants.get(i).edad);
        }
	}

	public static boolean RevisarOption(String k) {
		if(Integer.valueOf(k)>=1&&Integer.valueOf(k)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("Esa opcion no se encuentra");
		}
	}
}
