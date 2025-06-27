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
        
        System.out.println("\nTestando se a árvore está desbalanceada:");
        System.out.println("=========================================");
        System.out.println("Árvore está desbalanceada? " + arvore.estaDesbalanceada());
        
        System.out.println("\nCriando uma árvore desbalanceada para teste:");
        System.out.println("=============================================");
        ArvoreBinaria<Integer> arvoreDesbalanceada = new ArvoreBinaria<>();
        
        NoBinario<Integer> raizDesb = new NoBinario<>(50, null);
        NoBinario<Integer> no30Desb = new NoBinario<>(30, raizDesb);
        NoBinario<Integer> no20Desb = new NoBinario<>(20, no30Desb);
        NoBinario<Integer> no10Desb = new NoBinario<>(10, no20Desb);
        
        raizDesb.esquerdo = no30Desb;
        no30Desb.esquerdo = no20Desb;
        no20Desb.esquerdo = no10Desb;
        
        arvoreDesbalanceada.setRaiz(raizDesb);
        for (int i = 1; i < 4; i++) {
            arvoreDesbalanceada.incrementarTamanho();
        }
        
        System.out.println("Árvore desbalanceada:");
        arvoreDesbalanceada.imprimirPorNivel();
        System.out.println("Árvore está desbalanceada? " + arvoreDesbalanceada.estaDesbalanceada());
        
        System.out.println("\nTestando com árvore vazia:");
        System.out.println("===========================");
        ArvoreBinaria<Integer> arvoreVazia = new ArvoreBinaria<>();
        arvoreVazia.imprimirPorNivel();
        System.out.println("Árvore vazia está desbalanceada? " + arvoreVazia.estaDesbalanceada());
    }
} 