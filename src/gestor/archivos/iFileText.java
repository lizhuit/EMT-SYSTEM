package gestor.archivos;

public interface iFileText {
        public void AbrirModoLectura(); // Método para abrir el modo lectura
        public String Leer(); // Método para leer
        public void AbrirModoEscritura(); // Método para abrir el modo escritura
        public void Escribir(String p); // Método para escribir
        public void Cerrar(); // Método para cerrar
}
