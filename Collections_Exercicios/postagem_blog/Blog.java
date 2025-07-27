import java.util.*;

public class Blog {
    private List<Post> posts;

    public Blog() {
        posts = new ArrayList<Post>();
    }

    public void adicionarPostagem(Post post) {
        for(Post p : posts) {
            if (p.getAutor().equals(post.getAutor()) 
                && p.getTitulo().equals(post.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        
        for(Post p : this.posts) {
            autores.add(p.getAutor());
        }

        return autores; 
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagemPorCategoria = new TreeMap<>();

        int contagemAtual;

        for(Post p : this.posts) {
            if (contagemPorCategoria.containsKey(p.getCategoria())) {
                contagemAtual = contagemPorCategoria.get(p.getCategoria());
            } else {
                contagemAtual = 0;
            }

            contagemPorCategoria.put(p.getCategoria(), contagemAtual + 1);
        }

        return contagemPorCategoria;        
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsResult = new TreeSet<>();

        for(Post p : this.posts) {
            if (p.getAutor().compareTo(autor) == 0) {
                postsResult.add(p);
            }
        }

        return postsResult;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsResult = new TreeSet<>();

        for(Post p : this.posts) {
            if (p.getCategoria().compareTo(categoria) == 0) {
                postsResult.add(p);
            }
        }

        return postsResult;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> result = new TreeMap<Categorias, Set<Post>>();

        for(Post p : this.posts) {
            Set<Post> posts;

            if (result.containsKey(p.getCategoria())) {
                posts = result.get(p.getCategoria());
            } else {
                posts = new TreeSet<>();
            }

            posts.add(p);
            result.put(p.getCategoria(), posts);
        }

        return result;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> result = new TreeMap<Autor, Set<Post>>();

        for(Post p : this.posts) {
            Set<Post> posts;

            if (result.containsKey(p.getAutor())) {
                posts = result.get(p.getAutor());
            } else {
                posts = new TreeSet<>();
            }

            posts.add(p);
            result.put(p.getAutor(), posts);
        }

        return result;
    }    
}