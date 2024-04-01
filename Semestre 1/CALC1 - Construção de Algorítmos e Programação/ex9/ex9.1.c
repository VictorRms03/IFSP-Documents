#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {

    char str[41];

    printf( "String: ");
    fgets(str, 41, stdin);
    str[strlen(str)-1] = '\0';

    printf( "%c, %c, %c, %c.", str[0], str[1], str[2], str[3]);

    return 0;
}
