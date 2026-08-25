/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemagestionestudiantes.main.sistemagestionestudiantes;

/**
 *
 * @author Parallax
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int opcion;

        do {
            String opcionStr = JOptionPane.showInputDialog(
                "--- Sistema de Gestion de Estudiantes ---\n" +
                "1. Agregar estudiante\n" +
                "2. Listar estudiantes\n" +
                "3. Buscar estudiante por ID\n" +
                "4. Eliminar estudiante\n" +
                "5. Salir\n\n" +
                "Ingrese una opcion:"
            );

            if (opcionStr == null) break; // si cancela, se sale del programa

            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    String idStr = JOptionPane.showInputDialog("Ingrese el ID:");
                    int id = Integer.parseInt(idStr);

                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");

                    String promStr = JOptionPane.showInputDialog("Ingrese el promedio:");
                    double promedio = Double.parseDouble(promStr);

                    estudiantes.add(new Estudiante(id, nombre, promedio));
                    JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente.");
                    break;

                case 2:
                    if (estudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                    } else {
                        StringBuilder lista = new StringBuilder();
                        for (Estudiante e : estudiantes) {
                            lista.append(e.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;

                case 3:
                    String buscarIdStr = JOptionPane.showInputDialog("Ingrese el ID a buscar:");
                    int buscarId = Integer.parseInt(buscarIdStr);
                    boolean encontrado = false;

                    for (Estudiante e : estudiantes) {
                        if (e.getId() == buscarId) {
                            JOptionPane.showMessageDialog(null, "Encontrado:\n" + e.toString());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    String eliminarIdStr = JOptionPane.showInputDialog("Ingrese el ID a eliminar:");
                    int eliminarId = Integer.parseInt(eliminarIdStr);
                    boolean eliminado = estudiantes.removeIf(e -> e.getId() == eliminarId);

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro un estudiante con ese ID.");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }

        } while (opcion != 5);
    }
}