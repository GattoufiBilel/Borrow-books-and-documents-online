package Beans;

public class Livre {
    
    private int codeLivre;
    private String titre;
    private double prix;
    private String dateAchat;
    private String nomEdit ;
    private int disponibilite ; 
    private int nombreCopie ; 
    
    public Livre() {}

    public Livre(String titre, double prix, String dateAchat, String nomEdit,int disponibilite, int nombreCopie) {
        this.titre = titre;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.nomEdit = nomEdit;
        this.disponibilite = disponibilite ;
        this.nombreCopie = nombreCopie ; 
    }
    
    

    public Livre(int code , String titre , double prix , String date , String nomEdit , int disponibilite , int nombreCopie) 
    {
        this.codeLivre = code;
        this.titre = titre;
        this.prix = prix;
        this.dateAchat = date;
        this.nomEdit = nomEdit;
        this.disponibilite = disponibilite ; 
        this.nombreCopie = nombreCopie ;
    }

    public void setCodeLivre(int codeLivre) {
        this.codeLivre = codeLivre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }



    public int getCodeLivre() {
        return codeLivre;
    }

    public String getTitre() {
        return titre;
    }

    public double getPrix() {
        return prix;
    }

    public String getDateAchat() {
        return dateAchat;
    }


    public String getNomEdit() {
        return nomEdit;
    }

    public void setNomEdit(String nomEdit) {
        this.nomEdit = nomEdit;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getNombreCopie() {
        return nombreCopie;
    }

    public void setNombreCopie(int nombreCopie) {
        this.nombreCopie = nombreCopie;
    }

    
    


    
}
