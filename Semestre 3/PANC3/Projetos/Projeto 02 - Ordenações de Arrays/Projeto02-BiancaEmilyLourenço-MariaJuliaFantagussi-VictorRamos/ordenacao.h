/* Variaveis Globais */
int *arrayOriginal; //Array Original a ser ordenado
int *arrayA;        //Array Temporario para Manipulacao - Para nao perder dados originais
int n;              //Tamanho do Array a ser  ordenado

int numComparacoesIS, numTrocasIS; //Variaveis para o Insertion Sort
int numComparacoesOB, numTrocasOB; //Variaveis para o Ordenação Binaria
int Inc, numComparacoesSS, numTrocasSS; //Variaveis para o Shell Sort
int numComparacoesBS, numTrocasBS; //Variaveis para o Bubble Sort
int numComparacoesSK, numTrocasSK; //Variaveis para o Shake Sort
int numComparacoesCS, numTrocasCS; //Variaveis para o Comb Sort
int numComparacoesQS, numTrocasQS; //Variaveis para o Quick Sort
int numComparacoesSL, numTrocasSL; //Variaveis para o Select Sort
int numComparacoesHS, numTrocasHS; //Variaveis para o Heap Sort
int numComparacoesMS, numTrocasMS; //Variaveis para o Merge Sort
int numComparacoesRS,numTrocasRS; // Variaveis para o Radix Sort
int numComparacoesDS,numTrocasDS; // Variaveis para o Triple Sort

/* Prototipos de Funcoes */
void geraArrayAleatorio(int arrayOriginal[], int n);
void imprimeArray(int arrayA[], int n);
void copiaValoresArray(int arrayOriginal[], int arrayA[], int n);

void insertionSort(int arrayA[], int n);

void OrdenaBinaria(int arrayA[], int n);

void OrdenaShellSort(int arrayA[], int Inc, int SegCorrente);

void OrdenaBubbleSort(int arrayA[], int n);

void OrdenaShakeSort(int arrayA[],int );

void OrdenaCombSort(int arrayA[],int n);

void OrdenaQuickSortRecursivo(int arrayA[], int inicio, int fim);

void OrdenaSelectSort(int arrayA[]);

void heapSort(int arrayA[], int n);
void Heap(int arrayA[], int n, int i);

void MergeSortRecursivo(int arrayA[], int n, int inicio, int fim);
void IntercalaSemSentinela(int arrayA[], int n, int inicio, int meio, int fim);

void OrdenaRadixSort(int Vet[],int Max);

void OrdenaDoubleSort(int arrayA[], int n);
void insertionSortDouble(int arrayA[], int n);
void OrdenaBubbleSortDouble(int arrayA[], int n);
