#include <stdbool.h>

#ifndef TETROMINOES_MACROS
  #define TT true
  #define FF false
  #define TETROMINOES_MACROS
#endif

bool tetrominoeZ[4][4][4] = {

    { { TT, TT, FF, FF },
      { FF, TT, TT, FF },
      { FF, FF, FF, FF },
      { FF, FF, FF, FF } },

    { { FF, FF, TT, FF },
      { FF, TT, TT, FF },
      { FF, TT, FF, FF },
      { FF, FF, FF, FF } },

    { { FF, FF, FF, FF },
      { TT, TT, FF, FF },
      { FF, TT, TT, FF },
      { FF, FF, FF, FF } },

    { { FF, TT, FF, FF },
      { TT, TT, FF, FF },
      { TT, FF, FF, FF },
      { FF, FF, FF, FF } }

};

// { width, height, columnOffset, lineOffset }
int tetrominoeZDimensions[4][4] = {
    { 3, 2, 0, 0 },
    { 2, 3, 1, 0 },
    { 3, 2, 0, 1 },
    { 2, 3, 0, 0 }
};