/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

/**
 * Clase que proporciona métodos estáticos para validar diferentes tipos de datos.
 * Incluye validaciones para cadenas de texto, números, correos electrónicos, 
 * números de teléfono, CURP y más.
 * 
 * @author MELODY NATHALIE MENDOZA JIMENEZ
 * @author JOSUE SAUL LOPEZ TRUJILLO
 * 
 */

public final class Validador {
    /**
     * Valida que una cadena de texto no sea nula ni vacía.
     * 
     * @param texto La cadena a validar
     * @return true si la cadena no es nula y contiene caracteres no whitespace,
     *         false en caso contrario
     */

    // Validar que no sea nulo ni vacío
    public final static boolean noEsNuloNiVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
        }
     /**
     * Valida que un número entero sea positivo (mayor que cero).
     * 
     * @param numero El número a validar
     * @return true si el número es positivo, false en caso contrario
     */

    // Validar que un número sea positivo
    public final static boolean esPositivo(int numero) {
        return numero > 0;
        }
    /**
     * Valida que una cadena tenga el formato básico de un correo electrónico.
     * El formato debe ser: caracteres@caracteres.dominio (con 2 o más letras en el TLD)
     * 
     * @param correo La cadena con el correo a validar
     * @return true si el correo cumple con el formato básico, false en caso contrario
     */
    // Validar correo electrónico simple
    public final static boolean esCorreoValido(String correo) {
        return correo != null && correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");//(esto representa cual caracter alfanumerico)()
        }
     /**
     * Valida que una cadena tenga una longitud mínima especificada.
     * 
     * @param texto La cadena a validar
     * @param longitud La longitud mínima requerida
     * @return true si la cadena no es nula y su longitud es mayor o igual al parámetro,
     *         false en caso contrario
     */

    // Validar longitud mínima
    public final static boolean longitudMinima(String texto, int longitud) {
        return texto != null && texto.length() >= longitud;
        }
     /**
     * Valida que una cadena sea un número de teléfono válido de 10 dígitos.
     * 
     * @param telefono La cadena con el número de teléfono a validar
     * @return true si la cadena contiene exactamente 10 dígitos, false en caso contrario
     */

    // Valida un número de teléfono de 10 dígitos
    public final  static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{10}");
        }
     /**
     * Valida que una cadena tenga el formato de una CURP mexicana válida.
     * El formato debe coincidir con el estándar oficial mexicano.
     * 
     * @param curp La cadena con la CURP a validar
     * @return true si la cadena cumple con el formato de CURP, false en caso contrario
     */

    // Valida una CURP (formato mexicano)
    public final static boolean esCurpValida(String curp) {
        return curp != null && curp.matches("^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]\\d$");
        }
      /**
     * Valida que una cadena contenga únicamente letras (incluyendo acentos y ñ).
     * También permite espacios.
     * 
     * @param texto La cadena a validar
     * @return true si la cadena contiene solo letras y espacios, false en caso contrario
     */
    // Valida que solo tenga letra
    public final static boolean soloLetras(String texto) {
        return texto != null && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

}



    

