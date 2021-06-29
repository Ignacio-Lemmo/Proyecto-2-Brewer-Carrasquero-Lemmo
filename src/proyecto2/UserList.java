package proyecto2;

import javax.swing.JOptionPane;

/**
 * @author Ignacio
 */
public class UserList {
    //Atributos:
    private UserNode first;
    private UserNode last;
    private int size;
    
    //Constructor:
    public UserList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    //Agregar usuario.
    public void addUser(UserNode newNode){
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
            UserNode tracker = first;
            while (tracker != null){
                list += tracker.getName() + ": " + tracker.getPriorityString() + "\n";
                tracker = tracker.getNext();
            }
        return list;
        }
    }
    
    //Recoger el tamaño de la Lista.
    public int getSize(){
        return size;
    }
    
    //Recoger el nodo en una posicion.
    public UserNode getNodeAt (int index){
        UserNode tracker = first;
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
    
    //Recoger el nodo en base al nombre.
    public UserNode getNode (String name){
        UserNode tracker = first;
        while (!tracker.getName().equalsIgnoreCase(name)){
            tracker = tracker.getNext();
        }
    return tracker;
    }
    
    //Eliminar un Nodo.
    public void deleteNode(UserNode node){
        UserNode tracker = first;
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
    
    //Guardar cambios Lista.
    public String saveList(){
        String list = "usuario;tipo\n";
        if (this.first == null){
            list = "";
            return list;
        }
        else{
            UserNode tracker = first;
            while (tracker != null){
                list += tracker.getName() + ";" + tracker.getPriorityString() + "\n";
                tracker = tracker.getNext();
            }
        return list;
        }
    }
}
