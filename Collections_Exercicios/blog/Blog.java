import java.util.*;

public class Blog {
    
    private List<Post> posts;

    public Blog(){
        posts = new ArrayList<Post>();
    }

    public void adicionarPostagem(Post post) {
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        
        for(Post p : posts) {
            autores.add(p.getAutor());
        }

        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        // treeMap para garantir que as chaves (nomes das categorias) sejam ordenadas
        Map<String, Integer> contagemPorCategoria = new TreeMap<>(); 

        for (Post post : posts) {
            String categoria = post.getCategoria(); 
            contagemPorCategoria.put(categoria, contagemPorCategoria.getOrDefault(categoria, 0) + 1);
        }
        return contagemPorCategoria;
    }
}

