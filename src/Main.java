//PRGRAMA HECHO POR SAID MIGUEL MEZA LOPEZ 20251008 4A
// Y POR RAFAEL MÁRQUEZ HERNÁNDEZ 20251028 4A
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {

            System.out.println("\nSstema de las calificaciones en tiempo real");
            System.out.println("1. Agregar calificacion");
            System.out.println("2. Mostrar calificaciones");
            System.out.println("3. Consultar calificacion por posicion");
            System.out.println("4. Corregir calificacion");
            System.out.println("5. eliminar calificacion");
            System.out.println("6. Buscar calificacion");
            System.out.println("7. ver total de estudiantes");
            System.out.println("0. salir");

            System.out.print("Selecciona una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingresa la calificacion: ");
                    int nueva = teclado.nextInt();

                    lista.insertarOrdenado(nueva);

                    break;

                case 2:

                    lista.mostrar();

                    break;

                case 3:

                    if (lista.estaVacia()) {
                        System.out.println("No hay calificaciones.");
                        break;
                    }

                    System.out.println("1. Calificacion minima");
                    System.out.println("2. Calificacion maxima");
                    System.out.println("3. Calificacion mediana");

                    System.out.print("Selecciona una opcion: ");
                    int consulta = teclado.nextInt();

                    int posicion = 0;

                    if (consulta == 1) {
                        posicion = 1;
                    } else if (consulta == 2) {
                        posicion = lista.getTamanio();
                    } else if (consulta == 3) {

                        if (lista.getTamanio() % 2 == 0) {

                            System.out.println("Las dos calificaciones centrales son:");

                            System.out.println(lista.consultarPosicion(
                                    lista.getTamanio() / 2));

                            System.out.println(lista.consultarPosicion(
                                    lista.getTamanio() / 2 + 1));

                            break;

                        } else {
                            posicion = lista.getTamanio() / 2 + 1;
                        }

                    } else {
                        System.out.println("Opcion incorrecta.");
                        break;
                    }

                    System.out.println("Calificacion: "
                            + lista.consultarPosicion(posicion));

                    break;

                case 4:

                    System.out.print("Posicion que deseas corregir: ");
                    int posicionCorregir = teclado.nextInt();

                    System.out.print("Nueva calificacion: ");
                    int calificacionNueva = teclado.nextInt();

                    if (lista.corregir(posicionCorregir, calificacionNueva)) {
                        System.out.println("Calificacion corregida.");
                    } else {
                        System.out.println("No se pudo corregir.");
                    }

                    break;

                case 5:

                    System.out.print("Calificacion que deseas eliminar: ");
                    int eliminar = teclado.nextInt();

                    if (lista.eliminar(eliminar)) {
                        System.out.println("Calificacion eliminada.");
                    } else {
                        System.out.println("No se encontro la calificacion.");
                    }

                    break;

                case 6:

                    System.out.print("Calificacion que deseas buscar: ");
                    int buscar = teclado.nextInt();

                    if (lista.buscar(buscar)) {
                        System.out.println("La calificacion existe.");
                    } else {
                        System.out.println("La calificacion no existe.");
                    }

                    break;

                case 7:

                    System.out.println("Total de estudiantes: " + lista.getTamanio());

                    break;

                case 0:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
