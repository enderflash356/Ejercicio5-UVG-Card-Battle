public class JuegoController {
    private Mazo modelo;
    private JuegoView vista;

    public JuegoController(Mazo modelo, JuegoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarJuego() {
        boolean salir = false;
        vista.mostrarMensaje("¡Bienvenido a UVG Card Battle System!");

        while (!salir) {
            vista.mostrarEstado(modelo.getEnergiaJugador(), modelo.getTurnoActual());
            vista.mostrarMenu();
            int opcion = vista.pedirEntero("");

            switch (opcion) {
                case 1:
                    vista.mostrarCartas(modelo.getCartas());
                    break;
                case 2:
                    int idBuscar = vista.pedirEntero("Ingrese el ID de la carta a buscar: ");
                    Carta cartaPorId = modelo.buscarCarta(idBuscar);
                    if (cartaPorId != null) {
                        vista.mostrarMensaje("\n[Resultado Encontrado]: " + cartaPorId.toString());
                    } else {
                        vista.mostrarMensaje("\nNo se encontró ninguna carta con el ID: " + idBuscar);
                    }
                    break;
                case 3:
                    String nombreBuscar = vista.pedirTexto("Ingrese el nombre de la carta a buscar: ");
                    Carta cartaPorNombre = modelo.buscarCarta(nombreBuscar);
                    if (cartaPorNombre != null) {
                        vista.mostrarMensaje("\n[Resultado Encontrado]: " + cartaPorNombre.toString());
                    } else {
                        vista.mostrarMensaje("\nNo se encontró ninguna carta con el nombre: " + nombreBuscar);
                    }
                    break;
                case 4:
                    modelo.ordenarPorEnergia();
                    vista.mostrarMensaje("\n¡Mazo ordenado exitosamente por costo de energía!");
                    vista.mostrarCartas(modelo.getCartas());
                    break;
                case 5:
                    vista.mostrarCartas(modelo.getCartas());
                    int idJugar = vista.pedirEntero("\nIngrese el ID de la carta que desea jugar: ");
                    Carta cartaAJugar = modelo.buscarCarta(idJugar);
                    if (cartaAJugar == null) {
                        vista.mostrarMensaje("La carta especificada no existe en tu mazo.");
                    } else {
                        boolean exito = modelo.usarCarta(cartaAJugar);
                        if (exito) {
                            vista.mostrarMensaje("¡Carta jugada con éxito!");
                        } else {
                            vista.mostrarMensaje("No tienes suficiente energía para jugar esta carta (Costo: " 
                                + cartaAJugar.getCostoEnergia() + " E | Disponible: " + modelo.getEnergiaJugador() + " E).");
                        }
                    }
                    break;
                case 6:
                    modelo.pasarTurno();
                    vista.mostrarMensaje("\nHas pasado el turno. ¡Tu energía ha sido recargada para el Turno " + modelo.getTurnoActual() + "!");
                    break;
                case 7:
                    salir = true;
                    vista.mostrarMensaje("Gracias por jugar a UVG Card Battle. ¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Por favor, seleccione un número del 1 al 7.");
                    break;
            }
        }
    }
}  
