/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class ObraLiteraria {
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String genero;
    private int numeroPaginas;
    private String idioma;
    private boolean emprestado;
    private int numCopias;

    public ObraLiteraria() {
    }
    public ObraLiteraria(int id, String titulo, String autor, String editora, int anoPublicacao, String genero, int numeroPaginas, String idioma, boolean emprestado, int numCopias) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.idioma = idioma;
        this.emprestado = emprestado;
        this.numCopias = numCopias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    @Override
    public String toString() {
        return "ObraLiteraria{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", anoPublicacao=" + anoPublicacao + ", genero=" + genero + ", numeroPaginas=" + numeroPaginas + ", idioma=" + idioma + ", emprestado=" + emprestado + ", numCopias=" + numCopias + '}';
    }
}
