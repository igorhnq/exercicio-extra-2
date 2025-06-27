public class TesteArvore {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        
        NoBinario<Integer> raiz = new NoBinario<>(40, null);
        NoBinario<Integer> no30 = new NoBinario<>(30, raiz);
        NoBinario<Integer> no60 = new NoBinario<>(60, raiz);
        NoBinario<Integer> no20 = new NoBinario<>(20, no30);
        NoBinario<Integer> no35 = new NoBinario<>(35, no30);
        NoBinario<Integer> no50 = new NoBinario<>(50, no60);
        NoBinario<Integer> no70 = new NoBinario<>(70, no60);
        
        raiz.esquerdo = no30;
        raiz.direito = no60;
        no30.esquerdo = no20;
        no30.direito = no35;
        no60.esquerdo = no50;
        no60.direito = no70;
        
        arvore.setRaiz(raiz);
        
        for (int i = 1; i < 7; i++) {
            arvore.incrementarTamanho();
        }
        
        System.out.println("Tamanho da árvore: " + arvore.tamanho());
        System.out.println("Árvore está vazia? " + arvore.estaVazia());
        System.out.println("Raiz: " + (arvore.raiz() != null ? arvore.raiz().getElemento() : "null"));
        
        System.out.println("\nImprimindo a árvore nível por nível:");
        System.out.println("=====================================");
        arvore.imprimirPorNivel();
        
        System.out.println("\nTestando com árvore vazia:");
        System.out.println("===========================");
        ArvoreBinaria<Integer> arvoreVazia = new ArvoreBinaria<>();
        arvoreVazia.imprimirPorNivel();
    }
} 