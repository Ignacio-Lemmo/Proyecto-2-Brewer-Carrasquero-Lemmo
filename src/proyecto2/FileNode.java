package proyecto2;

/**
 * @author Ignacio
 */
public class FileNode {
    
    //Atrinutos:
    private String fileTitle;
    private int fileSize;
    private FileNode next;
    private boolean waiting;
    private boolean urgent;
    private String filePriorityString;
    private int filePriorityNumber;
    
    //Constructor
    public FileNode(String title, int size, String priority){
        this.fileTitle = title;
        this.fileSize = size;
        this.next = null;
        this.waiting = false;
        this.urgent = false;
        this.filePriorityString = priority;
        if (priority.equalsIgnoreCase("prioridad_baja")) {
            this.filePriorityNumber = 1;
        }
        else if (priority.equalsIgnoreCase("prioridad_media")) {
            this.filePriorityNumber = 2;
        }
        else if (priority.equalsIgnoreCase("prioridad_alta")) {
            this.filePriorityNumber = 3;
        }
        else{
            this.filePriorityNumber = 0;
        }
    }
    
    //Recoger el Nodo que le sigue.
    public FileNode getNext(){
        return next;
    }
    
    //Establecer el Nodo que le sigue.
    public void setNext(FileNode node){
        this.next = node;
    }
    
    //Recoger el titulo del Nodo.
    public String getTitle(){
        return fileTitle;
    }
    
    //Establecer el titulo del Nodo.
    public void setTitle(String title){
        this.fileTitle = title;
    }
    
    //Recoger el tamaño del Nodo.
    public int getSize(){
        return fileSize;
    }
    
    //Establecer el nombre del Nodo.
    public void setSize(int size){
        this.fileSize = size;
    }
    
    //Recoger si esta en cola de impresion.
    public boolean getWaiting(){
        return waiting;
    }
    
    //Establecer que esta en cola.
    public void setWaiting(){
        this.waiting = true;
    }
    
    //Recoger urgencia.
    public boolean getUrgency(){
        return urgent;
    }
    
    //Establecer urgencia.
    public void setUrgency(){
        this.urgent = true;
    }
    
    //Recoger prioridad del usuario.
    public int getPriorityInt(){
        return filePriorityNumber;
    }
    
    //Recoger prioridad del usuario.
    public String getPriorityString(){
        return filePriorityString;
    }
}
