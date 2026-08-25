/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemagestionestudiantes.main.sistemagestionestudiantes;

/**
 *
 * @author Parallax
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestion de Estudiantes ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Promedio: ");
                    double prom = Double.parseDouble(sc.nextLine());
                    estudiantes.add(new Estudiante(id, nombre, prom));
                    break;
                case 2:
                    for (Estudiante e : estudiantes) System.out.println(e);
                    break;
            }
        } while (opcion != 3);
    }
}