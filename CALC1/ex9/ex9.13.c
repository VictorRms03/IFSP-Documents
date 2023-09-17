#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char str[41];
    int tam;
    int a = 0;
    int e = 0;
    int i = 0;
    int o = 0;
    int u = 0;

    printf("Frase: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    tam = strlen(str);

    for (int j=0; j<tam; j++){
        if (str[j] == 'a' || str[j] == 'A'){
            a++;
        }
        if (str[j] == 'e' || str[j] == 'E'){
            e++;
        }
        if (str[j] == 'i' || str[j] == 'I'){
            i++;
        }
        if (str[j] == 'o' || str[j] == 'O'){
            o++;
        }
        if (str[j] == 'u' || str[j] == 'U'){
            u++;
        }
    }

    printf("A/a: %d\n", a);
    printf("E/e: %d\n", e);
    printf("I/i: %d\n", i);
    printf("O/o: %d\n", o);
    printf("U/u: %d", u);
}
