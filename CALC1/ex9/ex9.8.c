#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char str[3][41];

    for (int i=0;i<3;i++){
        printf("String 1: ");
        fgets(str,41,stdin);
        str[i][strlen(str[i])-1] = '\0';
    }

    if ((strcmp(str[0], str[1]) > 0) && (strcmp(str[0], str[2]) > 0)){
        printf("%s, "str[0]);
    } else if ((strcmp(str[1], str[0]) > 0) && (strcmp(str[1], str[2]) > 0)){
        printf("%s, "str[1]);
    } else if ((strcmp(str[2], str[0]) > 0) && (strcmp(str[2], str[1]) > 0)){
        printf("%s, "str[2]);
    }
}
