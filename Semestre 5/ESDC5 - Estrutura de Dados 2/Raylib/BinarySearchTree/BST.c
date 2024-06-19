#include <stdio.h>
#include <stdlib.h>
#include "raylib.h"
#include "BST.h"

BST* newBST() {

    BST* abb = (BST*) malloc( sizeof( BST ) );
    abb->root = NULL;
    abb->size = 0;

    return abb;

}

void bstPut( BST* abb, int key ) {
    abb->root = bstPutR( abb->root, key );
}

BSTNode* bstPutR( BSTNode* node, int key ) {

    if ( node == NULL ) {
        BSTNode* newNode = (BSTNode*) malloc( sizeof(BSTNode) );
        newNode->left = NULL;
        newNode->right = NULL;
        newNode->key = key;
        newNode->rank = 0;
        newNode->level = 0;
        return newNode;
    } else {
        if ( key < node->key ) {
            node->left = bstPutR( node->left, key );
        } else if ( key > node->key ) {
            node->right = bstPutR( node->right, key );
        } else {
            // value update if storing value
        }
    }

    return node;

}

void bstPreOrder( BSTNode* node ) {
    if ( node != NULL ) {
        bstPrintNode( node );
        bstPreOrder( node->left );
        bstPreOrder( node->right );
    }
}

void bstInOrder( BSTNode* node ) {
    if ( node != NULL ) {
        bstInOrder( node->left );
        bstPrintNode( node );
        bstInOrder( node->right );
    }
}

void bstPostOrder( BSTNode* node ) {
    if ( node != NULL ) {
        bstPostOrder( node->left );
        bstPostOrder( node->right );
        bstPrintNode( node );
    }
}

void bstProcess( BSTNode* node, int* currentRank, int level, int *maxLevel ) {
    if ( node != NULL ) {
        bstProcess( node->left, currentRank, level+1, maxLevel );
        node->rank = *currentRank;
        node->level = level;
        (*currentRank)++;
        bstProcess( node->right, currentRank, level+1, maxLevel );
        if ( *maxLevel < node->level ) {
            *maxLevel = node->level;
        }
    }
}

void bstDraw( BST *bst ) {
    routeDraw(bst->root);
}

void routeDraw( BSTNode *node ) {

    int margin = 100;

    if( node != NULL){
        DrawCircleLines( margin + 50*node->rank , margin + 50*node->level , 20 , BLACK );
        DrawText( TextFormat("%d", node->key) , margin + 50*node->rank - 10, margin + 50*node->level - 10, 20, BLACK);

        if( node->right != NULL ){
            DrawLine( (margin + 50*node->rank) + 15,  (margin + 50*node->level) + 15, margin + 50*(node->right->rank), margin + 50*(node->right->level) - 20, BLACK);
        }
        if( node->left != NULL ){
            DrawLine( (margin + 50*node->rank) - 15,  (margin + 50*node->level) + 15, margin + 50*(node->left->rank), margin + 50*(node->left->level) - 20, BLACK);
        }

        routeDraw( node->left );
        routeDraw( node->right );

    }

}

void bstPrintNode( BSTNode *node ) {
    printf( "%d (%d/%d) ", node->key, node->rank, node->level );
}