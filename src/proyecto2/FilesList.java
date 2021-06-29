package proyecto2;

import javax.swing.JOptionPane;

/**
 * @author Ignacio
 */
public class FilesList {
    
    //Atributos:
    private FileNode first;
    private FileNode last;
    private int size;
    
    //Constructor:
    public FilesList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    //Agregar archivo;
    public void addFile(FileNode newNode){
        if (this.first == null) {
            first = last = newNode;
        }
        else{
            last.setNext(newNode);
            last = newNode;
        }
        size ++;
    }
    
    //Imprimir Lista.
    public String printList(){
        String list = "";
        if (this.first == null){
            list = "Esta lista se encuentra actualmente vacia.";
            return list;
        }
        else{
            FileNode tracker = first;
            while (tracker != null){
                list += tracker.getTitle() + ", " + tracker.getSize() + "\n";
                tracker = tracker.getNext();
            }
        return list;
        }
    }
    
    //Recoger el tamaño de la lista.
    public int getSize(){
        return size;
    }
    
    //Recoger el nodo en una posicion.
    public FileNode getNodeAt (int index){
        FileNode tracker = first;
        int counter = 0;
        if (index <= size){
           while (counter != index){
            tracker = tracker.getNext();
            counter ++; 
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La lista se encuentra actualmente vacia.");
        }
        return tracker;
    }
    
    //Eliminar un Nodo.
    public void deleteNode(FileNode node){
        FileNode tracker = first;
        if (tracker == node){
            first = first.getNext();
        }
        else{
            while (tracker.getNext() != node){
                tracker = tracker.getNext();
            }
            tracker.setNext(tracker.getNext().getNext());
        }
        size --;
    }
    
    //Recoger el nodo en base al nombre.
    public FileNode getNode (String title){
        FileNode tracker = first;
        while (!tracker.getTitle().equalsIgnoreCase(title)){
            tracker = tracker.getNext();
        }
    return tracker;
    }
}
