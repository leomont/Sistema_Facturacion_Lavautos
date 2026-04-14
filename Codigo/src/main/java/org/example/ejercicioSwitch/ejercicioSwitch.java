import java.util.Scanner;

class ejercicioSwitch {
    public static void main(String[] args) {
        //1. Leer el valor de un mes (cualquiera por consola)
        Scanner leerDatoConsola = new Scanner(System.in);

        //2. Utilizar una variable para indicar el numero del mes ingresado
        System.out.println("Ingrese el numero del mes");
        int mes = leerDatoConsola.nextInt();

        //3. Validar que el numero del mes sea correcto (entre 1 y 12)
        if (mes < 1 || mes > 12)
            System.out.println("Mes no valido");


        //4. Hallar los meses que tienen 31 dias, 30 dias y 28 dias utilizando switch
        switch ( mes ) {
            case 1:
                System.out.println("El mes tiene 31 dias y se llama Enero");
                break;
            case 3:
                System.out.println("El mes tiene 31 dias y se llama Marzo");
                break;

            case 5, 7, 8, 10, 12:
                System.out.println("El mes tiene 31 dias");
                break;
            case 4, 6, 9, 11:
                System.out.println("El mes tiene 30 dias");
                break;
            case 2:
                System.out.println("El mes tiene 28 dias");
                break;
            default:
                System.out.println("Mes no valido");
        }







    }
}