/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author CATATO
 * Clase con la tabla de dispersión. En esta tabla se guardarán nodos Hash con el tiempo, la información del usuario y la información del documento.
 */
public class HashTable {
    HashNode tabla[]; //Cada posición del arreglo es un nodoHash
    int tableSize; //10111 (número primo para evitar colisiones) [capaz es exagerado]

    public HashTable(int size) { //Le paso el 10111
        this.tableSize = size; 
        this.tabla = new HashNode[tableSize];
        for (int i = 0; i < tableSize; i++) {
            this.tabla[i] = null; //Al principio indico que cada posición del arreglo es null porque todavía no están llenas.       
        }
    }
     
    /**
     * Función que retorna la llave que será utilizada para ubicar el nodo Hash en la tabla de dispersión
     * @param nombreUsuario
     * @return Retorna la llave que será utilizada para ubicar el nodo Hash en la tabla de dispersión
     */
    public int hashing(String nombreUsuario){ //Revisar cómo hacer que la función sea más exacta.
        int llave = Math.abs(nombreUsuario.hashCode());
        System.out.println(nombreUsuario.hashCode());
    return (llave % tableSize);   
    }
    
    
    /**
     * Método que inserta un nodo Hash en la tabla de dispersión. Estos nodos Hash tienen tres (3) parámetros:
     * @author Carlos, Ignacio
     * @param tiempo //Tiempo en el cuál el documento fue mandado a imprimir tomando en cuenta hora actual, prioridad usuario y prioridad documento.
     * @param informacionUsuario //Nodo con la información del usuario.
     * @param informacionDocumento //Nodo con la información del documento.
     * 
     */
    public void insertar(float tiempo, UserNode informacionUsuario, FileNode informacionDocumento){
        int posicion = hashing(informacionUsuario.getName().toLowerCase()); //Busca una posición que debería ser única
        boolean existe = false;
        if (this.tabla[posicion] != null) {
            HashNode temp = this.tabla[posicion];
            if (temp.getTime() != tiempo) {
                existe = false; //Ver si no puedo tener el mismo dos veces

            } 
            while (temp.getNext() != null){
                temp = temp.getNext();
//                if (temp.getTime() == tiempo) {
//                    existe = false; //Poner en true
//                    HashNode nuevo = new HashNode(informacionUsuario, tiempo, informacionDocumento);
//                    temp.setNext(nuevo); //Lo agrega como siguiente en la lista de uno que colisionó
//                    nuevo.setPrev(temp);
//                }
            }
            if (!existe) {
                HashNode nuevo = new HashNode(informacionUsuario, tiempo, informacionDocumento);
                temp.setNext(nuevo); //Lo agrega como siguiente en la lista de uno que colisionó
                nuevo.setPrev(temp);
            }
      
                
            
        } else {
            HashNode nuevo = new HashNode(informacionUsuario, tiempo, informacionDocumento);
            this.tabla[posicion] = nuevo; //Lo agrega en la posición
        }
    }
    
    /**
     * Busca el nodo Hash dentro de la tabla de dispersión
     * @param nombreUsuario
     * @param time //Tiempo en el que el documento se mandó a imprimir
     * @return HashNode 
     */
    public HashNode buscar(String nombreUsuario, String nombreDocumento){
        int posicion = hashing(nombreUsuario.toLowerCase());
        HashNode aux = this.tabla[posicion];
        boolean existe = false;
        if (aux != null) {
            if (aux.getInformacionDocumento().getTitle().equalsIgnoreCase(nombreDocumento)) {
                existe = true;
            }
            while(aux.getNext() != null && !existe){
                if (aux.getInformacionDocumento().getTitle().equalsIgnoreCase(nombreDocumento)) {
                    existe = true;
                } else {
                    aux = aux.getNext();
                }
            }
        }
        if (existe) {
            return aux;
            
        } else {
            return null;
        }
    }
    
    /**
     *Elimina un elemento de la Tabla de Dispersión tomando en cuenta el nombre de usuario y el nombre del documento.
     * @param nombreUsuario
     * @param nombreDocumento
     */
    public void Eliminar(String nombreUsuario, String nombreDocumento){ //Si se manda a imprimir
        int posicion = hashing(nombreUsuario);
        HashNode nodoClave = this.tabla[posicion];
        boolean existe = false;
        if (nodoClave != null) {
            if (nodoClave.getNext() == null) {
                if (nodoClave.getInformacionDocumento().getTitle().equalsIgnoreCase(nombreDocumento)) {
                    this.tabla[posicion] = null;
                    } else {
                    JOptionPane.showMessageDialog(null, "El documento buscado no fue encontrado.");
                }
            } else {
                while(nodoClave.getNext() != null && !existe){
                    if (nodoClave.getInformacionDocumento().getTitle().equalsIgnoreCase(nombreDocumento)) { //Se utiliza el tiempo para encontrar el nodo que se mandó a imprimir y se va a eliminar.
                        nodoClave.getPrev().setNext(nodoClave.getNext());
                        nodoClave.getNext().setPrev(nodoClave.getPrev());
                        existe = true; //Aquí hay que decirle al nodo anterior que su siguiente es el siguiente del siguiente.
                    } else {
                        nodoClave = nodoClave.getNext();
                    }
                }
            }   
        } else {
            JOptionPane.showMessageDialog(null, "El dato buscado no existe.");
        }
    }
    
    /**
     * Elimina el primer archivo en cola
     * @param min //Documento a eliminar
     */
    public void EliminarPrimero(BinaryHeapNode min){ 
        boolean existe = false;
        for (int i = 0; i < this.tableSize; i++) {
            if (this.tabla[i] != null) {
                if (this.tabla[i].getNext() == null) {
                    if (this.tabla[i].getTime() == (min.getTime())) {
                        this.tabla[i] = null;
                    } 
                } else {
                    HashNode aux = this.tabla[i];
                    while(!existe){
                        if (aux.getTime()== (min.getTime())) {
                            if (aux.getPrev() == null) {
                                this.tabla[i] = aux.getNext();
                                existe = true;
                            } else if (aux.getNext() == null) {
                                aux.getPrev().setNext(null);
                                existe = true;
                            } else  {
                                aux.getPrev().setNext(aux.getNext());
                                aux.getNext().setPrev(aux.getPrev());
                                existe = true;
                            }
                        } else {
                            if (aux.getNext() != null);
                                aux = aux.getNext();
                        }   
                        
                    }
                }
                
            }
        }
    }
    
    /**
     * Método que concatena una variable String donde muestra todos los elementos en la Tabla de Dispersión
     */
    public void imprimir(){
        String colaImpresion = "";
        for (int i = 0; i < tableSize; i++) {
            if (this.tabla[i] != null) {
                colaImpresion += this.tabla[i].getInformacionUsuario().getName() + ": " + this.tabla[i].getInformacionUsuario().getPriorityString() +"\n"+"- "+this.tabla[i].getInformacionDocumento().getTitle() +", " + this.tabla[i].getTime() +"\n";
                if (this.tabla[i].getNext() != null) {
                    HashNode aux = this.tabla[i].getNext();
                    while (aux != null){
                        colaImpresion += "- "+aux.getInformacionDocumento().getTitle() +", " + aux.getTime() +"\n";
                        aux = aux.getNext();
                    }
                    colaImpresion += "\n";
                }
            }
        }
        JOptionPane.showMessageDialog(null, colaImpresion);
    }
    
    
    
    
}
