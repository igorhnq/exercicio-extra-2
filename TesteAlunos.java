public class TesteAlunos {
    public static void main(String[] args) {

        ArvoreBinaria<Aluno> arvoreAlunos = new ArvoreBinaria<>();
        
        Aluno aluno1 = new Aluno("João Silva", 2021001);
        Aluno aluno2 = new Aluno("Maria Santos", 2021005);
        Aluno aluno3 = new Aluno("Pedro Oliveira", 2021003);
        Aluno aluno4 = new Aluno("Ana Costa", 2021002);
        Aluno aluno5 = new Aluno("Carlos Ferreira", 2021004);
        
        NoBinario<Aluno> raiz = new NoBinario<>(aluno3, null);
        NoBinario<Aluno> no1 = new NoBinario<>(aluno1, raiz);
        NoBinario<Aluno> no2 = new NoBinario<>(aluno2, raiz);
        NoBinario<Aluno> no3 = new NoBinario<>(aluno4, no1);
        NoBinario<Aluno> no4 = new NoBinario<>(aluno5, no2);
        
        raiz.esquerdo = no1;
        raiz.direito = no2;
        no1.direito = no3;
        no2.esquerdo = no4;
        
        arvoreAlunos.setRaiz(raiz);
        
        for (int i = 1; i < 5; i++) {
            arvoreAlunos.incrementarTamanho();
        }
        
        System.out.println("=== TESTE COM ÁRVORE DE ALUNOS ===");
        System.out.println("Tamanho da árvore: " + arvoreAlunos.tamanho());
        System.out.println("Árvore está vazia? " + arvoreAlunos.estaVazia());
        
        System.out.println("\nÁrvore de alunos nível por nível:");
        System.out.println("==================================");
        arvoreAlunos.imprimirPorNivel();
        
        System.out.println("\nPercurso em ordem (ordenado por matrícula):");
        System.out.println("============================================");
        arvoreAlunos.percursoEmOrdem();
        
        System.out.println("\nVerificação de balanceamento:");
        System.out.println("=============================");
        System.out.println("Árvore está desbalanceada? " + arvoreAlunos.estaDesbalanceada());
        
        System.out.println("\nAlunos inseridos na árvore:");
        System.out.println("============================");
        System.out.println("1. " + aluno1);
        System.out.println("2. " + aluno2);
        System.out.println("3. " + aluno3);
        System.out.println("4. " + aluno4);
        System.out.println("5. " + aluno5);
    }
} 