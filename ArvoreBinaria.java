import interfaces.Arvore;
import interfaces.Posicao;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria<E extends Comparable<E>> implements Arvore<E> {
    private NoBinario<E> raiz;
    private int tamanho = 0;
    
    @Override
    public int tamanho() {
        return tamanho;
    }
    
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    @Override
    public Posicao<E> raiz() {
        return raiz;
    }
    
    public void setRaiz(NoBinario<E> raiz) {
        this.raiz = raiz;
        if (raiz != null) {
            this.tamanho = 1;
        } else {
            this.tamanho = 0;
        }
    }
    
    public void incrementarTamanho() {
        this.tamanho++;
    }
    
    public void imprimirPorNivel() {
        if (estaVazia()) {
            System.out.println("Árvore vazia");
            return;
        }
        
        Queue<NoBinario<E>> fila = new LinkedList<>();
        fila.add(raiz);
        int nivel = 0;
        
        while (!fila.isEmpty()) {
            int elementosNoNivel = fila.size();
            System.out.print("Nível " + nivel + ": ");
            
            for (int i = 0; i < elementosNoNivel; i++) {
                NoBinario<E> no = fila.poll();
                System.out.print(no.getElemento());
                
                if (no.esquerdo != null) {
                    fila.add(no.esquerdo);
                }
                if (no.direito != null) {
                    fila.add(no.direito);
                }
                
                if (i < elementosNoNivel - 1) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nivel++;
        }
    }
    
    public boolean estaDesbalanceada() {
        return verificaDesbalanceamento(raiz) != -1;
    }

    private int verificaDesbalanceamento(NoBinario<E> no) {
        if (no == null) return 0;
        int alturaEsq = verificaDesbalanceamento(no.esquerdo);
        if (alturaEsq == -1) return -1;
        int alturaDir = verificaDesbalanceamento(no.direito);
        if (alturaDir == -1) return -1;
        if (Math.abs(alturaEsq - alturaDir) > 1) return -1;
        return Math.max(alturaEsq, alturaDir) + 1;
    }
}