import java.util.Random;

public class Benchmark {
    private static final int EXECUCOES = 30;
    private static final int[] TAMANHOS = {1000, 5000, 10000};

    public static void main(String[] args) {
        System.out.println("   BENCHMARK DE ALGORITMOS DE ORDENAÇÃO    ");

        for (int tamanho : TAMANHOS) {
            System.out.println(" --- Tamanho do vetor: " + tamanho + " ---");
            executarExperimento("BubbleSort - Melhor Caso", "bubble", "melhor", tamanho);
            executarExperimento("BubbleSort - Caso Médio", "bubble", "medio", tamanho);
            executarExperimento("BubbleSort - Pior Caso", "bubble", "pior", tamanho);
            executarExperimento("MergeSort - Melhor Caso", "merge", "melhor", tamanho);
            executarExperimento("MergeSort - Caso Médio", "merge", "medio", tamanho);
            executarExperimento("MergeSort - Pior Caso", "merge", "pior", tamanho);
            System.out.println();
        }
    }

    public static void executarExperimento(String nome, String algoritmo, String caso, int tamanho) {

        double[] tempos = new double[EXECUCOES];
        Random r = new Random(42);

        for (
                int i = 0;
                i < 50; i++) {
            int[] dummy = gerarVetor(caso, tamanho, r);

            if (algoritmo.equals("bubble")) {
                BubbleSort.ordenar(dummy);
            } else {
                MergeSort.ordenar(dummy);
            }
        }

        for (
                int i = 0;
                i < EXECUCOES; i++) {
            int[] vetor = gerarVetor(caso, tamanho, new Random(42 + i));
            long inicio = System.nanoTime();

            if (algoritmo.equals("bubble")) {
                BubbleSort.ordenar(vetor);
            } else {
                MergeSort.ordenar(vetor);
            }

            long fim = System.nanoTime();
            tempos[i] = (fim - inicio) / 1_000_000.00;
        }

        double media = calcularMedia(tempos);
        double desvioPadrão = calcularDesvioPadrao(tempos, media);

        System.out.printf("%-40s | Média: %10.4f ms | Desvio Padrão: %10.4f ms%n", nome, media, desvioPadrao);
    }


}
