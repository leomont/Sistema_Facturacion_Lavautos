import java.util.Scanner;

class ejercicioWhile {
    //Calculo del numero de digitos de un numero ingresado por consola utilizando ciclos
    public static void main(String[] args) {
        //1. Leer el valor del numero ingresado por consola
        Scanner leerDatoConsola = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int numero = leerDatoConsola.nextInt();

        //2. Validar el numero de digitos del numero ingresado
        int numeroDigitos = String.valueOf(numero).length();
        System.out.println("El numero tiene " + numeroDigitos + " digitos");

        //3. Utilizar un ciclo para determinar cuando deseamos finalizar el programa
        while (true) {
            System.out.println("Desea Ingresar mas datos el programa? (s/n)");
            String respuesta = leerDatoConsola.next();
            if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("Programa finalizado");
                break;
            }
            else if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese un numero");
                numero = leerDatoConsola.nextInt();
                numeroDigitos = String.valueOf(numero).length();
                System.out.println("El numero tiene " + numeroDigitos + " digitos");
            }
            else {
                System.out.println("Respuesta no valida, por favor ingrese 's' o 'n'");
            }
        }

    }
}