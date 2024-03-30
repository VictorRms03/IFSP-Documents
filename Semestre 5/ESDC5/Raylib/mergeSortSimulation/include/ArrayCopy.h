#pragma once

#include <stdio.h>
#include <stdlib.h>

struct GameWorld;

typedef struct ArrayCopy {
    int* data;
    size_t size;
    struct ArrayCopy* previous;
    int leftPosition;
    int middlePosition;
    int rightPosition;
} ArrayCopy;

ArrayCopy* createArrayCopy( struct GameWorld* gw, int firstPosition, int middlePosition, int rightPosition );
void destroyArrayCopy( ArrayCopy* copy );