public class MergeSort {

    public static void ordenar(int[] vetor) {
        if (vetor.length < 2) return;
        dividir(vetor, 0, vetor.length - 1);
    }

    private static void dividir(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            dividir(vetor, esquerda, meio);
            dividir(vetor, meio + 1, direita);
            mesclar(vetor, esquerda, meio, direita);
        }
    }

    private static void mesclar(int[] vetor, int esquerda, int meio, int direita) {
        int tamanhoEsq = meio - esquerda + 1;
        int tamanhoDir = direita - meio;

        int[] esq = new int[tamanhoEsq];
        int[] dir = new int[tamanhoDir];

        for (int i = 0; i < tamanhoEsq; i++) esq[i] = vetor[esquerda + i];
        for (int j = 0; j < tamanhoDir; j++) dir[j] = vetor[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;
        while (i < tamanhoEsq && j < tamanhoDir) {
            if (esq[i] <= dir[j]) {
                vetor[k++] = esq[i++];
            } else {
                vetor[k++] = dir[j++];
            }
        }
        while (i < tamanhoEsq) vetor[k++] = esq[i++];
        while (j < tamanhoDir) vetor[k++] = dir[j++];
    }
}
