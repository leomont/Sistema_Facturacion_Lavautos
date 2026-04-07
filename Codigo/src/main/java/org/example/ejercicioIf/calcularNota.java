import java.util.*;

class calcularNota {
    public static void main(String[] args) {

        //Leer nota 1
        System.out.println("Ingrese Nota 1");
        Scanner leerDato1Consola = new Scanner(System.in);
        int nota1 = leerDato1Consola.nextInt();

        //Leer nota 2
        System.out.println("Ingrese Nota 2");
        Scanner leerDato2Consola = new Scanner(System.in);
        int nota2 = leerDato2Consola.nextInt();

        //sumar notas
        int notaCohorte = nota1 + nota2;
        //Calcular resultado
        if (notaCohorte >= 7) {
            System.out.println("Aprueba");
        } else if (notaCohorte >= 5 && notaCohorte < 7) {
            System.out.println("Recuperación");
        } else {
            System.out.println("Reprueba");
        }
    }
}