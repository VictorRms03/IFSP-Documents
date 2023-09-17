#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char str[5][2][41];

    for (int i=0;i<5;i++){
        for (int j=0;j<2;j++){
            printf( "Par %d, palavra %d: ",i+1, j+1);
            fgets(str[i][j],41,stdin);
            str[i][j][strlen(str[i][j])-1] = '\0';
        }
    }

    for (int i=0;i<5;i++){
        if(strcmp(str[i][0], str[i][1]) > 0){
            printf("%s - %s: ORDEM DECRESCENTE\n", str[i][0], str[i][1]);
        } else if (strcmp(str[i][0], str[i][1]) < 0){
            printf("%s - %s: ORDEM CRESCENTE\n", str[i][0], str[i][1]);
        } else {
            printf("%s - %s: IGUAIS\n", str[i][0], str[i][1]);
        }
    }

}
