#include <stdio.h>
#include <ctype.h>
#define LETTER 0
#define DIGIT 1
#define UNKNOWN 99
#define INT_LIT 10
#define IDENT 11
#define ASSIGN_OP 20
#define ADD_OP 21
#define SUB_OP 22
#define MULT_OP 23
#define DIV_OP 24
#define LEFT_PAREN 25
#define RIGHT_PAREN 26
#define FOR_CODE 30
#define IF_CODE 31
#define ELSE_CODE 32
#define WHILE_CODE 33
#define DO_CODE 34
#define INT_CODE 35
#define FLOAT_CODE 36
#define SWITCH_CODE 37
#define CASE_CODE 38
#define CHAVE_ESQ 39
#define CHAVE_DIR 40

int charClass;
char lexeme [100];
char nextChar;
int lexLen;
int token;
int nextToken;
void addChar();
void getChar();
void getNonBlank();
int lex();
void codesLetter();

FILE *in_fp, *fopen();

int main() {
    if ((in_fp = fopen("front.in", "r")) == NULL)
        printf("ERROR - cannot open front.in \n");
    else {
        getChar();
    do {
        lex();
        } while (nextToken != EOF);
    }
}

int lookup(char ch) {

    switch (ch) {

    case '(':
        addChar();
        nextToken = LEFT_PAREN;
        break;
    case ')':
        addChar();
        nextToken = RIGHT_PAREN;
        break;
    case '+':
        addChar();
        nextToken = ADD_OP;
        break;
    case '-':
        addChar();
        nextToken = SUB_OP;
        break;
    case '*':
        addChar();
        nextToken = MULT_OP;
        break;
    case '/':
        addChar();
        nextToken = DIV_OP;
        break;
    case '{':
        addChar();
        nextToken = CHAVE_ESQ;
        break;
    case '}':
        addChar();
        nextToken = CHAVE_DIR;
        break;
    default:
        addChar();
        nextToken = EOF;
        break;
    }

    return nextToken;
}

void addChar() {

    if (lexLen <= 98) {
    lexeme[lexLen++] = nextChar;
    lexeme[lexLen] = 0;
    } else
        printf("Error - lexeme is too long \n");
}

void getChar() {
    if ((nextChar = getc(in_fp)) != EOF) {
        if (isalpha(nextChar))
            charClass = LETTER;
            else if (isdigit(nextChar))
                charClass = DIGIT;
                    else charClass = UNKNOWN;
 }
    else
        charClass = EOF;
}

void getNonBlank() {
    while (isspace(nextChar))
        getChar();
}

int lex() {
    lexLen = 0;
    getNonBlank();
    switch (charClass) {

        case LETTER:
            addChar();
            getChar();
            while (charClass == LETTER || charClass == DIGIT) {
                addChar();
                getChar();
            }
            codesLetter();
            break;

        case DIGIT:
            addChar();
            getChar();
            while (charClass == DIGIT) {
                addChar();
                getChar();
            }
            nextToken = INT_LIT;
            break;

        case UNKNOWN:
            lookup(nextChar);
            getChar();
            break;

        case EOF:
            nextToken = EOF;
            lexeme[0] = 'E';
            lexeme[1] = 'O';
            lexeme[2] = 'F';
            lexeme[3] = 0;
            break;

    }

    printf("Next token is: %d, Next lexeme is %s\n", nextToken, lexeme);
    return nextToken;
}

void codesLetter() {
    if (strcmp(lexeme, "for") == 0) {
        nextToken = FOR_CODE;
    } else  if (strcmp(lexeme, "if") == 0){
        nextToken = IF_CODE;
    } else  if (strcmp(lexeme, "else") == 0){
        nextToken = ELSE_CODE;
    } else  if (strcmp(lexeme, "while") == 0){
        nextToken = WHILE_CODE;
    } else  if (strcmp(lexeme, "do") == 0){
        nextToken = DO_CODE;
    } else  if (strcmp(lexeme, "int") == 0){
        nextToken = INT_CODE;
    } else  if (strcmp(lexeme, "float") == 0){
        nextToken = FLOAT_CODE;
    } else  if (strcmp(lexeme, "switch") == 0){
        nextToken = SWITCH_CODE;
    } else  if (strcmp(lexeme, "case") == 0){
        nextToken = CASE_CODE;
    } else {
        nextToken = IDENT;
    }
}
