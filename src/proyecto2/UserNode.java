package proyecto2;

/**
 * @author Ignacio
 */
public class UserNode {
    
    //Atributos:
    private String userName;
    private String userPriorityString;
    private int userPriorityNumber;
    public FilesList filesList;
    private UserNode next;
    
    //Constructor:
    public UserNode (String name, String priority){
        this.userName = name;
        this.userPriorityString = priority;
        if (priority.equalsIgnoreCase("prioridad_baja")) {
            this.userPriorityNumber = 1;
        }
        else if (priority.equalsIgnoreCase("prioridad_media")) {
            this.userPriorityNumber = 2;
        }
        else if (priority.equalsIgnoreCase("prioridad_alta")) {
            this.userPriorityNumber = 3;
        }
        else{
            this.userPriorityNumber = 0;
        }
        this.filesList = new FilesList();
        this.next = null;
    }
    
    //Recoger el Nodo que le sigue.
    public UserNode getNext(){
        return next;
    }
    
    //Establecer el Nodo que le sigue.
    public void setNext(UserNode node){
        this.next = node;
    }
    
    //Recoger el nombre del Nodo.
    public String getName(){
        return userName;
    }
    
    //Establecer el nombre del Nodo.
    public void setName(String name){
        this.userName = name;
    }
    
    //Recoger la prioridad del Nodo.
    public String getPriorityString(){
        return userPriorityString;
    }
    
    //Establecer la prioridad del Nodo.
    public void setPriorityString(String priority){
        this.userPriorityString = priority;
    }
    
    //Recoger la prioridad del Nodo.
    public int getPriorityNumber(){
        return userPriorityNumber;
    }
    
    //Establecer la prioridad del Nodo.
    public void setPriorityNumber(String priority){
        if (priority.equalsIgnoreCase("prioridad_baja")) {
            this.userPriorityNumber = 1;
        }
        else if (priority.equalsIgnoreCase("prioridad_media")) {
            this.userPriorityNumber = 2;
        }
        else if (priority.equalsIgnoreCase("prioridad_alta")) {
            this.userPriorityNumber = 3;
        }
        else{
            this.userPriorityNumber = 0;
        }
    }
    
    //Recoger la lista de archivos del Nodo.
    public FilesList getFilesList(){
        return filesList;
    }
    
    //Establecer la lista de arhivos del Nodo.
    public void setFilesList(FilesList fileList){
        this.filesList = fileList;
    }
}
