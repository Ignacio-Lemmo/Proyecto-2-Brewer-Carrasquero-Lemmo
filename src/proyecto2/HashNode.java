/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Ignacio y Carlos
 */
public class HashNode {
    private HashNode next; //Cada posición del arreglo es una lista. Por eso necesito el next.
    private HashNode prev; //Cada posición del arreglo es una lista. Por eso necesito el next.
    private UserNode informacionUsuario; // la información de cada usuario que ha enviado un documento a la cola de impresión
    private float time; // el lugar que ocupa el documento en la cola (etiqueta de tiempo)
    private FileNode informacionDocumento; //información propia del documento

    public HashNode(UserNode informacionUsuario, float time, FileNode informacionDocumento) {
        this.next = null;
        this.prev = null;
        this.informacionUsuario = informacionUsuario;
        this.time = time;
        this.informacionDocumento = informacionDocumento;
    }

    public HashNode getPrev() {
        return prev;
    }

    public void setPrev(HashNode prev) {
        this.prev = prev;
    }

    public UserNode getInformacionUsuario() {
        return informacionUsuario;
    }

    public FileNode getInformacionDocumento() {
        return informacionDocumento;
    }

    public void setInformacionUsuario(UserNode informacionUsuario) {
        this.informacionUsuario = informacionUsuario;
    }

    public void setInformacionDocumento(FileNode informacionDocumento) {
        this.informacionDocumento = informacionDocumento;
    }



    public HashNode getNext() {
        return next;
    }


    public float getTime() {
        return time;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }



    public void setTime(float time) {
        this.time = time;
    }
    
    
}
