package interfaces;

public interface Arvore<E> {
    int tamanho();
    boolean estaVazia();
    Posicao<E> raiz();
}