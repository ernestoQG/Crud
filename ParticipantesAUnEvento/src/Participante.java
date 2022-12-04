
public class Participante {
    protected String nombre;
    protected String apellido;
    protected String CI;
    protected int edad;
    
    
    public Participante(){
    	nombre="";
        apellido="";
        CI="";
        edad=0;
    }
    public Participante(String name,String lastname,String CI,int edad){
        this.nombre = name;
        this.apellido = lastname;
        this.CI = CI;
        this.edad = edad;
    }
    
}
