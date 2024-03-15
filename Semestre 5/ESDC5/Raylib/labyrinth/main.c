/**
 * @file main.c
 * @author Prof. Dr. David Buzatto
 * @brief Main function and logic for the game. Base template for game
 * development in C using Raylib (https://www.raylib.com/).
 * 
 * @copyright Copyright (c) 2024
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>
#include <math.h>
#include <string.h>
#include <time.h>
#include <assert.h>

/*---------------------------------------------
 * Library headers.
 --------------------------------------------*/
#include <raylib.h>
//#include <raymath.h>

//#define RAYGUI_IMPLEMENTATION
//#include <raygui.h>
//#undef RAYGUI_IMPLEMENTATION

/*---------------------------------------------
 * Project headers.
 --------------------------------------------*/
#include <utils.h>

/*---------------------------------------------
 * Macros. 
 --------------------------------------------*/
#define WINDOW_WIDTH 800
#define WINDOW_HEIGHT 450
#define WINDOW_TITLE "Window Title"
#define WINDOW_TARGET_FPS 60
#define WINDOW_ANTIALIASING
//#define WINDOW_RESIZABLE
//#define WINDOW_FULL_SCREEN
//#define WINDOW_UNDECORATED
//#define WINDOW_ALWAYS_ON_TOP
//#define WINDOW_ALWAYS_RUN
//#define WINDOW_INIT_AUDIO
#define LINHAS 5
#define COLUNAS 6

/*--------------------------------------------
 * Constants. 
 -------------------------------------------*/


/*---------------------------------------------
 * Custom types (enums, structs, unions etc.).
 --------------------------------------------*/
typedef struct GameWorld {
    int dummy;
} GameWorld;


/*---------------------------------------------
 * Global variables.
 --------------------------------------------*/
GameWorld gw;
bool labirinto[LINHAS][COLUNAS] = {
    { false, false, false, false, true, false },
    { false, true, true, false, false, false },
    { false, false, false, false, true, false },
    { true, false, true, true, true, true },
    { false, false, false, false, false ,false }
};

char saida[LINHAS][COLUNAS] = { 0 };
bool temSolucao;

/*---------------------------------------------
 * Function prototypes. 
 --------------------------------------------*/
/**
 * @brief Reads user input and updates the state of the game.
 * @param gw GameWorld struct pointer.
 */
void inputAndUpdate( GameWorld *gw );

/**
 * @brief Draws the state of the game.
 * @param gw GameWorld struct pointer.
 */
void draw( const GameWorld *gw );

/**
 * @brief Create the global Game World object and all of its dependecies.
 */
void createGameWorld( void );

/**
 * @brief Destroy the global Game World object and all of its dependencies.
 */
void destroyGameWorld( void );

/**
 * @brief Load game resources like images, textures, sounds,
 * fonts, shaders etc.
 */
void loadResources( void );

/**
 * @brief Unload the once loaded game resources.
 */
void unloadResources( void );

bool resolver(int linhaFonte, int colunaFonte, int linhaAlvo, int colunaAlvo);
bool ehValido(int linha, int coluna);

int main( void ) {

    #ifdef WINDOW_ANTIALIASING
        SetConfigFlags( FLAG_MSAA_4X_HINT );
    #endif

    #ifdef WINDOW_RESIZABLE
        SetConfigFlags( FLAG_WINDOW_RESIZABLE );
    #endif

    #ifdef WINDOW_FULL_SCREEN
        SetConfigFlags( FLAG_FULLSCREEN_MODE );
    #endif

    #ifdef WINDOW_UNDECORATED
        SetConfigFlags( FLAG_WINDOW_UNDECORATED );
    #endif

    #ifdef WINDOW_ALWAYS_ON_TOP
        SetConfigFlags( FLAG_WINDOW_TOPMOST );
    #endif

    #ifdef WINDOW_ALWAYS_RUN
        SetConfigFlags( FLAG_WINDOW_ALWAYS_RUN );
    #endif

    InitWindow( WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TITLE );
    #ifdef WINDOW_INIT_AUDIO
        InitAudioDevice();
    #endif
    SetTargetFPS( WINDOW_TARGET_FPS );    

    loadResources();
    createGameWorld();
    while ( !WindowShouldClose() ) {
        inputAndUpdate( &gw );
        draw( &gw );
    }
    unloadResources();
    destroyGameWorld();

    #ifdef WINDOW_INIT_AUDIO
        CloseAudioDevice();
    #endif
    CloseWindow();
    return 0;

}

