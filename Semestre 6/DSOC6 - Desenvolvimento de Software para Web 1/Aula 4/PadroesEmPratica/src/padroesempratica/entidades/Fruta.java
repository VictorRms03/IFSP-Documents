/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.entidades;

/**
 *
 * @author victo
 */
public class Fruta {
    
    private int id;
    private String nome;
    private String corPredominante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorPredominante() {
        return corPredominante;
    }

    public void setCorPredominante(String corPredominante) {
        this.corPredominante = corPredominante;
    }

    @Override
    public String toString() {
        return "Fruta{" + "id=" + id + ", nome=" + nome + ", corPredominante=" + corPredominante + '}';
    }
    
}
