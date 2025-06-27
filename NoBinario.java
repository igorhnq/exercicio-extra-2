import interfaces.Posicao;

public class NoBinario<E> implements Posicao<E> {

    private E elemento;
    private NoBinario<E> pai;
    NoBinario<E> esquerdo;
    NoBinario<E> direito;

    public NoBinario(E elemento, NoBinario<E> pai) {
        this.elemento = elemento;
        this.pai = pai;
    }

    @Override
    public E getElemento() {
        return elemento;
    }
}