void inputAndUpdate( GameWorld *gw ) {

}

void draw( const GameWorld *gw ) {

    BeginDrawing();
    ClearBackground( WHITE );

    const int largQuadrado = 50;

    for (int i = 0; i < LINHAS; i++){
        for (int j = 0; j < COLUNAS; j++){

            Color c = WHITE;

            int xc = (largQuadrado/2) + (i * largQuadrado);
            int yc = (largQuadrado/2) + (j * largQuadrado);

            switch (saida[i][j]){
                case 'x': c = BLACK; break;
                case ' ': c = WHITE; break;
                case 'r': c = GREEN;
                break;
                case 'd': c = YELLOW; 


                
                 break;
                case 'l': c = RED;
                
                
                
                 break;
                case 'u': c = ORANGE;
                
                
                
                 break;
                case 's': c = BLUE; break;
                case 't': c = DARKBLUE; break;
                default : c = WHITE; break;
            }

            if (saida[i][j] == 'r'){
                DrawLine(xc,yc,xc + 20,yc,BLACK);
                DrawLine(xc + 20, yc, xc+10, yc+10, BLACK);
                DrawLine(xc + 20, yc, xc+10, yc-10, BLACK);
            }
            
            DrawRectangle(j * largQuadrado, i * largQuadrado, largQuadrado, largQuadrado, c);
            
        }
    }
    

    for (int i = 0; i <= LINHAS; i++){
        DrawLine(0, i * largQuadrado, COLUNAS * largQuadrado, i * largQuadrado, BLACK);
    }

    for (int i = 0; i <= COLUNAS; i++){
        DrawLine(i * largQuadrado, 0 , i * largQuadrado, LINHAS * largQuadrado, BLACK);
    }

    EndDrawing();

}

void createGameWorld( void ) {

    printf( "creating game world...\n" );

    gw = (GameWorld) {
        .dummy = 0
    };

    for (int i = 0; i < LINHAS; i++){
        for (int j = 0; j < COLUNAS; j++){
            if(labirinto[i][j]){
                saida[i][j] = 'x';
            }
            else{
                saida[i][j] = ' ';
            }
        }
    }

    temSolucao = resolver(0, 0, 4, 5);
}

void destroyGameWorld( void ) {
    printf( "destroying game world...\n" );
}

void loadResources( void ) {
    printf( "loading resources...\n" );
}

void unloadResources( void ) {
    printf( "unloading resources...\n" );
}

bool resolver(int linhaFonte, int colunaFonte, int linhaAlvo, int colunaAlvo){

    if (ehValido(linhaFonte, colunaFonte)){
        labirinto[linhaFonte][colunaFonte] = true;

        if (linhaFonte == linhaAlvo && colunaFonte == colunaAlvo){
            saida[linhaAlvo][colunaAlvo] = 't';
            return true;
        }

        if (resolver(linhaFonte, colunaFonte + 1, linhaAlvo, colunaAlvo)){
            saida[linhaFonte][colunaFonte] = 'r';
            return true;
        }

        if (resolver(linhaFonte + 1, colunaFonte, linhaAlvo, colunaAlvo)){
            saida[linhaFonte][colunaFonte] = 'd';
            return true;
        }

        if (resolver(linhaFonte, colunaFonte - 1, linhaAlvo, colunaAlvo)){
            saida[linhaFonte][colunaFonte] = 'l';
            return true;
        }

        if (resolver(linhaFonte - 1, colunaFonte, linhaAlvo, colunaAlvo)){
            saida[linhaFonte][colunaFonte] = 'u';
            return true;
        }
    }

    return false;
}

bool ehValido(int linha, int coluna){

    return linha >=0 && linha < LINHAS && coluna >=0 && coluna < COLUNAS && !labirinto[linha][coluna];
}