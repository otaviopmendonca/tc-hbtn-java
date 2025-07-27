public class Post implements Comparable {
    
    private Autor  autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Object obj) {
        Post post = (Post) obj;
        return this.titulo.compareTo(post.titulo);
    }

    public Autor  getAutor(){
        return autor;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getCorpo(){
        return corpo;
    }

    public Categorias getCategoria(){
        return categoria;
    }
}

